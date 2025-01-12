package com.brandoncano.ohmslawcalculator.constants

object DropdownLists {
    val UNITS_VOLTS = listOf("nV", "μV", "mV", "V", "kV", "MV")
    val UNITS_AMPS = listOf("nA", "μA", "mA", "A", "kA", "MA")
    val UNITS_RESISTANCE = listOf("nΩ", "μΩ", "mΩ", "Ω", "kΩ", "MΩ")
    val UNITS_POWER = listOf("nW", "μW", "mW", "W", "kW", "MW")

    val FORMULAS_VOLTS = listOf(Formulas.Volts.EQ1, Formulas.Volts.EQ2, Formulas.Volts.EQ3)
    val FORMULAS_AMPS = listOf(Formulas.Amps.EQ1, Formulas.Amps.EQ2, Formulas.Amps.EQ3)
    val FORMULAS_RESISTANCE = listOf(Formulas.Resistance.EQ1, Formulas.Resistance.EQ2, Formulas.Resistance.EQ3)
    val FORMULAS_POWER = listOf(Formulas.Power.EQ1, Formulas.Power.EQ2, Formulas.Power.EQ3)
}