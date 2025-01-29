package com.effectivemobile.data.remote

import com.effectivemobile.data.remote.response.JobResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val ID = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r"
private const val EXPORTED = "download"

interface Api {

    @GET("u/0/uc")
    suspend fun loadJobData(
        @Query("id") id: String = ID,
        @Query("export") export: String = EXPORTED
    ): Response<JobResponse>
}