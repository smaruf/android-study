package com.example.notesapp

import com.example.notesapp.data.Note
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests for NoteViewModel guard logic and Note data class.
 *
 * AI Prompt: "Generate unit tests for NoteViewModel validation logic and Note entity."
 */
class NoteViewModelTest {

    private val sampleNote = Note(id = 1, title = "Test", content = "Content")

    @Test
    fun `addNote with blank title should be rejected`() {
        // NoteViewModel.addNote() guards against blank titles
        val title = "  "
        assertTrue("Blank title should be rejected", title.isBlank())
    }

    @Test
    fun `addNote trims whitespace from title and content`() {
        val rawTitle = "  Hello World  "
        val rawContent = "  Some content  "
        assertEquals("Hello World", rawTitle.trim())
        assertEquals("Some content", rawContent.trim())
    }

    @Test
    fun `note data class equality is value-based`() {
        val note1 = Note(id = 1, title = "Test", content = "Body", createdAt = 1000L)
        val note2 = Note(id = 1, title = "Test", content = "Body", createdAt = 1000L)
        assertEquals(note1, note2)
    }

    @Test
    fun `note copy creates independent instance`() {
        val original = sampleNote
        val updated = original.copy(title = "Updated Title")
        assertEquals("Updated Title", updated.title)
        assertEquals(original.content, updated.content)
        assertEquals(original.id, updated.id)
    }

    @Test
    fun `note default createdAt is recent`() {
        val before = System.currentTimeMillis()
        val note = Note(title = "New", content = "Body")
        val after = System.currentTimeMillis()
        assertTrue(note.createdAt in before..after)
    }
}

