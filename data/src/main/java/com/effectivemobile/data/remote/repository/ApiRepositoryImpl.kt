package com.effectivemobile.data.remote.repository

import com.effectivemobile.data.remote.Api
import com.effectivemobile.data.remote.mapper.toJob
import com.effectivemobile.domain.repositories.ApiRepository
import com.effectivemobile.domain.results.DataResult

class ApiRepositoryImpl(private val api: Api): ApiRepository {

    override suspend fun getJobData(): DataResult {
        val response = api.loadJobData()
        return if (response.isSuccessful) {
            response.body()?.let {
                DataResult.Success(it.toJob())
            } ?: DataResult.Error("Empty data")

        } else DataResult.Error(response.message())
    }
}