package com.paulo.starwars.presentation.ui.list


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.data.usecases.listItem.GetListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCases: GetListUseCases
) : ViewModel() {

    private val _uiStateList = MutableStateFlow(UiStateList.Loading)
    val uiState: StateFlow<UiStateList> = _uiStateList


    init {
        viewModelScope.launch {

        }
    }
}