package com.brandoncano.ohmslawcalculator.model

import androidx.lifecycle.ViewModel
import com.brandoncano.ohmslawcalculator.constants.DropdownLists
import com.brandoncano.ohmslawcalculator.data.FormulaDetails
import com.brandoncano.ohmslawcalculator.util.GetFormulaDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel: ViewModel() {

    private val _ohmsLaw = MutableStateFlow(OhmsLaw())
    val ohmsLaw: StateFlow<OhmsLaw> get() = _ohmsLaw

    private val _navBarSelection = MutableStateFlow(0)
    val navBarSelection: StateFlow<Int> get() = _navBarSelection

    private val _selectedFormulas = MutableStateFlow(DropdownLists.FORMULAS_VOLTS)
    val selectedFormulas: StateFlow<List<String>> get() = _selectedFormulas

    private val _formulaDetails = MutableStateFlow(FormulaDetails())
    val formulaDetails: StateFlow<FormulaDetails> get() = _formulaDetails

    fun clear() {
        _ohmsLaw.value = OhmsLaw(
            formula = _ohmsLaw.value.formula,
            units1 = _ohmsLaw.value.units1,
            units2 = _ohmsLaw.value.units2
        )
    }

    fun updateValues(v1: String, u1: String, v2: String, u2: String) {
        _ohmsLaw.value = _ohmsLaw.value.copy(value1 = v1, units1 = u1, value2 = v2, units2 = u2)
        _ohmsLaw.value.calculateResult()
    }

    fun updateFormula(formula: String) {
        val details = GetFormulaDetails.execute(formula)
        _formulaDetails.value = details
        _ohmsLaw.value = _ohmsLaw.value.copy(formula = formula)
        _ohmsLaw.value.calculateResult()
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
