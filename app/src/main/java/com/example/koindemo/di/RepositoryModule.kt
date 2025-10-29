package com.example.koindemo.di

import com.example.koindemo.data.repository.MyRepositoryImpl
import com.example.koindemo.domain.repository.MyRepository
import com.example.koindemo.presentation.main.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {

    // Repository binding
    single<MyRepository> { MyRepositoryImpl(get()) }

    // ViewModel
    viewModel { MainViewModel(get()) }
}