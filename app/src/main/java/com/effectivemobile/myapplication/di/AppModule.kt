package com.effectivemobile.myapplication.di

import com.effectivemobile.data.local.repositoryImpl.DataBaseRepositoryImpl
import com.effectivemobile.data.remote.repositoryImpl.ApiRepositoryImpl
import com.effectivemobile.domain.repositories.ApiRepository
import com.effectivemobile.domain.repositories.DataBaseRepository
import com.effectivemobile.domain.useCases.GetVacanciesFromDbUseCase
import com.effectivemobile.domain.useCases.LoadJobDataUseCase
import com.effectivemobile.domain.useCases.SetFavoriteUseCase
import com.effectivemobile.feature_favorite.FavoriteViewModel

import com.effectivemobile.feature_main.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    factory<ApiRepository> { ApiRepositoryImpl(get()) }

    factory<DataBaseRepository> { DataBaseRepositoryImpl(get()) }

    factory<LoadJobDataUseCase> {
        LoadJobDataUseCase(
            repository = get(),
            dbRepository = get()
        )
    }
    factory<GetVacanciesFromDbUseCase> {
        GetVacanciesFromDbUseCase(dbRepository = get())
    }
    factory<SetFavoriteUseCase> {
        SetFavoriteUseCase(dbRepository = get())
    }

    viewModelOf(::MainViewModel)
    viewModelOf(::FavoriteViewModel)
}