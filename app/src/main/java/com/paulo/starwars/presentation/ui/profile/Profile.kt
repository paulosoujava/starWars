package com.paulo.starwars.presentation.ui.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.paulo.starwars.core.Events
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.presentation.ui.commom.ErrorState
import com.paulo.starwars.presentation.ui.commom.ImageCoil
import com.paulo.starwars.presentation.ui.commom.Loading
import com.paulo.starwars.presentation.ui.commom.TopBar
import com.paulo.starwars.utils.Constants


@Composable
fun Profile(
    navController: NavHostController,
    urlPhoto: String?,
    code: String
) {

    val viewModel = hiltViewModel<ProfileViewModel>()
    val state = viewModel.uiState.collectAsState()

    if (code == "invalid") {
        ErrorState(
            navController = navController,
            "Ops, the code has invalid!!"
        )
        return
    }

    val newCode = if (code.toInt() == 0) 1 else code.toInt() + 1
    SideEffect {
        viewModel.getFavorite(newCode)
        viewModel.fetchData(newCode)
    }


    when (state.value.stateUi) {
        is Events.Error -> ErrorState(navController = navController)
        Events.Loading -> Loading()
        Events.Regular -> {
            val people = state.value.people
            val photo = urlPhoto ?: Constants.NO_PHOTO
            if (people != null) {
                RegularContent(
                    people = people,
                    navController = navController,
                    urlPhoto = photo,
                    code = newCode,
                    viewModel = viewModel
                )
            } else {
                ErrorState(navController = navController)
            }
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegularContent(
    people: People,
    navController: NavHostController,
    urlPhoto: String,
    code: Int,
    viewModel: ProfileViewModel
) {
    val context = LocalContext.current

    val state = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                title = people.name,
            ) {
                navController.popBackStack()
            }
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 50.dp))
                    .background(Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(300.dp)
                ) {
                    ImageCoil("${Constants.BASE_PATH_CHARACTERES}$urlPhoto")
                }
                Column(
                    modifier = Modifier.padding(top = 10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Link(
                        label = stringResource(R.string.birth_year),
                        text = people.birthYear,
                        hasLink = false
                    )
                    if (people.species.isNotEmpty())
                        Link(
                            label = stringResource(R.string.species),
                            text = "",
                            hasLink = true,
                            action = {
                                Toast.makeText(context, "Not implemented", Toast.LENGTH_LONG)
                                    .show()
                            })
                    Link(
                        label = stringResource(R.string.height),
                        text = people.height,
                        hasLink = false
                    )
                    Link(
                        label = stringResource(R.string.mass),
                        text = people.mass,
                        hasLink = false
                    )
                    Link(
                        label = stringResource(R.string.gender),
                        text = people.gender,
                        hasLink = false
                    )
                    Link(
                        label = stringResource(R.string.hair_color),
                        text = people.hairColor,
                        hasLink = false
                    )
                    Link(
                        label = stringResource(R.string.skin_color),
                        text = people.skinColor,
                        hasLink = false
                    )
                    if (people.homeworld.isNotEmpty())
                        Link(
                            label = stringResource(R.string.homeworld),
                            text = "",
                            hasLink = true,
                            action = {
                                Toast.makeText(context, "Not implemented", Toast.LENGTH_LONG)
                                    .show()
                            })
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        IconButton(
                            onClick = {
                                viewModel.favorite(
                                    name = people.name,
                                    urlPhoto = urlPhoto,
                                    code = code.toString()
                                )
                            },
                            modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (state.value.favorite)
                                        R.drawable.baseline_favorite_24
                                    else
                                        R.drawable.baseline_favorite_border_24
                                ),
                                contentDescription = stringResource(R.string.favorite)
                            )
                        }
                    }

                }

            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = people.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
            )

            ListRelated(
                title = stringResource(R.string.related_films),
                people.films,
                Constants.FILMS
            )
            ListRelated(
                title = stringResource(R.string.related_vehicles),
                people.vehicles,
                Constants.VEHICLES
            )
            ListRelated(
                title = stringResource(R.string.related_starships),
                people.starships,
                Constants.STARSHIPS
            )

        }
    }
}


@Composable
fun ListRelated(title: String, items: List<String>, type: String) {
    Column {
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = title,
            color = Color.Yellow,
            fontSize = 18.sp,
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 30.dp))
                .background(Color.Black)
                .padding(10.dp)
        )
        if (items.isEmpty()) {
            Text(
                text = "There are no related items for this category",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
        } else {
            LazyRow(
                state = rememberLazyListState(),
            ) {
                items(items.size) { item ->
                    RelatedCard(items[item], type)
                }
            }
        }

    }
}


@Composable
fun Link(label: String, text: String, hasLink: Boolean = false, action: () -> Unit = {}) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 3.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, color = Color.White)
        if (hasLink)
            Text(
                text = "Click here",
                modifier = Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        action()
                    },
                color = Color(0xff64B5F6)
            )
        else
            Text(text = " $text", color = Color.White.copy(alpha = .4f))
    }
}

@Composable
fun RelatedCard(path: String, type: String) {
    val result = path.filter { it.isDigit() }

    Row(
        modifier = Modifier
            .padding(all = 5.dp)
            .size(80.dp)
            .clip(CircleShape)
            .background(Color.Black),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${Constants.URL_BASE_IMAGE}$type/$result.jpg")
                .crossfade(true)
                .placeholder(R.drawable.placeholder)
                .build(),
            contentDescription = stringResource(R.string.image_card_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(5.dp))
    }
}
