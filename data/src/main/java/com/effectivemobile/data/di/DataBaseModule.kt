package com.effectivemobile.data.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


private const val DATA_BASE_NAME = "app_data_base"

val dataBaseModule = module {

//    single<Dao> {
//        val appDataBase: AppDataBase =
//            Room.databaseBuilder(androidContext(), AppDataBase::class.java, DATA_BASE_NAME)
//                .build()
//        appDataBase.getDao()
//    }
}