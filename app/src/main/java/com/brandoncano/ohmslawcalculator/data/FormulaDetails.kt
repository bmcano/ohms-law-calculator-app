package com.brandoncano.ohmslawcalculator.data

import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.constants.DropdownLists

data class FormulaDetails(
    val value1Label: Int = R.string.calculator_amps,
    val value1UnitList: List<String> = DropdownLists.UNITS_AMPS,
    val value2Label: Int = R.string.calculator_resistance,
    val value2UnitList: List<String> = DropdownLists.UNITS_RESISTANCE,
)
