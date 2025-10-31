package com.example.koindemo.di

import com.example.koindemo.data.repository.MyRepositoryImpl
import com.example.koindemo.domain.repository.MyRepository
import com.example.koindemo.presentation.main.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

// là DSL của Koin (Domain-Specific Language) để định nghĩa cách tạo (cung cấp) các dependency.
val repositoryModule = module {

    // MyRepositoryImpl phụ thuộc vào ApiService -> Koin tự động gọi get() để inject ApiService vào MyRepositoryImpl (constructor)
    single<MyRepository> { MyRepositoryImpl(get()) }

    // MainViewModel mỗi khi Activity hoặc Fragment yêu cầu (và gắn nó vào lifecycle tương ứng)
    // Koin sẽ tìm MyRepository trong container (đăng ký ở trên) và inject vào constructor của MainViewModel
    viewModel { MainViewModel(get()) }
}