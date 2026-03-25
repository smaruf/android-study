# 03 — Advanced Level: AI Assistant App

This project demonstrates an **expert-level** Android app using **Gemini AI API**, **ML Kit** for on-device intelligence, and a polished chat UI.

## What You'll Learn
- Integrating Google Gemini API into Android apps
- On-device text recognition with ML Kit
- Clean Architecture (Use Cases / Interactors)
- Sealed class UI state management
- Repository pattern with remote API
- Jetpack Compose animated chat UI

## App Features
- Chat with Gemini AI model
- Message history with typing indicator
- ML Kit text recognition from camera
- Send recognized text as a prompt to Gemini
- Error handling and retry logic

## How to Open
1. In Android Studio: **File → Open → `03-advanced/AIAssistantApp`**
2. Add your Gemini API key to `local.properties`:
   ```
   GEMINI_API_KEY=your_key_here
   ```
3. Get a free API key at [aistudio.google.com](https://aistudio.google.com)
4. Wait for Gradle sync, then Run

## AI Prompt Used (Panda / Gemini)
> "Create an Android chat app that:
> - Sends user messages to Google Gemini API using the generative-ai SDK
> - Displays responses in a chat bubble UI with Jetpack Compose
> - Shows a typing indicator while waiting for a response
> - Uses sealed class ChatState (Loading, Success, Error) for UI state
> - Stores chat history in a ViewModel using a mutableStateListOf"

## Architecture
```
UI (ChatScreen composable)
    ↕ StateFlow<ChatUiState>
ChatViewModel
    ↕
GeminiRepository (calls Gemini SDK)
    ↕
Google Generative AI SDK
```

## Key Files
```
app/src/main/java/com/example/aiassistant/
  ├── data/
  │   ├── ChatMessage.kt        ← Message data class
  │   └── GeminiRepository.kt  ← Wraps Gemini SDK
  ├── ui/
  │   ├── ChatViewModel.kt      ← State + business logic
  │   ├── ChatScreen.kt         ← Compose chat UI
  │   └── ChatUiState.kt        ← Sealed class for UI states
  └── MainActivity.kt
```
