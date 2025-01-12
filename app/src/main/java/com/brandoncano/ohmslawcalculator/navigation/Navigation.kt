package com.brandoncano.ohmslawcalculator.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.brandoncano.ohmslawcalculator.constants.Links
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
        startDestination = Screen.Calculator.route
    ) {
        aboutScreen(navController)
        calculatorScreen(navController, onOpenThemeDialog)
        learnOhmsLawScreen(navController)
        // from shared library
        donateScreen(navController)
        viewOurAppsScreen(navController, Apps.Resistor)
    }
}

fun navigateToAbout(navController: NavHostController) {
    navController.navigate(Screen.About.route)
}

fun navigateToLearn(navController: NavHostController) {
    navController.navigate(Screen.LearnOhmsLaw.route)
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
