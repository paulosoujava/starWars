package com.paulo.starwars.presentation.ui.profile

import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.models.People

data class UiStateProfile(
    val people:  People? = null,
    val error: String? = null,
    val favorite: Boolean = false,
    val stateUi: Events = Events.Loading
)
