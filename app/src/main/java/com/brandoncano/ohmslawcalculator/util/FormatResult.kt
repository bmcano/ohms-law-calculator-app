package com.brandoncano.ohmslawcalculator.util

import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Job: Rounds the result to 2 decimal places
 */
object FormatResult {

    private val decimalFormat = DecimalFormat("0.###").apply {
        roundingMode = RoundingMode.HALF_UP
    }

    fun execute(value: Double): String {
        return decimalFormat.format(value)
    }
}
