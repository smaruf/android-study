package com.example.notesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room entity representing a note.
 *
 * AI Prompt: "Create a Room entity Note with id (auto-generated), title, content,
 * and createdAt (Long timestamp)."
 */
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis()
)
