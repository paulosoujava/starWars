package com.paulo.starwars.presentation.ui.list.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.paulo.starwars.R
import com.paulo.starwars.presentation.ui.theme.yellowOnFocus

@Composable
@OptIn(ExperimentalMaterial3Api::class)
 fun TopBarHome(stateFilter: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.star_wars),
                style = TextStyle(color = Color.Yellow, fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(2f)
            )
            IconButton(onClick = { stateFilter.value = !stateFilter.value }) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = stringResource(R.string.filter_icon),
                    tint = Color.Yellow
                )
            }

        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = {
                Text(
                    stringResource(R.string.pesquisar),
                    style = TextStyle(color = yellowOnFocus)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Yellow,
                unfocusedBorderColor = yellowOnFocus
            )
        )

        AnimatedVisibility(visible = stateFilter.value) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CheckBox(label = "Films")
                    CheckBox(label = "Species")
                    CheckBox(label = "Starships")
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CheckBox(label = "Charactes")
                    CheckBox(label = "vehicles")
                    CheckBox(label = "Planets")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    modifier = Modifier
                        .background(yellowOnFocus)
                        .fillMaxWidth()
                        .height(1.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    CheckBox(label = "TODOS", horizontalArrangement = Arrangement.End)
                }

            }
        }

    }
}
