package com.brandoncano.ohmslawcalculator.util

import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.constants.DropdownLists
import com.brandoncano.ohmslawcalculator.constants.Formulas
import com.brandoncano.ohmslawcalculator.data.FormulaDetails

/**
 * Job: Based on a formula get the corresponding details to display
 */
object GetFormulaDetails {

    fun execute(formula: String): FormulaDetails {
        return when (formula) {
            Formulas.Volts.EQ1, Formulas.Power.EQ2 -> FormulaDetails(
                R.string.calculator_amps, DropdownLists.UNITS_AMPS,
                R.string.calculator_resistance, DropdownLists.UNITS_RESISTANCE,
            )
            Formulas.Volts.EQ2, Formulas.Resistance.EQ3 -> FormulaDetails(
                R.string.calculator_power, DropdownLists.UNITS_POWER,
                R.string.calculator_amps, DropdownLists.UNITS_AMPS,
            )
            Formulas.Volts.EQ3, Formulas.Amps.EQ3 -> FormulaDetails(
                R.string.calculator_power, DropdownLists.UNITS_POWER,
                R.string.calculator_resistance, DropdownLists.UNITS_RESISTANCE,
            )
            Formulas.Amps.EQ1, Formulas.Power.EQ3 -> FormulaDetails(
                R.string.calculator_volts, DropdownLists.UNITS_VOLTS,
                R.string.calculator_resistance, DropdownLists.UNITS_RESISTANCE,
            )
            Formulas.Amps.EQ2 -> FormulaDetails(
                R.string.calculator_power, DropdownLists.UNITS_POWER,
                R.string.calculator_volts, DropdownLists.UNITS_VOLTS,
            )
            Formulas.Resistance.EQ1, Formulas.Power.EQ1 -> FormulaDetails(
                R.string.calculator_volts, DropdownLists.UNITS_VOLTS,
                R.string.calculator_amps, DropdownLists.UNITS_AMPS,
            )
            Formulas.Resistance.EQ2 -> FormulaDetails(
                R.string.calculator_volts, DropdownLists.UNITS_VOLTS,
                R.string.calculator_power, DropdownLists.UNITS_POWER,
            )
            else -> FormulaDetails(
                R.string.calculator_amps, DropdownLists.UNITS_AMPS,
                R.string.calculator_resistance, DropdownLists.UNITS_RESISTANCE,
            )
        }
    }
}
