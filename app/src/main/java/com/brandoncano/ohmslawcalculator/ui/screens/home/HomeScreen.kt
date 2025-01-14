package com.brandoncano.ohmslawcalculator.ui.screens.home

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bolt
import androidx.compose.material.icons.outlined.ElectricalServices
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Power
import androidx.compose.material.icons.outlined.Straighten
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.constants.Links
import com.brandoncano.ohmslawcalculator.ui.theme.OhmsLawCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AboutAppMenuItem
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppHomeTopAppBar
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppThemeMenuItem
import com.brandoncano.sharedcomponents.composables.FeedbackMenuItem
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.screen.OurAppsButtons
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun HomeScreen(
    openMenu: MutableState<Boolean>,
    onOpenThemeDialog: () -> Unit,
    onAboutTapped: () -> Unit,
    onVoltageTapped: () -> Unit,
    onCurrentTapped: () -> Unit,
    onResistanceTapped: () -> Unit,
    onPowerTapped: () -> Unit,
    onLearnTapped: () -> Unit,
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppHomeTopAppBar(
                titleText = stringResource(R.string.app_name),
                interactionSource = remember { MutableInteractionSource() },
                showMenu = openMenu,
                appIcon = painterResource(R.drawable.img_app_icon),
                content = {
                    FeedbackMenuItem(Links.APP_NAME, openMenu)
                    AppThemeMenuItem(openMenu, onOpenThemeDialog)
                    AboutAppMenuItem(onAboutTapped)
                }
            )
        },
    ) { paddingValues ->
        HomeScreenContent(
            paddingValues = paddingValues,
            onVoltageTapped = onVoltageTapped,
            onCurrentTapped = onCurrentTapped,
            onResistanceTapped = onResistanceTapped,
            onPowerTapped = onPowerTapped,
            onLearnTapped = onLearnTapped,
            onRateThisAppTapped = onRateThisAppTapped,
            onViewOurAppsTapped = onViewOurAppsTapped,
            onDonateTapped = onDonateTapped,
        )
    }
}

@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    onVoltageTapped: () -> Unit,
    onCurrentTapped: () -> Unit,
    onResistanceTapped: () -> Unit,
    onPowerTapped: () -> Unit,
    onLearnTapped: () -> Unit,
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.home_calculators_header_text),
            modifier = Modifier
                .padding(vertical = 12.dp)
                .align(Alignment.Start),
            style = textStyleHeadline(),
        )
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Bolt,
                text = stringResource(id = R.string.home_voltage),
                onClick = onVoltageTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.ElectricalServices,
                text = stringResource(id = R.string.home_current),
                onClick = onCurrentTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Straighten,
                text = stringResource(id = R.string.home_resistance),
                onClick = onResistanceTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Power,
                text = stringResource(id = R.string.home_power),
                onClick = onPowerTapped,
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(id = R.string.home_learn),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Lightbulb,
                text = stringResource(id = R.string.home_learn_button),
                onClick = onLearnTapped,
            ),
        )
        Spacer(modifier = Modifier.height(32.dp))
        OurAppsButtons(
            onRateThisAppTapped = onRateThisAppTapped,
            onViewOurAppsTapped = onViewOurAppsTapped,
            onDonateTapped = onDonateTapped,
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun HomePreview() {
    OhmsLawCalculatorTheme {
        HomeScreen(
            openMenu = remember { mutableStateOf(false) },
            onOpenThemeDialog = {},
            onAboutTapped = {},
            onVoltageTapped = {},
            onCurrentTapped = {},
            onResistanceTapped = {},
            onPowerTapped = {},
            onLearnTapped = {},
            onRateThisAppTapped = {},
            onViewOurAppsTapped = {},
            onDonateTapped = {},
        )
    }
}
