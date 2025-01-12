package com.brandoncano.ohmslawcalculator.navigation

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.ohmslawcalculator.ui.screens.learn.LearnOhmsLawScreen

fun NavGraphBuilder.learnOhmsLawScreen(
    navHostController: NavHostController,
) {
    composable(
        route = Screen.LearnOhmsLaw.route,
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { slideOutVertically(targetOffsetY = { it }) },
    ) {
        LearnOhmsLawScreen(
            onNavigateBack = { navHostController.popBackStack() },
        )
    }
}