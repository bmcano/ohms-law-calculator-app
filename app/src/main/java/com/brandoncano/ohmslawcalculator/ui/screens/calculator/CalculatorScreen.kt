package com.brandoncano.ohmslawcalculator.ui.screens.calculator

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Bolt
import androidx.compose.material.icons.outlined.ElectricalServices
import androidx.compose.material.icons.outlined.Power
import androidx.compose.material.icons.outlined.Straighten
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.constants.DropdownLists
import com.brandoncano.ohmslawcalculator.constants.Symbols
import com.brandoncano.ohmslawcalculator.model.OhmsLaw
import com.brandoncano.ohmslawcalculator.ui.composables.AboutAppMenuItem
import com.brandoncano.ohmslawcalculator.ui.composables.AppThemeMenuItem
import com.brandoncano.ohmslawcalculator.ui.theme.OhmsLawCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppDropDownMenu
import com.brandoncano.sharedcomponents.composables.AppMenuTopAppBar
import com.brandoncano.sharedcomponents.composables.AppNavigationBar
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTextField
import com.brandoncano.sharedcomponents.composables.ClearSelectionsMenuItem
import com.brandoncano.sharedcomponents.composables.FeedbackMenuItem
import com.brandoncano.sharedcomponents.data.NavigationBarOptions
import com.brandoncano.sharedcomponents.text.textStyleLargeTitle

@Composable
fun CalculatorScreen(
    openMenu: MutableState<Boolean>,
    reset: MutableState<Boolean>,
    // VM items
    ohmsLaw: OhmsLaw,
    navBarPosition: Int,
    selectedFormulas: List<String>,
    // action items
    onOpenThemeDialog: () -> Unit,
    onClearSelectionsTapped: () -> Unit,
    onAboutTapped: () -> Unit,
    onNavBarSelectionChanged: (Int) -> Unit,
    onFormulaSelected: (String) -> Unit,
) {
    var navBarSelection by remember { mutableIntStateOf(navBarPosition) }
    Scaffold(
        topBar = {
            AppMenuTopAppBar(
                titleText = stringResource(R.string.calculator_title),
                interactionSource = remember { MutableInteractionSource() },
                showMenu = openMenu,
                navigationIcon = Icons.Filled.Menu,
                onNavigateBack = { /* will be for navigation drawer */ },
            ) {
                ClearSelectionsMenuItem(onClearSelectionsTapped)
                FeedbackMenuItem(
                    app = Symbols.APP_NAME,
                    showMenu = openMenu,
                )
                AppThemeMenuItem(openMenu, onOpenThemeDialog)
                AboutAppMenuItem(onAboutTapped)
            }
        },
        bottomBar = {
            AppNavigationBar(
                selection = navBarSelection,
                onClick = {
                    navBarSelection = it
                    onNavBarSelectionChanged(it)
                },
                options = listOf(
                    NavigationBarOptions(
                        label = stringResource(id = R.string.calculator_volts),
                        imageVector = Icons.Outlined.Bolt,
                    ),
                    NavigationBarOptions(
                        label = stringResource(id = R.string.calculator_amps),
                        imageVector = Icons.Outlined.ElectricalServices,
                    ),
                    NavigationBarOptions(
                        label = stringResource(id = R.string.calculator_resistance),
                        imageVector = Icons.Outlined.Straighten, // ???
                    ),
                    NavigationBarOptions(
                        label = stringResource(id = R.string.calculator_power),
                        imageVector = Icons.Outlined.Power,
                    ),
                )
            )
        }
    ) { paddingValues ->
        CalculatorScreenContent(
            paddingValues = paddingValues,
            reset = reset,
            ohmsLaw = ohmsLaw,
            selectedFormulas = selectedFormulas,
            onFormulaSelected = onFormulaSelected,
        )
    }
}

@Composable
private fun CalculatorScreenContent(
    paddingValues: PaddingValues,
    reset: MutableState<Boolean>,
    ohmsLaw: OhmsLaw,
    selectedFormulas: List<String>,
    onFormulaSelected: (String) -> Unit,
) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    val value1 = remember { mutableStateOf(ohmsLaw.value1) }
    val value2 = remember { mutableStateOf(ohmsLaw.value2) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppDropDownMenu(
            label = stringResource(R.string.calculator_select_formula),
            modifier = Modifier.padding(top = 16.dp),
            selectedOption = ohmsLaw.formula,
            items = selectedFormulas
        ) {
            onFormulaSelected(it)
            // update units and text fields
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            AppTextField(
                label = stringResource(id = R.string.calculator_volts),
                modifier = Modifier
                    .weight(0.5f)
                    .padding(end = 8.dp),
                value = value1,
                reset = reset.value,
            ) {

            }
            AppDropDownMenu(
                label = stringResource(id = R.string.calculator_units),
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 8.dp),
                selectedOption = ohmsLaw.units1, // default to list[3] item
                items = DropdownLists.UNITS_VOLTS,
                onOptionSelected = {  }
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            AppTextField(
                label = stringResource(id = R.string.calculator_volts),
                modifier = Modifier
                    .weight(0.5f)
                    .padding(end = 8.dp),
                value = value2,
                reset = reset.value,
            ) {

            }
            AppDropDownMenu(
                label = stringResource(id = R.string.calculator_units),
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 8.dp),
                selectedOption = ohmsLaw.units2, // default to list[3] item
                items = DropdownLists.UNITS_VOLTS,
                onOptionSelected = {  }
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "0.00 V",
            style = textStyleLargeTitle(),
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@AppScreenPreviews
@Composable
private fun CalculatorScreenPreview() {
    OhmsLawCalculatorTheme {
        CalculatorScreen(
            openMenu = remember { mutableStateOf(false) },
            reset = remember { mutableStateOf(false) },
            ohmsLaw = OhmsLaw(),
            navBarPosition = 0,
            selectedFormulas = emptyList(),
            onOpenThemeDialog = {},
            onClearSelectionsTapped = {},
            onAboutTapped = {},
            onNavBarSelectionChanged = {},
            onFormulaSelected = {},
        )
    }
}