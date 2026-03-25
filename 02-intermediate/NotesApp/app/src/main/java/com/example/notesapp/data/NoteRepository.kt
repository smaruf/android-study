package com.example.notesapp.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that abstracts access to the NoteDao.
 * Injected via Hilt.
 *
 * AI Prompt: "Create a NoteRepository with @Singleton Hilt injection that wraps
 * NoteDao and exposes getAllNotes Flow, insertNote, updateNote, and deleteNote."
 */
@Singleton
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}
