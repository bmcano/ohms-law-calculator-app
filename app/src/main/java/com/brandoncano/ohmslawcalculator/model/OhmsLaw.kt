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
            Formulas.Volts.EQ1 -> CalculateVoltage.executeEq1(value1, units1, value2, units2)
            Formulas.Volts.EQ2 -> CalculateVoltage.executeEq2(value1, units1, value2, units2)
            Formulas.Volts.EQ3 -> CalculateVoltage.executeEq3(value1, units1, value2, units2)
            Formulas.Amps.EQ1 -> CalculateCurrent.executeEq1(value1, units1, value2, units2)
            Formulas.Amps.EQ2 -> CalculateCurrent.executeEq2(value1, units1, value2, units2)
            Formulas.Amps.EQ3 -> CalculateCurrent.executeEq3(value1, units1, value2, units2)
            Formulas.Resistance.EQ1 -> CalculateResistance.executeEq1(value1, units1, value2, units2)
            Formulas.Resistance.EQ2 -> CalculateResistance.executeEq2(value1, units1, value2, units2)
            Formulas.Resistance.EQ3 -> CalculateResistance.executeEq3(value1, units1, value2, units2)
            Formulas.Power.EQ1 -> CalculatePower.executeEq1(value1, units1, value2, units2)
            Formulas.Power.EQ2 -> CalculatePower.executeEq2(value1, units1, value2, units2)
            Formulas.Power.EQ3 -> CalculatePower.executeEq3(value1, units1, value2, units2)
            else -> CalculateVoltage.executeEq1(value1, units1, value2, units2)
        }
    }

    fun getDisplayText(): String {
        // TODO - need to round and get proper unit adjustments
        val unit = when (this.formula[0]) {
            'V' -> "V"
            'I' -> "A"
            'R' -> "Ω"
            'P' -> "W"
            else -> "V"
        }
        return "$result $unit"
    }
}
