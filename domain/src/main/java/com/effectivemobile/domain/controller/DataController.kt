package com.effectivemobile.domain.controller

import com.effectivemobile.domain.models.JobModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class DataController {

    val jobData = MutableSharedFlow<JobModel>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    fun listenJobData(): Flow<JobModel> = jobData
}