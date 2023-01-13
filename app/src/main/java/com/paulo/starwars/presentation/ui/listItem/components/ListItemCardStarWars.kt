package com.paulo.starwars.presentation.ui.listItem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.starwars.R
import com.paulo.starwars.presentation.ui.commom.ImageCoil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItemCardStarWars(
    title: String,
    urlImage: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.padding(16.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(180.dp)
            ) {
                ImageCoil(urlImage)
            }

            Box(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = title,
                    style = TextStyle(fontSize = 16.sp, color = Color.White),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}