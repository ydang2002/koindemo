package com.example.koindemo.domain.repository

import com.example.koindemo.models.CountriesItem


interface MyRepository {
    suspend fun fetchCountries(): List<CountriesItem>
}