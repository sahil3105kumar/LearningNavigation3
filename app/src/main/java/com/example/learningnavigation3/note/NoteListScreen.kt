package com.example.learningnavigation3.note

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NoteListScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn (modifier = modifier.
    fillMaxSize()
    ) {
        items(100){
            Text("Note $it")
        }
    }
}