package com.example.koindemo.domain.repository

import com.mohsenmashkour.koindiyten.models.CountriesItem

interface MyRepository {
    suspend fun fetchCountries(): List<CountriesItem>
}