package com.brandoncano.ohmslawcalculator.model

import com.brandoncano.ohmslawcalculator.constants.Formulas
import com.brandoncano.ohmslawcalculator.util.CalculateCurrent
import com.brandoncano.ohmslawcalculator.util.CalculatePower
import com.brandoncano.ohmslawcalculator.util.CalculateResistance
import com.brandoncano.ohmslawcalculator.util.CalculateVoltage

data class OhmsLaw(
    val formula: String = Formulas.Volts.EQ1,
    val value1: String = "",
    val units1: String = "A",
    val value2: String = "",
    val units2: String = "Ω",
    var result: String = "0.00"
) {
    fun calculateResult() {
        this.result = when (formula) {
            Formulas.Volts.EQ1, Formulas.Volts.EQ2, Formulas.Volts.EQ3 ->
                CalculateVoltage.execute(value1, units1, value2, units2, formula)
            Formulas.Amps.EQ1, Formulas.Amps.EQ2, Formulas.Amps.EQ3 ->
                CalculateCurrent.execute(value1, units1, value2, units2, formula)
            Formulas.Resistance.EQ1, Formulas.Resistance.EQ2, Formulas.Resistance.EQ3 ->
                CalculateResistance.execute(value1, units1, value2, units2, formula)
            Formulas.Power.EQ1, Formulas.Power.EQ2, Formulas.Power.EQ3 ->
                CalculatePower.execute(value1, units1, value2, units2, formula)
            else -> CalculateVoltage.execute(value1, units1, value2, units2, formula)
        }
    }
}
