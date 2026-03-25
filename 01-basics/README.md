# 01 — Basic Level: Hello World App

This project demonstrates the fundamentals of Android development using **Kotlin** and **Jetpack Compose**.

## What You'll Learn
- Android project structure
- Jetpack Compose basics (UI with code, not XML)
- State management with `remember` and `mutableStateOf`
- Previewing composables in Android Studio

## App Features
- Displays a greeting message
- A counter button that increments on tap
- Clean, modern Material 3 UI

## How to Open
1. In Android Studio: **File → Open → `01-basics/HelloWorldApp`**
2. Wait for Gradle sync
3. Click ▶ Run

## AI Prompt Used (Panda / Gemini)
> "Create a Jetpack Compose Android app with a greeting text and a counter button
> that increments when tapped, using Material 3 theming."

## Key Files
```
app/src/main/java/com/example/helloworld/
  ├── MainActivity.kt          ← Entry point, sets Compose content
  ├── ui/theme/Theme.kt        ← Material 3 theme
  └── MainScreen.kt            ← Main composable screen
```
