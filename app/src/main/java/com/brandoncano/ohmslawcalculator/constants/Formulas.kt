package com.brandoncano.ohmslawcalculator.constants

/**
 * Note: From the Ohm's Law Circle
 */
object Formulas {

    object Volts {
        const val EQ1 = "V = I × R"
        const val EQ2 = "V = P / I"
        const val EQ3 = "V = sqrt(P × R)"
    }

    object Amps {
        const val EQ1 = "I = V / R"
        const val EQ2 = "I = P / V"
        const val EQ3 = "I = sqrt(P / R)"
    }

    object Resistance {
        const val EQ1 = "R = V / I"
        const val EQ2 = "R = V^2 / P"
        const val EQ3 = "R = P / I^2"
    }

    object Power {
        const val EQ1 = "P = V × I"
        const val EQ2 = "P = R × I^2"
        const val EQ3 = "P = V^2 / R"
    }
}
