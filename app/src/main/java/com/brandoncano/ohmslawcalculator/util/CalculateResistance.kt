package com.brandoncano.ohmslawcalculator.util

import kotlin.math.pow

object CalculateResistance {

    // R = V / I
    fun executeEq1(voltage: String, volts: String, current: String, amps: String): String {
        val v = voltage.toDoubleOrNull() ?: return "0.00"
        val i = current.toDoubleOrNull() ?: return "0.00"
        if (i == 0.0) return "NaN"
        val r = v / i
        val multiplier = MultiplierFromUnits.execute(volts) / MultiplierFromUnits.execute(amps)
        return (r * multiplier).toString()
    }

    // R = V² / P
    fun executeEq2(voltage: String, volts: String, power: String, watts: String): String {
        val v = voltage.toDoubleOrNull() ?: return "0.00"
        val p = power.toDoubleOrNull() ?: return "0.00"
        if (p == 0.0) return "NaN"
        val r = (v * v) / p
        val multiplier = (MultiplierFromUnits.execute(volts).pow(2)) / MultiplierFromUnits.execute(watts)
        return (r * multiplier).toString()
    }

    // R = P / I²
    fun executeEq3(power: String, watts: String, current: String, amps: String): String {
        val p = power.toDoubleOrNull() ?: return "0.00"
        val i = current.toDoubleOrNull() ?: return "0.00"
        if (i == 0.0) return "NaN"
        val r = p / (i * i)
        val multiplier = MultiplierFromUnits.execute(watts) / (MultiplierFromUnits.execute(amps).pow(2))
        return (r * multiplier).toString()
    }
}
