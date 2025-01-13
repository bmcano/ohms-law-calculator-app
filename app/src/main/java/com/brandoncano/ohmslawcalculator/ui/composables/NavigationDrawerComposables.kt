package com.brandoncano.ohmslawcalculator.ui.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody

@Composable
fun AppNavigationDrawer(
    drawerState: DrawerState,
    onLearnOhmsLawTapped: () -> Unit,
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
    onAboutTapped: () -> Unit,
    content: @Composable (() -> Unit),
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.systemBarsPadding()) {
                val iconColor = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_app_icon),
                        contentDescription = stringResource(R.string.app_name),
                        modifier = Modifier.size(72.dp),
                    )
                }
                NavigationDrawerItem(
                    label = { NavigationDrawerText(R.string.nav_learn) },
                    selected = false,
                    onClick = onLearnOhmsLawTapped,
                    icon = {
                        Image(
                            imageVector = Icons.Outlined.Lightbulb,
                            contentDescription = null,
                            colorFilter = iconColor
                        )
                    },
                )
                NavigationDrawerItem(
                    label = { NavigationDrawerText(R.string.nav_rate_us) },
                    selected = false,
                    onClick = onRateThisAppTapped,
                    icon = {
                        Image(
                            imageVector = Icons.Outlined.Grade,
                            contentDescription = null,
                            colorFilter = iconColor
                        )
                    },
                )
                NavigationDrawerItem(
                    label = { NavigationDrawerText(R.string.nav_view_apps) },
                    selected = false,
                    onClick = onViewOurAppsTapped,
                    icon = {
                        Image(
                            imageVector = Icons.Outlined.Apps,
                            contentDescription = null,
                            colorFilter = iconColor
                        )
                    },
                )
                NavigationDrawerItem(
                    label = { NavigationDrawerText(R.string.nav_donate) },
                    selected = false,
                    onClick = onDonateTapped,
                    icon = {
                        Image(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                            colorFilter = iconColor
                        )
                    },
                )
                NavigationDrawerItem(
                    label = { NavigationDrawerText(R.string.nav_about) },
                    selected = false,
                    onClick = onAboutTapped,
                    icon = {
                        Image(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null,
                            colorFilter = iconColor
                        )
                    },
                )
            }
        },
        content = content,
    )
}

@Composable
private fun NavigationDrawerText(@StringRes id: Int) {
    Text(
        text = stringResource(id),
        style = textStyleBody().onSurfaceVariant(),
    )
}
