package com.paulo.starwars.presentation.ui.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.paulo.starwars.presentation.ui.theme.yellowOnFocus

@ExperimentalMaterial3Api
@Composable
fun RowScope.CheckBox(
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