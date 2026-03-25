# AI Tools Setup for Android Development

This guide covers how to set up and use **Panda AI** and **Gemini in Android Studio** for AI-assisted Android development.

---

## 1. Panda AI

### What is Panda AI?
Panda AI is an intelligent coding assistant that integrates with your IDE to help you write better code faster. It understands context, suggests completions, generates boilerplate, and answers coding questions.

### Installation
1. Open Android Studio
2. Go to **File → Settings → Plugins** (macOS: **Android Studio → Preferences → Plugins**)
3. Search for **"Panda AI"** in the Marketplace
4. Click **Install** and restart Android Studio

### Key Features for Android Development

| Feature | How to Use |
|---------|-----------|
| Code completion | Start typing — Panda suggests the next lines |
| Generate boilerplate | Type a comment like `// ViewModel for user list` and trigger completion |
| Refactor code | Select code → right-click → **Panda: Refactor** |
| Generate tests | Right-click a function → **Panda: Generate Tests** |
| Explain code | Select code → right-click → **Panda: Explain** |

### Effective Prompting for Android
When asking Panda to generate code, be specific:

```
// Bad:  "Create an activity"
// Good: "Create a Jetpack Compose LoginScreen with email and password TextFields,
//        a login Button, input validation, and ViewModel integration"
```

---

## 2. Gemini in Android Studio

### Enabling Gemini
1. Update Android Studio to **Hedgehog (2023.1.1)** or newer
2. Go to **View → Tool Windows → Gemini** (or click the ✨ Gemini icon in the toolbar)
3. Sign in with your Google account
4. Accept the terms and start chatting

### Chat Assistant
Use the Gemini panel to ask questions about your project:

```
"How do I implement pagination with Paging 3 library in this RecyclerView?"
"What's the best way to handle network errors in this Repository class?"
"Can you explain what this Coroutine scope does?"
```

### Inline Code Suggestions
- Gemini provides multi-line code completion as you type
- Press `Tab` to accept a suggestion
- Press `Alt+]` / `Option+]` to cycle through suggestions

### Generate Unit Tests
1. Open any Kotlin class or function
2. Right-click → **Gemini → Generate Unit Tests**
3. Review and accept the generated tests

---

## 3. Workflow: AI-Assisted Android Development

Here is the recommended workflow when building features with AI assistance:

```
1. DESIGN  → Describe the feature in a comment or to the AI chat
2. GENERATE → Let Panda/Gemini generate the initial boilerplate
3. REVIEW  → Read through the generated code carefully
4. REFINE  → Adjust prompts or edit code manually as needed
5. TEST    → Ask AI to generate tests, then run them
6. COMMIT  → Commit working, tested code
```

### Example: Building a Notes Feature with AI

**Step 1 — Describe your intent:**
```kotlin
// Create a NoteViewModel that:
// - Uses Hilt for dependency injection
// - Has a StateFlow of List<Note>
// - Supports add, update, and delete operations
// - Uses NoteRepository backed by Room
```

**Step 2 — Let AI generate the code, then review it**

**Step 3 — Generate tests:**
```
Ask Gemini: "Generate unit tests for this NoteViewModel using MockK and Coroutines test library"
```

---

## 4. Tips and Best Practices

- **Always review AI-generated code** before running it — AI can make mistakes
- **Use descriptive variable/function names** — AI understands context better
- **Break complex features into small prompts** — one class or function at a time
- **Ask AI to explain unfamiliar code** — great for learning new APIs
- **Version-control frequently** — so you can revert if generated code has issues
- **Combine AI with official docs** — [developer.android.com](https://developer.android.com) is your source of truth

---

## 5. Keyboard Shortcuts

| Action | Windows/Linux | macOS |
|--------|--------------|-------|
| Accept AI suggestion | `Tab` | `Tab` |
| Next AI suggestion | `Alt+]` | `Option+]` |
| Prev AI suggestion | `Alt+[` | `Option+[` |
| Open Gemini chat | `Alt+G` | `Option+G` |
| Trigger completion | `Ctrl+Space` | `Cmd+Space` |
