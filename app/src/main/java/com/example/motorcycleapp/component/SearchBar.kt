package com.example.motorcycleapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        BasicTextField(
            value = query,
            onValueChange = onQueryChange,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions.Default,
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontWeight = FontWeight.Bold, color = Color.Black),
            decorationBox = { innerTextField ->
                if (query.isEmpty()) {
                    Text("Search motorcycles...", color = Color.Gray)
                }
                innerTextField()
            }
        )
    }
}