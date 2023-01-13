package com.paulo.starwars.presentation.ui.listItem

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.domain.usecases.list.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListItemViewModel @Inject constructor(
    private val useCase: GetPeopleUseCase
) : ViewModel() {

    fun fetchData(args: Bundle?) {
        Log.d("TAG", "HERE")
        viewModelScope.launch(Dispatchers.IO) {
            useCase().forEach {
                Log.d("TAG", it.name)
            }
        }
    }
}