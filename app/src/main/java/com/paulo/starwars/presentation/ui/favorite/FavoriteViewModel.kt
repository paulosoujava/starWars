package com.paulo.starwars.presentation.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.usecases.favorite.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
data class FavoriteViewModel @Inject constructor(
    private val useCase: UseCases
) : ViewModel() {

    var uiStateList = MutableStateFlow(emptyList<Favorite>())
        private set

    lateinit var deletedFavorite: Favorite

    init {
        getFavorite()

    }

    fun remove() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.deleteFavoriteUseCase(deletedFavorite.id.toString())
            getFavorite()
        }

    }

    private fun getFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            uiStateList.value = useCase.getFavoriteUseCase()
        }
    }

    fun undoFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.addFavoriteUseCase(deletedFavorite)
            getFavorite()
        }
    }

    fun waitDecisionToDelete(favorite: Favorite) {
        deletedFavorite = favorite
    }

}