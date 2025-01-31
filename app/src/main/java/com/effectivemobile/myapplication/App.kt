package com.effectivemobile.myapplication

import android.app.Application
import com.effectivemobile.data.di.dataBaseModule
import com.effectivemobile.data.di.networkModule
import com.effectivemobile.myapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, dataBaseModule, networkModule)
        }
    }
}