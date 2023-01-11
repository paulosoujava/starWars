package com.paulo.starwars.presentation.ui.commom

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.starwars.R

@Composable
fun ImageCoil(urlImage: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(urlImage)
            .crossfade(true)
            .placeholder(R.drawable.placeholder)
            .build(),
        contentDescription = stringResource(R.string.image_card_description),
        contentScale = ContentScale.Crop
    )
}