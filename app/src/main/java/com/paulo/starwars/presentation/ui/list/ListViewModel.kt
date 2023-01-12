package com.paulo.starwars.presentation.ui.list


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListViewModel(

) : ViewModel() {

    private val _uiStateList = MutableStateFlow(UiStateList.Loading)
    val uiState: StateFlow<UiStateList> = _uiStateList


    init {
        viewModelScope.launch {

        }
    }
}