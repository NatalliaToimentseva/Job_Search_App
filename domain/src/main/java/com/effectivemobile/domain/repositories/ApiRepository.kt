package com.effectivemobile.domain.repositories

import com.effectivemobile.domain.results.DataResult

interface ApiRepository {

    suspend fun getJobData(): DataResult
}