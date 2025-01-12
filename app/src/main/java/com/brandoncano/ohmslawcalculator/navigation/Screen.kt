package com.brandoncano.ohmslawcalculator.navigation

/**
 * Note: Keep screens in alphabetical order
 */
sealed class Screen(val route: String) {
    data object About : Screen("about")
    data object Calculator : Screen("calculator")
    data object LearnOhmsLaw : Screen("ohms_law/learn")
}
