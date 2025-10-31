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
            // Truyền context của app cho Koin
            androidContext(this@MyApplication)
            // đăng ký các module chứa cách tạo dependency như network, repository.
            modules(
                networkModule,
                repositoryModule,
//                scopeModule
            )
        }
    }
}