package com.effectivemobile.domain.results

import com.effectivemobile.domain.models.VacancyModel

sealed class VacancyResult {

    data class Success(val vacancyList: List<VacancyModel>) : VacancyResult()

    data object SuccessAdd: VacancyResult()

    data class Error(val message: String) : VacancyResult()

    data object Loading : VacancyResult()
}