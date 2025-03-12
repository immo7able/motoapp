package com.example.motorcycleapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.motorcycleapp.R
import com.example.motorcycleapp.component.MotorcycleItem
import com.example.motorcycleapp.component.SearchBar

@Composable
fun MotorcycleSearchScreen(navController: NavHostController, favorites: Set<String>) {
    var searchQuery by remember { mutableStateOf("") }
    val motorcycles = listOf(
        "Yamaha R1" to R.drawable.yamaha_r1,
        "Kawasaki Ninja" to R.drawable.kawasaki_ninja,
        "Ducati Panigale" to R.drawable.ducati_panigale
    )
    val filteredMotorcycles = motorcycles.filter { it.first.contains(searchQuery, ignoreCase = true) }

    Column {
        SearchBar(searchQuery) { searchQuery = it }
        LazyColumn {
            items(filteredMotorcycles) { (name, image) ->
                MotorcycleItem(name, image, favorites.contains(name)) {
                    navController.navigate("details/$name")
                }
            }
        }
    }
}