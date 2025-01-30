package com.effectivemobile.domain.repositories

import com.effectivemobile.domain.models.VacancyModel
import kotlinx.coroutines.flow.Flow

interface DataBaseRepository {

    suspend fun saveVacancies(listVacancy: List<VacancyModel>)

    fun getAllVacancies(): Flow<List<VacancyModel>>


    suspend fun updateVacancy(vacancy: VacancyModel)
}