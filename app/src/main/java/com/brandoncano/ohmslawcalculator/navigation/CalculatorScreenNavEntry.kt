package com.brandoncano.ohmslawcalculator.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.ohmslawcalculator.model.CalculatorViewModel
import com.brandoncano.ohmslawcalculator.ui.screens.calculator.CalculatorScreen

fun NavGraphBuilder.calculatorScreen(
    navHostController: NavHostController,
    onOpenThemeDialog: () -> Unit,
) {
    composable(
        route = Screen.Calculator.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        val context = LocalContext.current
        val focusManager = LocalFocusManager.current
        val openMenu = remember { mutableStateOf(false) }
        val reset = remember { mutableStateOf(false) }
        val viewModel: CalculatorViewModel = viewModel()
        val ohmsLaw by viewModel.ohmsLaw.collectAsState()
        val navBarSelection by viewModel.navBarSelection.collectAsState()
        val selectedFormulas by viewModel.selectedFormulas.collectAsState()
        val formulaDetails by viewModel.formulaDetails.collectAsState()

        CalculatorScreen(
            openMenu = openMenu,
            reset = reset,
            ohmsLaw = ohmsLaw,
            navBarPosition = navBarSelection,
            selectedFormulas = selectedFormulas,
            formulaDetails = formulaDetails,
            onOpenThemeDialog = onOpenThemeDialog,
            onClearSelectionsTapped = {
                openMenu.value = false
                reset.value = true
                viewModel.clear()
                focusManager.clearFocus()
            },
            onNavBarSelectionChanged = { viewModel.updateNavBarSelection(it) },
            onFormulaSelected = { viewModel.updateFormula(it) },
            onValuesChanged = { v1, u1, v2, u2 -> viewModel.updateValues(v1, u1, v2, u2) },
            onLearnOhmsLawTapped = { navigateToLearn(navHostController) },
            onRateThisAppTapped = { navigateToGooglePlay(context) } ,
            onViewOurAppsTapped = { navigateToOurApps(navHostController) },
            onDonateTapped = { navigateToDonate(navHostController) },
            onAboutTapped = { navigateToAbout(navHostController) },
        )
    }
}
