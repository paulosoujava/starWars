package com.paulo.starwars.presentation.ui.listItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.paulo.starwars.R
import com.paulo.starwars.presentation.ui.commom.TopBar
import com.paulo.starwars.presentation.ui.listItem.components.ListItemCardStarWars


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItemStarWars(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar {
                onBackClick()
            }
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()),
            columns = GridCells.Adaptive(150.dp),
            content = {
                items(20) { i ->
                    ListItemCardStarWars(
                        title = "Title $i",
                        urlImage = "https://starwars-visualguide.com/assets/img/starships/5.jpg"
                    ) {

                    }
                }
            }
        )
    }

}