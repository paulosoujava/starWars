package com.paulo.starwars.presentation.ui.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.domain.usecases.profile.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: GetProfileUseCase
): ViewModel()  {


    init {
        viewModelScope.launch {
            val (first, second, third) = useCase(2)
            if (first != null) {
                Log.d("TAG", " ${first.toString()}")
            } else if (second != null) {
                Log.d("TAG", " ${second.message()}")
            } else {
                Log.d("TAG", " ${third?.message}")
            }
        }
    }
}