package com.example.koindemo.data.repository

import com.example.koindemo.data.remote.ApiService
import com.example.koindemo.domain.repository.MyRepository
import com.mohsenmashkour.koindiyten.models.CountriesItem

class MyRepositoryImpl(
    private val apiService: ApiService
) : MyRepository {
    override suspend fun fetchCountries(): List<CountriesItem> {
        return apiService.getCountries()
    }
}