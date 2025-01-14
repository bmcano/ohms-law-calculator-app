package com.brandoncano.ohmslawcalculator.util

import com.brandoncano.ohmslawcalculator.constants.Formulas
import kotlin.math.sqrt

/**
 * Job: Calculate and format the voltage into the proper string for display
 */
object CalculateVoltage {

    fun execute(v1: String, u1: String, v2: String, u2: String, formula: String): String {
        val value1 = v1.toDoubleOrNull() ?: return "0.00"
        val value2 = v2.toDoubleOrNull() ?: return "0.00"

        val m1 = MultiplierFromUnits.execute(u1)
        val m2 = MultiplierFromUnits.execute(u2)
        val i = when (formula) {
            Formulas.Volts.EQ3 -> eq3(value1, m1, value2, m2)
            Formulas.Volts.EQ2 -> eq2(value1, m1, value2, m2)
            else -> eq1(value1, m1, value2, m2)
        }

        val result = FindBestUnit.execute(i)
        if (result.first.isNaN()) return "NaN"
        return "${FormatResult.execute(result.first)} ${result.second}V"
    }

    private fun eq1(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        return (v1 * m1) * (v2 * m2) // V = I × R
    }

    private fun eq2(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        if (v2 == 0.0) return Double.NaN
        return (v1 * m1) / (v2 * m2) // V = P / I
    }

    private fun eq3(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        return sqrt((v1 * m1) * (v2 * m2)) // V = √(P × R)
    }
}
