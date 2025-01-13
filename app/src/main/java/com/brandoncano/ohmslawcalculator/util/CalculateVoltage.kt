package com.brandoncano.ohmslawcalculator.util

import kotlin.math.sqrt

object CalculateVoltage {

    // V = I × R
    fun executeEq1(current: String, amps: String, resistance: String, ohms: String): String {
        val i = current.toDoubleOrNull() ?: return "0.00"
        val r = resistance.toDoubleOrNull() ?: return "0.00"
        val v = i * r
        val multiplier = MultiplierFromUnits.execute(amps) * MultiplierFromUnits.execute(ohms)
        return (v * multiplier).toString()
    }

    // V = P / I
    fun executeEq2(power: String, watts: String, current: String, amps: String): String {
        val p = power.toDoubleOrNull() ?: return "0.00"
        val i = current.toDoubleOrNull() ?: return "0.00"
        if (i == 0.0) return "NaN"
        val v = p / i
        val multiplier = MultiplierFromUnits.execute(watts) * MultiplierFromUnits.execute(amps)
        return (v * multiplier).toString()
    }

    // V = √(P × R)
    fun executeEq3(power: String, watts: String, resistance: String, ohms: String): String {
        val p = power.toDoubleOrNull() ?: return "0.00"
        val r = resistance.toDoubleOrNull() ?: return "0.00"
        val v = sqrt(p * r)
        val multiplier = MultiplierFromUnits.execute(watts) * MultiplierFromUnits.execute(ohms)
        return (v * multiplier).toString()
    }
}
