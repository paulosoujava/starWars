package com.paulo.starwars.presentation.ui.list

import androidx.compose.material3.ExperimentalMaterial3Api
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListStarWars(
    onSearch: () -> Unit,
    onValueChange: () -> Unit,
    value: String,
    navController: NavHostController,
) {

    val viewModel = hiltViewModel<ListViewModel>()
    val state = viewModel.uiStateList.collectAsState()

    val stateFilter = remember { mutableStateOf(false) }

    when (state.value.stateUi) {
        is Events.Error -> {
           ErrorState()
        }

        Events.Loading -> {
            Loading()
        }

        Events.Regular -> state.value.listHome?.let {
            Home(
                it,
                stateFilter = stateFilter,
                navController = navController
            )
        }
    }
}


