package com.example.aiassistant.ui

import com.example.aiassistant.data.ChatMessage

/**
 * Sealed class representing the chat screen UI state.
 *
 * AI Prompt: "Create a ChatUiState sealed class with:
 * - Idle: initial state
 * - Loading: waiting for AI response
 * - Success(messages): has a list of ChatMessage
 * - Error(message): error string"
 */
sealed class ChatUiState {
    data object Idle : ChatUiState()
    data object Loading : ChatUiState()
    data class Success(val messages: List<ChatMessage>) : ChatUiState()
    data class Error(val message: String) : ChatUiState()
}
