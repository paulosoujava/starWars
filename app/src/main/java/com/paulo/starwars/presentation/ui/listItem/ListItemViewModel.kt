package com.paulo.starwars.presentation.ui.listItem

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.usecases.list.GetPeopleUseCase
import com.paulo.starwars.presentation.ui.list.UiStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ListItemViewModel @Inject constructor(
    private val useCase: GetPeopleUseCase
) : ViewModel() {

    var uiStateList = MutableStateFlow(UiStateListItem())
        private set

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val (first, second, thrid) = useCase()
            if(first != null ){
                handlerUi(first, null)
            }
            else if(second != null){
                handlerUi(null, second.message() + second.code())
            }else{
                handlerUi(null, thrid.toString())
            }

        }
    }

    private fun handlerUi(list :List<People>?, error:String?){
        uiStateList.update {
            it.copy(
                success =list,
                error = error,
                stateUi = Events.Regular
            )
        }
    }
}