package com.example.motorcycleapp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.motorcycleapp.R

@Composable
fun FavoritesScreen(favorites: Set<String>) {
    if (favorites.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Избранное пусто", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    } else {
        LazyColumn {
            items(favorites.toList()) { favorite ->
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = R.drawable.yamaha_r1,
                        contentDescription = favorite,
                        modifier = Modifier.size(50.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(favorite, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }
        }
    }
}