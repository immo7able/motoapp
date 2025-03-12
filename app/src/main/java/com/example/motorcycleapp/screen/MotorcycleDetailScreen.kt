package com.example.motorcycleapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.motorcycleapp.R


@Composable
fun MotorcycleDetailScreen(name: String?, favorites: Set<String>, onFavoriteChange: (Set<String>) -> Unit) {
    var isFavorite by remember { mutableStateOf(name in favorites) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        name?.let {
            Text(it, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = R.drawable.yamaha_r1,
                contentDescription = name,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("A high-performance sports motorcycle with advanced technology.", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                isFavorite = !isFavorite
                onFavoriteChange(if (isFavorite) favorites + it else favorites - it)
            }) {
                Text(if (isFavorite) "Remove from Favorites" else "Add to Favorites")
            }
        }
    }
}