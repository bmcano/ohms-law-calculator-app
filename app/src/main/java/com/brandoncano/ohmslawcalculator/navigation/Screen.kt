package com.brandoncano.ohmslawcalculator.navigation

/**
 * Note: Keep screens in alphabetical order
 */
sealed class Screen(val route: String) {
    data object About : Screen("about")
    data object CalculatorCurrent : Screen("calculator/current")
    data object CalculatorPower : Screen("calculator/power")
    data object CalculatorResistance : Screen("calculator/resistance")
    data object CalculatorVoltage : Screen("calculator/voltage")
    data object Home : Screen("home")
    data object LearnOhmsLaw : Screen("ohms_law/learn")
}
