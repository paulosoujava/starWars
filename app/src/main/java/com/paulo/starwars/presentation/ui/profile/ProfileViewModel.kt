package com.paulo.starwars.presentation.ui.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.usecases.profile.UseCases
import com.paulo.starwars.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: UseCases
) : ViewModel() {

    var uiState = MutableStateFlow(UiStateProfile())
        private set


    fun getFavorite(code: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val favorite = useCase.getFavoriteByCodeUseCase(code.toString())
            handlerUiFavorite(favorite!=null)
        }
    }


    fun fetchData(code: Int) {
        viewModelScope.launch {
            val (first, second, third) = useCase.getProfileUseCase(code.toLong())
            if (first != null) {
                handlerUi(first, null)
            } else if (second != null) {
                handlerUi(null, second.message())
            } else {
                handlerUi(null, third.toString())
            }
        }
    }

    fun favorite(code: String, name: String, urlPhoto: String) {
        if (!uiState.value.favorite) {
           handlerUiFavorite(true)
            save(code, name, urlPhoto)
        } else {
            handlerUiFavorite(false)
            delete(code)
        }


    }


    private fun handlerUi(people: People?, error: String?) {
        uiState.update {
            it.copy(
                people = people,
                error = error,
                stateUi = Events.Regular
            )
        }
    }
    private fun handlerUiFavorite(isFavorite: Boolean) {
        uiState.update {
            it.copy(
                favorite = isFavorite
            )
        }
    }
    private fun delete(code: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.deleteFavoriteUseCase(code)

        }
    }
    private fun save(code: String, name: String, urlPhoto: String) {
        val favorite = Favorite(
            id = code.toInt(),
            name = name,
            urlPhoto = "${Constants.BASE_PATH_CHARACTERES}$urlPhoto"
        )
        viewModelScope.launch(Dispatchers.IO) {
            useCase.addFavoriteUseCase(favorite)

        }
    }
}