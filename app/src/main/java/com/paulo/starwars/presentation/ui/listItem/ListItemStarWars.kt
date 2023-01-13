package com.paulo.starwars.presentation.ui.listItem

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.paulo.starwars.core.Events
import com.paulo.starwars.presentation.ui.commom.ErrorState
import com.paulo.starwars.presentation.ui.commom.Loading
import com.paulo.starwars.presentation.ui.commom.TopBar
import com.paulo.starwars.presentation.ui.listItem.components.ListDetail
import com.paulo.starwars.presentation.ui.listItem.components.ListItemCardStarWars
import com.paulo.starwars.utils.Constants


@Composable
fun ListItemStarWars(
    navController: NavHostController
) {

    val viewModel = hiltViewModel<ListItemViewModel>()
    val state = viewModel.uiStateList.collectAsState()
    LaunchedEffect(true) {
        viewModel.fetchData()
    }

    when (state.value.stateUi) {
        is Events.Error -> ErrorState(navController)
        Events.Loading -> Loading()
        Events.Regular -> {
            if (state.value.success != null) {
                ListDetail(list = state.value.success!!, navController = navController)
            } else {
                ErrorState(navController)
            }
        }
    }


}