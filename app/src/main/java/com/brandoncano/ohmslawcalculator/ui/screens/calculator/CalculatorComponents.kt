package com.brandoncano.ohmslawcalculator.ui.screens.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.data.FormulaDetails
import com.brandoncano.ohmslawcalculator.model.OhmsLaw
import com.brandoncano.ohmslawcalculator.ui.composables.AppDynamicDropDownMenu
import com.brandoncano.sharedcomponents.composables.AppDropDownMenu
import com.brandoncano.sharedcomponents.composables.AppTextField
import com.brandoncano.sharedcomponents.text.textStyleLargeTitle

@Composable
private fun CalculatorScreenStateContent(
    reset: MutableState<Boolean>,
    ohmsLaw: OhmsLaw,
    formulas: List<String>,
    formulaDetails: FormulaDetails,
    onFormulaSelected: (String) -> Unit,
    onValuesChanged: (String, String, String, String) -> Unit,
) {
    val value1 = remember { mutableStateOf(ohmsLaw.value1) }
    val value2 = remember { mutableStateOf(ohmsLaw.value2) }
    Column {
        Text(
            text = ohmsLaw.getDisplayText(),
            style = textStyleLargeTitle(),
        )
        AppDropDownMenu(
            label = stringResource(R.string.calculator_select_formula),
            modifier = Modifier.padding(top = 24.dp),
            items = formulas,
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
                indexOnChange = 3,
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
                indexOnChange = 3,
                onOptionSelected = {
                    onValuesChanged(value1.value, ohmsLaw.units1, value2.value, it)
                }
            )
        }
    }
}
