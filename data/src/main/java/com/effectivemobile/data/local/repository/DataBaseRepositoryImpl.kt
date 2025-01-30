package com.effectivemobile.data.local.repository

import com.effectivemobile.data.local.dao.VacancyDao
import com.effectivemobile.data.local.mapper.toListVacancy
import com.effectivemobile.data.local.mapper.toListVacancyEntity
import com.effectivemobile.data.local.mapper.toVacancyEntity
import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.domain.repositories.DataBaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataBaseRepositoryImpl(
    private val dao: VacancyDao
) : DataBaseRepository {

    override suspend fun saveVacancies(listVacancy: List<VacancyModel>) =
        dao.insertVacancy(listVacancy.toListVacancyEntity())

    override fun getAllVacancies(): Flow<List<VacancyModel>> =
        dao.getAllVacancies().map { it.toListVacancy() }

    override suspend fun updateVacancy(vacancy: VacancyModel) =
        dao.updateVacancy(vacancy.toVacancyEntity())
}