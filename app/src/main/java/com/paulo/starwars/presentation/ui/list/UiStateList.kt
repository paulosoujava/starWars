package com.paulo.starwars.presentation.ui.list

import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.models.Home


data class UiStateList(
    val listHome: List<Home>? = null,
    val stateUi: Events = Events.Loading
)


