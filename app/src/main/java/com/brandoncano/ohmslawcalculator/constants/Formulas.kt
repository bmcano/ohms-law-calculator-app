package com.brandoncano.ohmslawcalculator.constants

/**
 * Note: From the Ohm's Law Circle
 */
object Formulas {

    object Volts {
        const val EQ1 = "V = I × R"
        const val EQ2 = "V = P / I"
        const val EQ3 = "V = √(P × R)"
    }

    object Amps {
        const val EQ1 = "I = V / R"
        const val EQ2 = "I = P / V"
        const val EQ3 = "I = √(P / R)"
    }

    object Resistance {
        const val EQ1 = "R = V / I"
        const val EQ2 = "R = V² / P"
        const val EQ3 = "R = P / I²"
    }

    object Power {
        const val EQ1 = "P = V × I"
        const val EQ2 = "P = I² × R"
        const val EQ3 = "P = V² / R"
    }
}
