package com.example.motorcycleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.motorcycleapp.component.BottomNavigationBar
import com.example.motorcycleapp.screen.FavoritesScreen
import com.example.motorcycleapp.screen.MotorcycleDetailScreen
import com.example.motorcycleapp.screen.MotorcycleSearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotorcycleApp()
        }
    }
}

@Composable
fun MotorcycleApp() {
    val navController = rememberNavController()
    var favorites by remember { mutableStateOf(setOf<String>()) }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController, startDestination = "home") {
                composable("home") { MotorcycleSearchScreen(navController, favorites) }
                composable("favorites") { FavoritesScreen(favorites) }
                composable("details/{motorcycle}") { backStackEntry ->
                    val motorcycle = backStackEntry.arguments?.getString("motorcycle")
                    MotorcycleDetailScreen(motorcycle, favorites) { updatedFavorites ->
                        favorites = updatedFavorites
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MotorcycleApp()
}