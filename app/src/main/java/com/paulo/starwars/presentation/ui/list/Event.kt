package com.paulo.starwars.presentation.ui.list

import com.paulo.starwars.data.models.People

sealed class UiStateList {
    object Loading : UiStateList()
    data class Error(val message: String) : UiStateList()
    data class Success(val list: List<People>) : UiStateList()
    data class Click(val id: String? = null) : UiStateList()
    data class Search(val query: String = "") : UiStateList()
    data class Checkbox(
        val people: Boolean = true,
        val films: Boolean = true,
        val planets: Boolean = true,
        val starships: Boolean = true,
        val vehicles: Boolean = true,
    ) : UiStateList()
}


