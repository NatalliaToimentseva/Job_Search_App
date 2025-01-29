package com.effectivemobile.domain.results

import com.effectivemobile.domain.models.JobModel

sealed class DataResult {

    data class Success(val jobData: JobModel): DataResult()

    data class Error(val message: String): DataResult()
}