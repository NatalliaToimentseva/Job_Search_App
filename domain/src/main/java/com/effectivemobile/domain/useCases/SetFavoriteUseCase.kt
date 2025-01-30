package com.effectivemobile.domain.useCases

import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.domain.repositories.DataBaseRepository
import com.effectivemobile.domain.results.VacancyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class SetFavoriteUseCase(
    private val dbRepository: DataBaseRepository
) {

    fun setIsFavorite(vacancy: VacancyModel): Flow<VacancyResult> {
        return flow {
            emit(VacancyResult.Loading)
            dbRepository.updateVacancy(vacancy)
            emit(VacancyResult.SuccessAdd)
        }.catch { e ->
            e.message?.let {
                emit(VacancyResult.Error(it))
            }
        }
    }
}