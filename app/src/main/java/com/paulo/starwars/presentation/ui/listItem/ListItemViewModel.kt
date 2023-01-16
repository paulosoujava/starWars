package com.paulo.starwars.presentation.ui.listItem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.starwars.core.Events
import com.paulo.starwars.data.framework.network.Result
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.usecases.listItem.GetListItemDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListItemViewModel @Inject constructor(
    private val useCase: GetListItemDetailUseCase
) : ViewModel() {

    val page = MutableStateFlow(1L)
    val currentPage = MutableStateFlow(0)

    var uiStateList = MutableStateFlow(UiStateListItem())
        private set

    fun fetchData(page: Long = 1) {
        viewModelScope.launch {
            getItems(page)
        }
    }

    private fun handlerUi(result: Result<People>?, error: String?) {
        uiStateList.update {
            it.copy(
                success = result,
                error = error,
                stateUi = Events.Regular
            )
        }
    }

    fun setPage(isIncrement: Boolean) {
        uiStateList.value = uiStateList.value.copy(
            stateUi = Events.Loading
        )

        if (isIncrement) {
            currentPage.value = currentPage.value + 10
            page.value = page.value + 1
        } else {
            page.value =  page.value - 1

            if (page.value == 1L)
                currentPage.value = 0
        }

        fetchData(page.value)
    }

    private suspend fun getItems(page: Long) {
        val (first, second, third) = useCase(page)

        if (first != null) {
            handlerUi(first, null)
        } else if (second != null) {
            handlerUi(null, second.message() + second.code())
        } else {
            handlerUi(null, third?.message)
        }
    }
}