package com.brandoncano.ohmslawcalculator.util

import kotlin.math.pow

object CalculatePower {

    // P = V × I
    fun executeEq1(voltage: String, volts: String, current: String, amps: String): String {
        val v = voltage.toDoubleOrNull() ?: return "0.00"
        val i = current.toDoubleOrNull() ?: return "0.00"
        val p = v * i
        val multiplier = MultiplierFromUnits.execute(volts) * MultiplierFromUnits.execute(amps)
        return (p * multiplier).toString()
    }

    // P = I² × R
    fun executeEq2(current: String, amps: String, resistance: String, ohms: String): String {
        val i = current.toDoubleOrNull() ?: return "0.00"
        val r = resistance.toDoubleOrNull() ?: return "0.00"
        val p = i * i * r
        val multiplier = (MultiplierFromUnits.execute(amps).pow(2)) * MultiplierFromUnits.execute(ohms)
        return (p * multiplier).toString()
    }

    // P = V² / R
    fun executeEq3(voltage: String, volts: String, resistance: String, ohms: String): String {
        val v = voltage.toDoubleOrNull() ?: return "0.00"
        val r = resistance.toDoubleOrNull() ?: return "0.00"
        if (r == 0.0) return "NaN"
        val p = (v * v) / r
        val multiplier = (MultiplierFromUnits.execute(volts).pow(2)) / MultiplierFromUnits.execute(ohms)
        return (p * multiplier).toString()
    }
}
