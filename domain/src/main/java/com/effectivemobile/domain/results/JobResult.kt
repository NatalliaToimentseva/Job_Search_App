package com.effectivemobile.domain.results

sealed class JobResult {

    data object Success : JobResult()

    data class Error(val message: String) : JobResult()

    data object Loading : JobResult()
}