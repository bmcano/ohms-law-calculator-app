package com.brandoncano.ohmslawcalculator.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.ui.theme.OhmsLawCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.composables.MenuIcon
import com.brandoncano.sharedcomponents.composables.MenuText

/**
 * Note: Menu items are in alphabetical order
 */

@Composable
fun AboutAppMenuItem(onAboutTapped: () -> Unit) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_about) },
        onClick = onAboutTapped,
        leadingIcon = { MenuIcon(Icons.Outlined.Info) },
    )
}

@Composable
fun AppThemeMenuItem(
    openMenu: MutableState<Boolean>,
    onThemeSelected: () -> Unit,
) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_app_theme) },
        onClick = {
            openMenu.value = false
            onThemeSelected()
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Palette) },
    )
}

@AppComponentPreviews
@Composable
private fun MenuItemsPreview() {
    val showMenu = remember { mutableStateOf(false) }
    OhmsLawCalculatorTheme {
        Column {
            AboutAppMenuItem {}
            AppThemeMenuItem(showMenu) { }
        }
    }
}
