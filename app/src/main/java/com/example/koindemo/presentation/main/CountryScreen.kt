package com.example.koindemo.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.koindemo.models.CountriesItem

@Composable
fun CountryScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    val countries by viewModel.countries.collectAsState()

    LazyColumn(modifier = modifier) {
        items(countries) { country ->
            CountryItem(country)
        }
    }
}

@Composable
fun CountryItem(country: CountriesItem) {
    Card(Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(4.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            AsyncImage(
                model = country.flags.png,
                contentDescription = "${country.name} Flag",
                modifier = Modifier.size(80.dp)
            )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = country.name, fontWeight = FontWeight.Bold)
                Text(text = "Capital: ${country.capital}")
                Text(text = "Population: ${country.population}")
            }
        }
    }
}