package com.brandoncano.ohmslawcalculator.util

import kotlin.math.abs

/**
 * Job: Takes a raw value and computes what unit prefix it should have as well as the adjusted value
 */
object FindBestUnit {

    fun execute(value: Double): Pair<Double, String> {
        val absValue = abs(value)
        return when {
            absValue >= 1_000_000_000 -> (value / 1_000_000_000) to "G"
            absValue >= 1_000_000 -> (value / 1_000_000) to "M"
            absValue >= 1_000 -> (value / 1_000) to "k"
            absValue >= 1 -> value to ""
            absValue >= 0.001 -> (value * 1_000) to "m"
            absValue >= 0.000001 -> (value * 1_000_000) to "μ"
            absValue < 0.000001 -> (value * 1_000_000_000) to "n"
            else -> value to ""
        }
    }
}
