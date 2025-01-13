package com.brandoncano.ohmslawcalculator.navigation.calculators

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.ohmslawcalculator.constants.DropdownLists
import com.brandoncano.ohmslawcalculator.constants.Formulas
import com.brandoncano.ohmslawcalculator.model.CalculatorViewModel
import com.brandoncano.ohmslawcalculator.model.CalculatorViewModelFactory
import com.brandoncano.ohmslawcalculator.navigation.Screen
import com.brandoncano.ohmslawcalculator.navigation.navigateToAbout
import com.brandoncano.ohmslawcalculator.ui.screens.calculator.CalculatorScreen

fun NavGraphBuilder.calculatorCurrent(
    navHostController: NavHostController,
) {
    composable(
        route = Screen.CalculatorCurrent.route,
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
    ) {
        val focusManager = LocalFocusManager.current
        val openMenu = remember { mutableStateOf(false) }
        val reset = remember { mutableStateOf(false) }
        val viewModel: CalculatorViewModel = viewModel(factory = CalculatorViewModelFactory(Formulas.Amps.EQ1))
        val ohmsLaw by viewModel.ohmsLaw.collectAsState()
        val formulaDetails by viewModel.formulaDetails.collectAsState()

        CalculatorScreen(
            openMenu = openMenu,
            reset = reset,
            ohmsLaw = ohmsLaw,
            selectedFormulas = DropdownLists.FORMULAS_AMPS,
            formulaDetails = formulaDetails,
            onNavigateBack = { navHostController.popBackStack() },
            onClearSelectionsTapped = {
                openMenu.value = false
                reset.value = true
                viewModel.clear()
                focusManager.clearFocus()
            },
            onAboutTapped = { navigateToAbout(navHostController) },
            onFormulaSelected = { viewModel.updateFormula(it) },
            onValuesChanged = { v1, u1, v2, u2 ->
                viewModel.updateValues(v1, u1, v2, u2)
                reset.value = false
            },
        )
    }
}
