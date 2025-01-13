package com.brandoncano.ohmslawcalculator.util

import kotlin.math.sqrt

object CalculateCurrent {

    // I = V / R
    fun executeEq1(voltage: String, volts: String, resistance: String, ohms: String): String {
        val v = voltage.toDoubleOrNull() ?: return "0.00"
        val r = resistance.toDoubleOrNull() ?: return "0.00"
        if (r == 0.0) return "NaN"
        val i = v / r
        val multiplier = MultiplierFromUnits.execute(volts) / MultiplierFromUnits.execute(ohms)
        return (i * multiplier).toString()
    }

    // I = P / V
    fun executeEq2(power: String, watts: String, voltage: String, volts: String): String {
        val p = power.toDoubleOrNull() ?: return "0.00"
        val v = voltage.toDoubleOrNull() ?: return "0.00"
        if (v == 0.0) return "NaN"
        val i = p / v
        val multiplier = MultiplierFromUnits.execute(watts) / MultiplierFromUnits.execute(volts)
        return (i * multiplier).toString()
    }

    // I = √(P / R)
    fun executeEq3(power: String, watts: String, resistance: String, ohms: String): String {
        val p = power.toDoubleOrNull() ?: return "0.00"
        val r = resistance.toDoubleOrNull() ?: return "0.00"
        if (r == 0.0) return "NaN"
        val i = sqrt(p / r)
        val multiplier = MultiplierFromUnits.execute(watts) / MultiplierFromUnits.execute(ohms)
        return (i * multiplier).toString()
    }
}
