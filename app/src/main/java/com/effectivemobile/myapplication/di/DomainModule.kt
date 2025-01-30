package com.effectivemobile.myapplication.di

import com.effectivemobile.domain.controller.DataController

import org.koin.dsl.module

val domainModule = module {

    single<DataController> {
        DataController()
    }
}