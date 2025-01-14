package com.brandoncano.ohmslawcalculator.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brandoncano.ohmslawcalculator.data.FormulaDetails
import com.brandoncano.ohmslawcalculator.util.GetFormulaDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalculatorViewModel(formula: String): ViewModel() {

    private val _ohmsLaw = MutableStateFlow(OhmsLaw())
    val ohmsLaw: StateFlow<OhmsLaw> get() = _ohmsLaw

    private val _formulaDetails = MutableStateFlow(FormulaDetails())
    val formulaDetails: StateFlow<FormulaDetails> get() = _formulaDetails

    init {
        viewModelScope.launch {
            _formulaDetails.value = GetFormulaDetails.execute(formula)
            val units1 = _formulaDetails.value.value1UnitList[2]
            val units2 = _formulaDetails.value.value2UnitList[2]
            _ohmsLaw.value = OhmsLaw(formula = formula, units1 = units1, units2 = units2)
        }
    }

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
        val units1 = details.value1UnitList[2]
        val units2 = details.value2UnitList[2]
        _ohmsLaw.value = _ohmsLaw.value.copy(formula = formula, units1 = units1, units2 = units2)
        _ohmsLaw.value.calculateResult()
    }
}
