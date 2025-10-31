package com.example.koindemo.di

import com.example.koindemo.data.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Định nghĩa dependency
// Sau khi start koin nếu nơi nào cần apiServices koin sẽ tạo ra apiServices bằng networkModule
val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.apicountries.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}