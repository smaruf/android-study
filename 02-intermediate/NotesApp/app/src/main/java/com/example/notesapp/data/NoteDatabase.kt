package com.example.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room database for the Notes app.
 *
 * AI Prompt: "Create a Room database class with the Note entity, version 1,
 * and a NoteDao accessor."
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
