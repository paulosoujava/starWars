package com.paulo.starwars.presentation.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.starwars.R
import com.paulo.starwars.presentation.ui.commom.ImageCoil
import com.paulo.starwars.presentation.ui.commom.TopBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Profile(
    navController: NavHostController
) {


    Scaffold(
        topBar = {
            TopBar(title = "Luke Skywalker") {
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
                    ImageCoil("https://starwars-visualguide.com/assets/img/characters/1.jpg")
                }
                Column(horizontalAlignment = Alignment.Start) {
                    Link(text = "Birth Year:", link = " 19BBY", hasLink = false)
                    Link(text = "Species:", link = " Unknown", hasLink = false)
                    Link(text = "Height:", link = " 172cm", hasLink = false)
                    Link(text = "Mass:", link = " 77kg", hasLink = false)
                    Link(text = "Gender:", link = " Male", hasLink = false)
                    Link(text = "Hair Color:", link = " Blond", hasLink = false)
                    Link(text = "Skin Color:", link = " Fair", hasLink = false)
                    Link(text = "Homeworld", link = " Tatooine", hasLink = true, action = {})

                }

            }
           ListRelated(title = "Related Films")
            ListRelated(title = "Related Vehicles")
           ListRelated(title = "Related Starships")

        }
    }
}

@Composable
fun ListRelated(title: String) {
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
        LazyRow(
            state = rememberLazyListState(),
        ) {
            items(10) { columnIndex ->
                RelatedCard("Episode IV: A New Hope $columnIndex")
            }
        }
    }
}


@Composable
fun Link(text: String, link: String, hasLink: Boolean = false, action: () -> Unit = {}) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 3.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, color = Color.White)
        if (hasLink)
            Text(
                text = link,
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
fun RelatedCard(msg: String) {
    Row(
        modifier = Modifier
            .padding(all = 5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Black),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://starwars-visualguide.com/assets/img/films/1.jpg")
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


        Text(
            text = msg.take(30),
            style = TextStyle(fontSize = 15.sp, color = Color.White),
            maxLines = 1,
            overflow = TextOverflow.Clip
        )

        Spacer(modifier = Modifier.width(5.dp))
    }
}
