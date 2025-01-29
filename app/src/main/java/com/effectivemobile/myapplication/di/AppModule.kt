package com.effectivemobile.myapplication.di

import com.effectivemobile.data.remote.repository.ApiRepositoryImpl
import com.effectivemobile.domain.repositories.ApiRepository
import com.effectivemobile.domain.useCases.LoadJobDataUseCase
import com.effectivemobile.feature_main.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    factory<ApiRepository> { ApiRepositoryImpl(get()) }

    factory<LoadJobDataUseCase> { LoadJobDataUseCase(repository = get(), dataController = get()) }

    viewModelOf(::MainViewModel)
}