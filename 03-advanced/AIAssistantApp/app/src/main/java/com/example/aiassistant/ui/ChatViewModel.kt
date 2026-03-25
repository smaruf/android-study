package com.example.aiassistant.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aiassistant.data.ChatMessage
import com.example.aiassistant.data.GeminiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the chat screen.
 *
 * AI Prompt: "Create ChatViewModel with HiltViewModel, a StateFlow<ChatUiState>,
 * and a sendMessage(prompt) function that adds a user message, sets Loading state,
 * calls GeminiRepository.sendMessage, then adds the AI response."
 */
@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: GeminiRepository
) : ViewModel() {

    private val _messages = mutableStateListOf<ChatMessage>()
    val messages: List<ChatMessage> get() = _messages

    private val _uiState = MutableStateFlow<ChatUiState>(ChatUiState.Idle)
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    fun sendMessage(prompt: String) {
        if (prompt.isBlank()) return

        // Add user message
        _messages.add(ChatMessage(text = prompt.trim(), isFromUser = true))
        _uiState.value = ChatUiState.Loading

        viewModelScope.launch {
            try {
                val response = repository.sendMessage(prompt.trim())
                _messages.add(ChatMessage(text = response, isFromUser = false))
                _uiState.value = ChatUiState.Success(_messages.toList())
            } catch (e: Exception) {
                val errorMsg = "Error: ${e.localizedMessage ?: "Something went wrong"}"
                _messages.add(ChatMessage(text = errorMsg, isFromUser = false, isError = true))
                _uiState.value = ChatUiState.Error(errorMsg)
            }
        }
    }
}
