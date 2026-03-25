package com.example.aiassistant

import com.example.aiassistant.data.ChatMessage
import com.example.aiassistant.ui.ChatUiState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests for chat-related data classes and UI state.
 *
 * AI Prompt: "Generate unit tests for ChatMessage and ChatUiState."
 */
class ChatTest {

    @Test
    fun `user message has isFromUser true`() {
        val msg = ChatMessage(text = "Hello", isFromUser = true)
        assertTrue(msg.isFromUser)
        assertFalse(msg.isError)
    }

    @Test
    fun `ai message has isFromUser false`() {
        val msg = ChatMessage(text = "Hi there!", isFromUser = false)
        assertFalse(msg.isFromUser)
    }

    @Test
    fun `error message has isError true`() {
        val msg = ChatMessage(text = "Error occurred", isFromUser = false, isError = true)
        assertTrue(msg.isError)
    }

    @Test
    fun `ChatUiState Loading is correct type`() {
        val state: ChatUiState = ChatUiState.Loading
        assertTrue(state is ChatUiState.Loading)
    }

    @Test
    fun `ChatUiState Success contains messages`() {
        val messages = listOf(ChatMessage("Hi", isFromUser = true))
        val state = ChatUiState.Success(messages)
        assertEquals(1, state.messages.size)
        assertEquals("Hi", state.messages[0].text)
    }

    @Test
    fun `ChatUiState Error contains message`() {
        val state = ChatUiState.Error("Network error")
        assertEquals("Network error", state.message)
    }
}
