package com.paulo.starwars.presentation.ui.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.starwars.R
import com.paulo.starwars.presentation.ui.commom.ImageCoil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCardStarWars(
    title: String,
    urlImage: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(12.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(0.5f)
        ),
    ) {
        Box {
            ImageCoil(urlImage)
            Box(
                modifier = Modifier
                    .padding(top = 120.dp)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.3f))
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 10.dp,
                        end = 20.dp,
                        bottom = 10.dp
                    ),
                    style = TextStyle(fontSize = 16.sp, color = Color.White)
                )
            }

        }
    }
}