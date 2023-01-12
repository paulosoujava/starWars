package com.paulo.starwars.presentation.ui.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
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
    val painter = rememberAsyncImagePainter(urlImage)

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

            Row( modifier =  Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                            contentDescription = stringResource(R.string.image_card_description),
                    modifier = Modifier
                )
                Image(
                    painter = painter,
                    contentDescription = stringResource(R.string.image_card_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxHeight().clip(RoundedCornerShape(topStart = 80.dp))
                )

            }

            Box(
                modifier = Modifier
                    .padding(top = 120.dp)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.7f))
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 10.dp,
                        end = 20.dp,
                        bottom = 10.dp
                    ),
                    style = TextStyle(fontSize = 18.sp, color = Color.Yellow, fontWeight = FontWeight.Bold)
                )
            }

        }
    }
}