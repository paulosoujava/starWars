package com.paulo.starwars.presentation.ui.list


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.usecases.list.GetHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCases: GetHomeUseCase
) : ViewModel() {


    var uiStateList = MutableStateFlow(UiStateList())
        private set


    init {
        viewModelScope.launch {
            uiStateList.update {
                it.copy(
                    stateUi = Events.Regular,
                    listHome = useCases()
                )
            }
        }
    }



}