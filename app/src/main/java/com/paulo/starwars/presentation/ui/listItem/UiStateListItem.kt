package com.paulo.starwars.presentation.ui.listItem

import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.models.People

data class UiStateListItem(
    val success: List<People>? = null,
    val error: String? = null,
    val stateUi: Events = Events.Loading
)
