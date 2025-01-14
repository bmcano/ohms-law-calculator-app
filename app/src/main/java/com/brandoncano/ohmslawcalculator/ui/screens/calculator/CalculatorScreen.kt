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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.constants.DropdownLists
import com.brandoncano.ohmslawcalculator.constants.Links
import com.brandoncano.ohmslawcalculator.data.FormulaDetails
import com.brandoncano.ohmslawcalculator.model.OhmsLaw
import com.brandoncano.ohmslawcalculator.ui.composables.AppDynamicDropDownMenu
import com.brandoncano.ohmslawcalculator.ui.theme.OhmsLawCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AboutAppMenuItem
import com.brandoncano.sharedcomponents.composables.AppMenuTopAppBar
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTextField
import com.brandoncano.sharedcomponents.composables.ClearSelectionsMenuItem
import com.brandoncano.sharedcomponents.composables.FeedbackMenuItem
import com.brandoncano.sharedcomponents.text.textStyleLargeTitle

@Composable
fun CalculatorScreen(
    title: String,
    openMenu: MutableState<Boolean>,
    reset: MutableState<Boolean>,
    ohmsLaw: OhmsLaw,
    selectedFormulas: List<String>,
    formulaDetails: FormulaDetails,
    onNavigateBack: () -> Unit,
    onClearSelectionsTapped: () -> Unit,
    onAboutTapped: () -> Unit,
    onFormulaSelected: (String) -> Unit,
    onValuesChanged: (String, String, String, String) -> Unit,
) {
    Scaffold(
        topBar = {
            AppMenuTopAppBar(
                titleText = title,
                interactionSource = remember { MutableInteractionSource() },
                showMenu = openMenu,
                navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
                onNavigateBack = onNavigateBack,
            ) {
                ClearSelectionsMenuItem(onClearSelectionsTapped)
                FeedbackMenuItem(
                    app = Links.APP_NAME,
                    showMenu = openMenu,
                )
                AboutAppMenuItem(onAboutTapped)
            }
        },
    ) { paddingValues ->
        CalculatorScreenContent(
            paddingValues = paddingValues,
            reset = reset,
            ohmsLaw = ohmsLaw,
            selectedFormulas = selectedFormulas,
            formulaDetails = formulaDetails,
            onFormulaSelected = onFormulaSelected,
            onValuesChanged = onValuesChanged,
        )
    }
}

@Composable
private fun CalculatorScreenContent(
    paddingValues: PaddingValues,
    reset: MutableState<Boolean>,
    ohmsLaw: OhmsLaw,
    selectedFormulas: List<String>,
    formulaDetails: FormulaDetails,
    onFormulaSelected: (String) -> Unit,
    onValuesChanged: (String, String, String, String) -> Unit,
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
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = ohmsLaw.result,
            style = textStyleLargeTitle(),
        )
        AppDynamicDropDownMenu(
            label = stringResource(R.string.calculator_select_formula),
            modifier = Modifier.padding(top = 24.dp),
            items = selectedFormulas,
            indexOnChange = 0,
            onOptionSelected = { onFormulaSelected(it) }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            AppTextField(
                label = stringResource(id = formulaDetails.value1Label),
                modifier = Modifier
                    .weight(0.6f)
                    .padding(end = 8.dp),
                value = value1,
                reset = reset.value,
                onOptionSelected = {
                    onValuesChanged(it, ohmsLaw.units1, value2.value, ohmsLaw.units2)
                }
            )
            AppDynamicDropDownMenu(
                label = stringResource(id = R.string.calculator_units),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 8.dp),
                items = formulaDetails.value1UnitList,
                indexOnChange = 2,
                onOptionSelected = {
                    onValuesChanged(value1.value, it, value2.value, ohmsLaw.units2)
                }
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            AppTextField(
                label = stringResource(id = formulaDetails.value2Label),
                modifier = Modifier
                    .weight(0.6f)
                    .padding(end = 8.dp),
                value = value2,
                reset = reset.value,
                onOptionSelected = {
                    onValuesChanged(value1.value, ohmsLaw.units1, it, ohmsLaw.units2)
                }
            )
            AppDynamicDropDownMenu(
                label = stringResource(id = R.string.calculator_units),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 8.dp),
                items = formulaDetails.value2UnitList,
                indexOnChange = 2,
                onOptionSelected = {
                    onValuesChanged(value1.value, ohmsLaw.units1, value2.value, it)
                }
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@AppScreenPreviews
@Composable
private fun CalculatorScreenPreview() {
    OhmsLawCalculatorTheme {
        CalculatorScreen(
            title = "Voltage",
            openMenu = remember { mutableStateOf(false) },
            reset = remember { mutableStateOf(false) },
            ohmsLaw = OhmsLaw(),
            selectedFormulas = DropdownLists.FORMULAS_VOLTS,
            formulaDetails = FormulaDetails(),
            onNavigateBack = {},
            onClearSelectionsTapped = {},
            onAboutTapped = {},
            onFormulaSelected = {},
            onValuesChanged = { _, _, _, _ -> },
        )
    }
}
