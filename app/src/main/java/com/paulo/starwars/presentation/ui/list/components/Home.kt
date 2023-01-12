package com.paulo.starwars.presentation.ui.list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.paulo.starwars.domain.models.Home
import com.paulo.starwars.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    ListHome: List<Home>,
    stateFilter: MutableState<Boolean>,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopBarHome(stateFilter)

        }
    ) {


        LazyColumn(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ),
            content = {
                items(ListHome, key = { it -> it.title }) { item ->
                    ListCardStarWars(
                        title = item.title,
                        urlImage = item.url
                    ) {

                        navController.navigate(Constants.ITEM_PAGE)
                    }
                }
            }
        )
    }

}