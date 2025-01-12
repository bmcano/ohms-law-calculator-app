package com.brandoncano.ohmslawcalculator.model

import com.brandoncano.ohmslawcalculator.constants.Formulas

data class OhmsLaw(
    val formula: String = Formulas.Volts.EQ1,
    val value1: String = "",
    val units1: String = "A",
    val value2: String = "",
    val units2: String = "Ω",
)
