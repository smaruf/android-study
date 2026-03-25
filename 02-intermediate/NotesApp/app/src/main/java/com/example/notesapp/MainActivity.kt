package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.ui.AddNoteScreen
import com.example.notesapp.ui.NotesScreen
import com.example.notesapp.ui.theme.NotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity. Sets up navigation between the notes list and add note screens.
 *
 * AI Prompt: "Create a MainActivity with Compose navigation hosting two screens:
 * 'notes_list' and 'add_note'."
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "notes_list") {
                    composable("notes_list") {
                        NotesScreen(
                            onAddNote = { navController.navigate("add_note") }
                        )
                    }
                    composable("add_note") {
                        AddNoteScreen(
                            onNoteSaved = { navController.popBackStack() },
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
