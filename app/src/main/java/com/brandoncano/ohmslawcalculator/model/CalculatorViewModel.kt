package com.brandoncano.ohmslawcalculator.model

import androidx.lifecycle.ViewModel
import com.brandoncano.ohmslawcalculator.constants.DropdownLists
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel: ViewModel() {

    private val _ohmsLaw = MutableStateFlow(OhmsLaw())
    val ohmsLaw: StateFlow<OhmsLaw> get() = _ohmsLaw

    private val _navBarSelection = MutableStateFlow(0)
    val navBarSelection: StateFlow<Int> get() = _navBarSelection

    private val _selectedFormulas = MutableStateFlow(DropdownLists.FORMULAS_VOLTS)
    val selectedFormulas: StateFlow<List<String>> get() = _selectedFormulas

    fun clear() {

    }

    fun updateFormula(formula: String) {
        _ohmsLaw.value = _ohmsLaw.value.copy(formula = formula)
    }

    fun updateNavBarSelection(number: Int) {
        val navBarSelection = number.coerceIn(0..3)
        _navBarSelection.value = navBarSelection
        _selectedFormulas.value = when (navBarSelection) {
            0 -> DropdownLists.FORMULAS_VOLTS
            1 -> DropdownLists.FORMULAS_AMPS
            2 -> DropdownLists.FORMULAS_RESISTANCE
            3 -> DropdownLists.FORMULAS_POWER
            else -> DropdownLists.FORMULAS_VOLTS
        }
        updateFormula(_selectedFormulas.value[0])
    }
}
