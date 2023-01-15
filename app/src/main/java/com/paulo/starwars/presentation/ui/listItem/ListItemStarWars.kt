package com.paulo.starwars.presentation.ui.listItem

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.paulo.starwars.R
import com.paulo.starwars.core.Events
import com.paulo.starwars.data.Result
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.presentation.ui.commom.ErrorState
import com.paulo.starwars.presentation.ui.commom.Loading
import com.paulo.starwars.presentation.ui.commom.TopBar
import com.paulo.starwars.presentation.ui.listItem.components.ListItemCardStarWars
import com.paulo.starwars.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListItemStarWars(
    navController: NavHostController
) {

    val viewModel = hiltViewModel<ListItemViewModel>()
    val state = viewModel.uiStateList.collectAsState()
    val pageActual = viewModel.page.collectAsState()
    val currentLimitPageToIndexPhoto = viewModel.currentPage.collectAsState()
    val result = state.value.success

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth().background(Color.Black),

                ) {
                TopBar { navController.popBackStack() }
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = state.value.stateUi == Events.Regular) {
                    HeaderPagination(pageActual, result, viewModel)
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

        }
    ) {
        when (state.value.stateUi) {
            is Events.Error -> ErrorState(navController, errorMessage = state.value.error ?: "")
            Events.Loading -> Loading()
            Events.Regular -> {
                if (state.value.success != null) {
                    ContentRegular(viewModel, currentLimitPageToIndexPhoto, navController)
                } else {
                    ErrorState(navController, errorMessage = state.value.error ?: "")
                }
            }
        }
    }

}

@Composable
private fun ContentRegular(
    viewModel: ListItemViewModel,
    currentLimitPageToIndexPhoto: State<Int>,
    navController: NavHostController
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 120.dp),
        columns = GridCells.Adaptive(150.dp),
        content = {

            itemsIndexed(viewModel.uiStateList.value.success!!.results) { i, people ->
                val imageUrl = "${Constants.BASE_PATH_CHARACTERES}${i + 1 + currentLimitPageToIndexPhoto.value}.jpg"
                ListItemCardStarWars(
                    title = people.name,
                    urlImage = imageUrl
                ) {
                    navController.navigate(
                        route = "${Constants.PROFILE_PAGE}/${i + 1 + currentLimitPageToIndexPhoto.value}.jpg/$i"
                    )
                }
            }
        }
    )
}

@Composable
private fun HeaderPagination(
    pageActual: State<Long>,
    result: Result<People>?,
    viewModel: ListItemViewModel
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = pageActual.value > 1 && result != null) {
            IconButton(onClick = {
                viewModel.setPage(false)
            }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null, modifier = Modifier.weight(1f)
                )
            }
        }

        Text(
            text = "Page ${pageActual.value} de ${result?.count?.toInt()}",
            modifier = Modifier.weight(3f),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Yellow
        )

        AnimatedVisibility(visible = pageActual.value < (result?.count?.toInt() ?: 0)) {
            IconButton(onClick = {
                viewModel.setPage(true)
            }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null, modifier = Modifier.weight(1f)
                )
            }
        }
    }
}