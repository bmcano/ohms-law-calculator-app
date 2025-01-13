package com.brandoncano.ohmslawcalculator.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.brandoncano.ohmslawcalculator.constants.Links
import com.brandoncano.ohmslawcalculator.navigation.calculators.calculatorCurrent
import com.brandoncano.ohmslawcalculator.navigation.calculators.calculatorPower
import com.brandoncano.ohmslawcalculator.navigation.calculators.calculatorResistance
import com.brandoncano.ohmslawcalculator.navigation.calculators.calculatorVoltage
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.navigation.SharedScreens
import com.brandoncano.sharedcomponents.navigation.donateScreen
import com.brandoncano.sharedcomponents.navigation.viewOurAppsScreen
import com.brandoncano.sharedcomponents.utils.OpenLink

@Composable
fun Navigation(onOpenThemeDialog: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        aboutScreen(navController)
        calculatorCurrent(navController)
        calculatorPower(navController)
        calculatorResistance(navController)
        calculatorVoltage(navController)
        homeScreen(navController, onOpenThemeDialog)
        learnOhmsLawScreen(navController)
        // from shared library
        donateScreen(navController)
        viewOurAppsScreen(navController, Apps.OhmsLaw)
    }
}

fun navigateToAbout(navController: NavHostController) {
    navController.navigate(Screen.About.route)
}

fun navigateToLearn(navController: NavHostController) {
    navController.navigate(Screen.LearnOhmsLaw.route)
}

fun navigateToVoltage(navController: NavHostController) {
    navController.navigate(Screen.CalculatorVoltage.route)
}

fun navigateToCurrent(navController: NavHostController) {
    navController.navigate(Screen.CalculatorCurrent.route)
}

fun navigateToResistance(navController: NavHostController) {
    navController.navigate(Screen.CalculatorResistance.route)
}

fun navigateToPower(navController: NavHostController) {
    navController.navigate(Screen.CalculatorPower.route)
}

fun navigateToGooglePlay(context: Context) {
    OpenLink.execute(context, Links.OHMS_LAW_PLAYSTORE)
}

fun navigateToOurApps(navController: NavHostController) {
    navController.navigate(SharedScreens.ViewOurApps.route)
}

fun navigateToDonate(navController: NavHostController) {
    navController.navigate(SharedScreens.Donate.route)
}
