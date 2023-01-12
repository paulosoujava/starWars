package com.paulo.starwars.presentation.ui.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.paulo.starwars.presentation.ui.list.components.ListCardStarWars
import com.paulo.starwars.presentation.ui.theme.yellowOnFocus


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListStarWars(
    onSearch: () -> Unit,
    onValueChange: () -> Unit,
    value: String,
    navController: NavHostController,
) {

    val stateFilter = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
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
                        text = "Star Wars",
                        style = TextStyle(color = Color.Yellow, fontWeight = FontWeight.Bold),
                        modifier = Modifier.weight(2f)
                    )
                    IconButton(onClick = { stateFilter.value = !stateFilter.value }) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "filter icon",
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
                            "Pesquisar",
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
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ),
            columns = GridCells.Adaptive(250.dp),
            content = {
                items(20) { i ->
                    ListCardStarWars(
                        title = "Title $i",
                        urlImage = "https://starwars-visualguide.com/assets/img/starships/5.jpg"
                    ) {
                        navController.navigate("item")
                    }
                }
            }
        )
    }

}

@ExperimentalMaterial3Api
@Composable
private fun RowScope.CheckBox(
    label: String,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
) {
    val stateCheckBox = remember {
        mutableStateOf(false)
    }
    Row(
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                stateCheckBox.value = !stateCheckBox.value
            }
            .weight(1f)
    ) {
        Checkbox(
            checked = stateCheckBox.value,
            onCheckedChange = { stateCheckBox.value = !stateCheckBox.value },
            colors = CheckboxDefaults.colors(
                checkedColor = yellowOnFocus,
                uncheckedColor = Color.DarkGray,
                checkmarkColor = Color.White
            )
        )
        Text(text = label, style = TextStyle(color = Color.Yellow))
    }
}