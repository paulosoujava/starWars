package com.paulo.starwars.presentation.ui.commom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.starwars.R

@Composable
fun ErrorState(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(modifier = Modifier.size(280.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.placeholder)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.image_card_description),
                contentScale = ContentScale.Inside
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(R.string.message_error),
            fontSize = 16.sp,
            color = Color.Yellow
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextButton(onClick = {
            navController.popBackStack()
        }) {
            Text(
                text = stringResource(R.string.back_label_button),
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.background(Color.Yellow.copy(alpha = .3f)).padding(10.dp)
            )
        }
    }
}