package com.paulo.starwars.presentation.ui.listItem

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.paulo.starwars.presentation.ui.commom.TopBar
import com.paulo.starwars.presentation.ui.listItem.components.ListItemCardStarWars
import com.paulo.starwars.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItemStarWars(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopBar { navController.popBackStack() }
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ),
            columns = GridCells.Adaptive(150.dp),
            content = {
                items(20) { i ->
                    ListItemCardStarWars(
                        title = "Title $i",
                        urlImage = "https://starwars-visualguide.com/assets/img/starships/5.jpg"
                    ) {
                        navController.navigate(Constants.PROFILE_PAGE)
                    }
                }
            }
        )
    }

}