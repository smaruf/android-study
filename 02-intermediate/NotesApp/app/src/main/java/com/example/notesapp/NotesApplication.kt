package com.example.notesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class annotated with @HiltAndroidApp to enable Hilt injection.
 *
 * AI Prompt: "Create the Application class for a Hilt-enabled Android app."
 */
@HiltAndroidApp
class NotesApplication : Application()
