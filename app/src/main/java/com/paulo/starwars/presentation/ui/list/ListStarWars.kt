package com.paulo.starwars.presentation.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.paulo.starwars.core.Events
import com.paulo.starwars.presentation.ui.commom.ErrorState
import com.paulo.starwars.presentation.ui.commom.Loading
import com.paulo.starwars.presentation.ui.list.components.Home


@Composable
fun ListStarWars(
    navController: NavHostController,
) {

    val viewModel = hiltViewModel<ListViewModel>()
    val state = viewModel.uiStateList.collectAsState()


    when (state.value.stateUi) {
        is Events.Error -> {
            ErrorState()
        }

        Events.Loading -> {
            Loading()
        }

        Events.Regular ->
            if (state.value.listHome == null)
                ErrorState()
            else
                Home(
                    state.value.listHome!!,
                    navController = navController
                )

    }
}


