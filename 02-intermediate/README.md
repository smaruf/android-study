# 02 — Intermediate Level: Notes App

This project demonstrates a real-world Android app using **MVVM architecture**, **Room database**, **Hilt** dependency injection, and **Kotlin Coroutines**.

## What You'll Learn
- MVVM (Model–View–ViewModel) architecture pattern
- Room database for local persistence
- Hilt for dependency injection
- Kotlin Coroutines + Flow for async data
- Jetpack Compose lists and navigation
- StateFlow for reactive UI

## App Features
- Create, read, update, and delete notes
- Notes are persisted locally with Room
- Reactive UI updates via StateFlow
- Clean architecture with Repository pattern

## How to Open
1. In Android Studio: **File → Open → `02-intermediate/NotesApp`**
2. Wait for Gradle sync
3. Click ▶ Run

## AI Prompt Used (Panda / Gemini)
> "Generate an Android MVVM Notes app with:
> - Note data class with id, title, content, createdAt
> - Room DAO with insert, update, delete, getAllNotes (Flow)
> - NoteRepository wrapping the DAO
> - NoteViewModel with Hilt injection and StateFlow<List<Note>>
> - Compose UI with a LazyColumn list and add/delete functionality"

## Architecture
```
UI Layer (Compose)
    ↕ observes StateFlow
ViewModel (NoteViewModel)
    ↕ calls
Repository (NoteRepository)
    ↕ uses
Room Database (NoteDao → NoteDatabase)
```

## Key Files
```
app/src/main/java/com/example/notesapp/
  ├── data/
  │   ├── Note.kt              ← Room entity + data class
  │   ├── NoteDao.kt           ← Database access object
  │   ├── NoteDatabase.kt      ← Room database
  │   └── NoteRepository.kt   ← Repository abstraction
  ├── ui/
  │   ├── NoteViewModel.kt     ← ViewModel with Hilt + StateFlow
  │   ├── NotesScreen.kt       ← Compose list screen
  │   └── AddNoteScreen.kt     ← Compose add/edit screen
  └── MainActivity.kt          ← NavHost entry point
```
