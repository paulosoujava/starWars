package com.paulo.starwars.presentation.ui.listItem.components

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.presentation.ui.commom.TopBar
import com.paulo.starwars.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListDetail(
     list: List<People>,
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
                itemsIndexed(list) { i,people ->
                    Log.d("TAG", "https://starwars-visualguide.com/assets/img/characters/${i+1}.jpg")
                    ListItemCardStarWars(
                        title = people.name,
                        urlImage = "${Constants.BASE_PATH_CHARACTERES}${i+1}.jpg"
                    ) {
                        navController.navigate(Constants.PROFILE_PAGE)
                    }
                }
            }
        )
    }
}