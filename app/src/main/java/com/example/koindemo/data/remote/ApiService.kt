package com.example.koindemo.data.remote

import com.mohsenmashkour.koindiyten.models.CountriesItem
import retrofit2.http.GET

interface ApiService {
    @GET("countries")
    suspend fun getCountries(): List<CountriesItem>
}