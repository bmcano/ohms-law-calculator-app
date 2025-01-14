package com.brandoncano.ohmslawcalculator.util

import com.brandoncano.ohmslawcalculator.constants.Formulas
import kotlin.math.pow

/**
 * Job: Calculate and format the power into the proper string for display
 */
object CalculatePower {

    fun execute(v1: String, u1: String, v2: String, u2: String, formula: String): String {
        val value1 = v1.toDoubleOrNull() ?: return "0.00"
        val value2 = v2.toDoubleOrNull() ?: return "0.00"

        val m1 = MultiplierFromUnits.execute(u1)
        val m2 = MultiplierFromUnits.execute(u2)
        val p = when (formula) {
            Formulas.Power.EQ3 -> eq3(value1, m1, value2, m2)
            Formulas.Power.EQ2 -> eq2(value1, m1, value2, m2)
            else -> eq1(value1, m1, value2, m2)
        }

        val result = FindBestUnit.execute(p)
        if (result.first.isNaN()) return "NaN"
        return "${FormatResult.execute(result.first)} ${result.second}W"
    }

    private fun eq1(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        return (v1 * m1) * (v2 * m2) // P = V × I
    }

    private fun eq2(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        return (v1 * m1).pow(2) * (v2 * m2) // P = I² × R
    }

    private fun eq3(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        if (v2 == 0.0) return Double.NaN
        return (v1 * m1).pow(2) / (v2 * m2) // P = V² / R
    }
}
