package com.paulo.starwars.presentation.ui.listItem

import com.paulo.starwars.core.Events
import com.paulo.starwars.data.Result
import com.paulo.starwars.domain.models.People

data class UiStateListItem(
    val success: Result<People>? = null,
    val error: String? = null,
    val stateUi: Events = Events.Loading
)
