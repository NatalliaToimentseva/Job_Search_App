package com.effectivemobile.domain.useCases

import com.effectivemobile.domain.repositories.DataBaseRepository
import com.effectivemobile.domain.results.VacancyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GetVacanciesFromDbUseCase(
    private val dbRepository: DataBaseRepository
) {

    fun getVacancies(): Flow<VacancyResult> {
        return flow {
            emit(VacancyResult.Loading)
            dbRepository.getAllVacancies().collect { vacancies ->
                emit(VacancyResult.Success(vacancies))
            }
        }.catch { e ->
            e.message?.let {
                emit(VacancyResult.Error(it))
            }
        }
    }
}