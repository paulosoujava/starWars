package com.paulo.starwars.presentation.ui.list

import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.models.Home
import com.paulo.starwars.utils.Constants


data class UiStateList(
    val listHome: List<Home>? = null,
    val stateUi: Events = Events.Loading
)


