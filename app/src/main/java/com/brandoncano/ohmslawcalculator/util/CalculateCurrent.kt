package com.brandoncano.ohmslawcalculator.util

import com.brandoncano.ohmslawcalculator.constants.Formulas
import kotlin.math.sqrt

/**
 * Job: Calculate and format the current into the proper string for display
 */
object CalculateCurrent {

    fun execute(v1: String, u1: String, v2: String, u2: String, formula: String): String {
        val value1 = v1.toDoubleOrNull() ?: return "0.00"
        val value2 = v2.toDoubleOrNull() ?: return "0.00"
        if (value2 == 0.0) return "NaN"

        val m1 = MultiplierFromUnits.execute(u1)
        val m2 = MultiplierFromUnits.execute(u2)
        val i = when (formula) {
            Formulas.Amps.EQ3 -> eq3(value1, m1, value2, m2)
            Formulas.Amps.EQ2 -> eq2(value1, m1, value2, m2)
            else -> eq1(value1, m1, value2, m2)
        }

        val result = FindBestUnit.execute(i)
        return "${FormatResult.execute(result.first)} ${result.second}A"
    }

    private fun eq1(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        return (v1 * m1) / (v2 * m2) // I = V / R
    }

    private fun eq2(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        return (v1 * m1) / (v2 * m2) // I = P / V
    }

    private fun eq3(v1: Double, m1: Double, v2: Double, m2: Double): Double {
        return sqrt((v1 * m1) / (v2 * m2)) // I = √(P / R)
    }
}
