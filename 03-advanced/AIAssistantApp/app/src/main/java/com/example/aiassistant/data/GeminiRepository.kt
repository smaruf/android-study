package com.example.aiassistant.data

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that wraps the Google Generative AI (Gemini) SDK.
 *
 * AI Prompt: "Create a GeminiRepository that takes a GenerativeModel via
 * Hilt injection and provides a suspend function sendMessage(prompt: String): String
 * that calls generateContent and returns the response text."
 */
@Singleton
class GeminiRepository @Inject constructor(
    private val generativeModel: GenerativeModel
) {
    /**
     * Sends a prompt to Gemini and returns the generated text response.
     * Throws an exception if the request fails.
     */
    suspend fun sendMessage(prompt: String): String = withContext(Dispatchers.IO) {
        val response = generativeModel.generateContent(
            content { text(prompt) }
        )
        response.text ?: throw IllegalStateException("Empty response from Gemini")
    }
}
