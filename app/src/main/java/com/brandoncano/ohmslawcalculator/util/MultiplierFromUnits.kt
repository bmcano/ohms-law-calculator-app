package com.brandoncano.ohmslawcalculator.util

/**
 * Job: Gets a multiplier from a unit, 1 is its just A, V, etc.
 */
object MultiplierFromUnits {

    fun execute(units: String): Double {
        return when (units) {
            "μA", "μV", "μW", "μΩ" -> 0.000001
            "mA", "mV", "mW", "mΩ" -> 0.001
            "kA", "kV", "kW", "kΩ" -> 1_000.0
            "MA", "MV", "MW", "MΩ" -> 1_000_000.0
            else -> 1.0
        }
    }
}
