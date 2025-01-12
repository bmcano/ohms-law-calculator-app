package com.brandoncano.ohmslawcalculator.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.text.textStyleBody

@OptIn(ExperimentalMaterial3Api::class) // For ExposedDropdownMenuBox
@Composable
fun AppDynamicDropDownMenu(
    label: String,
    modifier: Modifier = Modifier,
    items: List<String>,
    indexOnChange: Int,
    onOptionSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(items[indexOnChange]) }
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    val focusManager = LocalFocusManager.current

    LaunchedEffect(items) {
        selectedText = items[indexOnChange]
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            },
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                .fillMaxWidth(),
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach {
                TextDropDownItemView(it) {
                    selectedText = it
                    expanded = false
                    onOptionSelected(it)
                    focusManager.clearFocus()
                }
            }
        }
    }
}

@Composable
private fun TextDropDownItemView(item: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick() },
    ) {
        Column {
            Text(
                text = item,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
                style = textStyleBody(),
            )
        }
    }
}
