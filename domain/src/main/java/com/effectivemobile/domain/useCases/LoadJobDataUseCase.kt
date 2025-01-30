package com.effectivemobile.domain.useCases

import com.effectivemobile.domain.controller.DataController
import com.effectivemobile.domain.repositories.ApiRepository
import com.effectivemobile.domain.repositories.DataBaseRepository
import com.effectivemobile.domain.results.DataResult
import com.effectivemobile.domain.results.JobResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoadJobDataUseCase(
    private val repository: ApiRepository,
    private val dbRepository: DataBaseRepository,
    private val dataController: DataController
) {

    fun loadJob(): Flow<JobResult> {
        return flow {
            emit(JobResult.Loading)
            when (val result = repository.getJobData()) {
                is DataResult.Error -> emit(JobResult.Error(result.message))
                is DataResult.Success -> {
                    emit(JobResult.Success)
                    dataController.jobData.tryEmit(result.jobData)
                    dbRepository.saveVacancies(result.jobData.vacancies)
                }
            }
        }
    }
}