package com.brandoncano.ohmslawcalculator.util

/**
 * Job: Gets a multiplier from a unit prefix, 1 is its just A, V, etc.
 */
object MultiplierFromUnits {

    fun execute(units: String): Double {
        val prefix = units[0]
        return when (prefix) {
            'n' -> 0.000000001
            'μ' -> 0.000001
            'm' -> 0.001
            'k' -> 1_000.0
            'M' -> 1_000_000.0
            else -> 1.0
        }
    }
}
