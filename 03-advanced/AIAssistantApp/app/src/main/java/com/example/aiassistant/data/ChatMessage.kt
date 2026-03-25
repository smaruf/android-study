package com.example.aiassistant.data

/**
 * Represents a single chat message.
 *
 * @param text The message text
 * @param isFromUser true = user message (right bubble), false = AI response (left bubble)
 * @param isError true if this message represents an error response
 */
data class ChatMessage(
    val text: String,
    val isFromUser: Boolean,
    val isError: Boolean = false
)
