package com.paulo.starwars.presentation.ui.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.core.Events
import com.paulo.starwars.data.Result
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.usecases.profile.GetProfileUseCase
import com.paulo.starwars.presentation.ui.listItem.UiStateListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: GetProfileUseCase
) : ViewModel() {

    var uiState = MutableStateFlow(UiStateProfile())
        private set

    fun fetchData(code: String) {
        viewModelScope.launch {
            val (first, second, third) = useCase(code.toLong())
            if (first != null) {
                handlerUi(
                    first, null
                )
            } else if (second != null) {
                handlerUi(
                    null, second.message()
                )
            } else {
                handlerUi(
                    null, third.toString()
                )
            }
        }
    }

    private fun handlerUi(people:People?, error: String?) {
        uiState.update {
            it.copy(
                people = people,
                error = error,
                stateUi = Events.Regular
            )
        }
    }
}