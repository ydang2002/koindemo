package com.example.koindemo

import android.app.Application
import com.example.koindemo.di.networkModule
import com.example.koindemo.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                repositoryModule,
//                scopeModule
            )
        }
    }
}