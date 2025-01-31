package com.effectivemobile.domain.results

import com.effectivemobile.domain.models.OfferModel

sealed class JobResult {

    data class Success (val offersList: List<OfferModel>) : JobResult()

    data class Error(val message: String) : JobResult()

    data object Loading : JobResult()
}