package com.effectivemobile.data.di

import androidx.room.Room
import com.effectivemobile.data.local.JobSearchAppDB
import com.effectivemobile.data.local.dao.VacancyDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


private const val DATA_BASE_NAME = "app_data_base"

val dataBaseModule = module {

    single<VacancyDao> {
        val appDataBase: JobSearchAppDB =
            Room.databaseBuilder(androidContext(), JobSearchAppDB::class.java, DATA_BASE_NAME)
                .build()
        appDataBase.getVacancyDao()
    }
}