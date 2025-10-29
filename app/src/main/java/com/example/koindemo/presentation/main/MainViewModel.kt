package com.example.koindemo.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koindemo.domain.repository.MyRepository
import com.mohsenmashkour.koindiyten.models.CountriesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MyRepository
) : ViewModel() {

    private val _countries = MutableStateFlow<List<CountriesItem>>(emptyList())
    val countries: StateFlow<List<CountriesItem>> = _countries

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                _countries.value = repository.fetchCountries()
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching countries: ${e.message}")
            }
        }
    }
}