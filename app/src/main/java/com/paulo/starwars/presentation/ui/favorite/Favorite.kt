package com.paulo.starwars.presentation.ui.favorite

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.starwars.R
import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.presentation.ui.commom.TopBar
import com.paulo.starwars.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Favorite(
    navController: NavHostController,
) {

    val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val viewModel = hiltViewModel<FavoriteViewModel>()
    val state = viewModel.uiStateList.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.favorite),
            ) {
                navController.popBackStack()
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            )
        ) {
            stickyHeader {
                if (snackbarVisibleState) {
                    Snackbar(
                        action = {
                            Button(onClick = {
                                viewModel.undoFavorite()
                                setSnackBarState(false)
                            }) {
                                Text(stringResource(R.string.undo))
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    ) { Text(text = stringResource(R.string.get_back)) }
                }
            }
            items(state.value) { favorite ->
                CardFavorite(favorite) {
                    viewModel.remove(favorite)
                    scope.launch {
                        setSnackBarState(!snackbarVisibleState)
                        delay(2000)
                        setSnackBarState(false)
                    }
                }
            }
        }

    }
}


@Composable
private fun CardFavorite(favorite: Favorite, onRemove: (Favorite) -> Unit) {
    Row(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = Color.Black)
            .padding(16.dp)
            .clickable {
                onRemove(favorite)
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(favorite.urlPhoto)
                .crossfade(true)
                .placeholder(R.drawable.placeholder)
                .build(),
            contentDescription = stringResource(R.string.image_card_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = favorite.name,
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
        )

    }
}