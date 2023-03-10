package com.paulo.starwars.presentation.ui.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.paulo.starwars.R
import com.paulo.starwars.domain.models.Home
import com.paulo.starwars.presentation.ui.list.UiStateList
import com.paulo.starwars.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    ListHome: List<Home>,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            Row( modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(10.dp)) {
                Text(
                    text = stringResource(R.string.star_wars),
                    style = TextStyle(
                        color = Color.Yellow,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier.weight(3f)
                )
                IconButton(
                    onClick = {
                        navController.navigate(
                            route = Constants.FAVORITE
                        )
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = stringResource(R.string.favorite)
                    )
                }
            }

        }
    ) {

        LazyColumn(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ),
            content = {
                items(ListHome, key = {key -> key.title }) { item ->
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