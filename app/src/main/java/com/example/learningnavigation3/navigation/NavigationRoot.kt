package com.example.learningnavigation3.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.*
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import kotlinx.serialization.Serializable
import com.example.learningnavigation3.note.NoteListScreen
import com.example.learningnavigation3.note.NoteDetailScreen

@Serializable
data object NoteListScreen: NavKey

@Serializable
data class NoteDetailsScreen(val id:Int): NavKey


@Composable
fun NavigationRoot(
    modifier: Modifier= Modifier
){

    val backStack= rememberNavBackStack(NoteListScreen)

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(), // make sure that we can scope viewmodels
            // to specific screen inside our nav display
            rememberSceneSetupNavEntryDecorator()
        ),

        entryProvider = { key ->

            when (key) {
                is NoteListScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        NoteListScreen()
                    }
                }

                is NoteDetailsScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        NoteDetailsScreen(id = key.id)
                    }
                }

                else -> throw IllegalArgumentException("Unknown screen type: $key")
            }


        }





    )
}
