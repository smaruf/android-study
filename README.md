# Android Study with AI (Panda)

> Practice building Android apps using Android Studio with AI assistance — from basic to production-ready deployments.

---

## 🚀 Overview

This repository is a hands-on learning path for Android development, leveraging **AI coding assistants** (especially **Panda AI** / Gemini in Android Studio) to accelerate learning and build real-world apps.

| Level | Folder | Description |
|-------|--------|-------------|
| 🟢 Basic | [`01-basics/`](01-basics/) | Hello World, UI layouts, navigation |
| 🟡 Intermediate | [`02-intermediate/`](02-intermediate/) | Room DB, MVVM, Retrofit, Notes App |
| 🔴 Advanced | [`03-advanced/`](03-advanced/) | ML Kit, Gemini API, AI features |
| 🏭 Production | [`04-production/`](04-production/) | CI/CD, signing, Play Store deployment |

---

## 🤖 AI Tools Used

### Panda AI (Primary)
[Panda AI](https://panda.ai) is an intelligent coding assistant integrated into your workflow. In Android development, use it to:
- Generate boilerplate code (Activities, ViewModels, Repositories)
- Suggest Kotlin idioms and Jetpack Compose patterns
- Review code for bugs and performance issues
- Write unit and instrumentation tests

### Gemini in Android Studio
Google's Gemini AI is built directly into Android Studio (2024+):
- **Code completion** — context-aware multi-line suggestions
- **Chat assistant** — ask questions about your code
- **Generate tests** — AI-generated unit tests from your code
- **Explain code** — understand unfamiliar APIs instantly

See the full setup guide: [`docs/ai-tools-setup.md`](docs/ai-tools-setup.md)

---

## 📋 Prerequisites

- **Android Studio** Hedgehog (2023.1.1) or newer
- **JDK 17+**
- **Android SDK** API 24+ (minSdk), API 34 (targetSdk)
- **Git**
- AI assistant plugin (Panda AI or Gemini)

---

## 🗺️ Learning Path

```
01-basics/
  └── HelloWorldApp/         ← Your first Kotlin + Compose app

02-intermediate/
  └── NotesApp/              ← MVVM + Room + Hilt + Coroutines

03-advanced/
  └── AIAssistantApp/        ← On-device ML Kit + Gemini API chat

04-production/
  ├── ci-cd/                 ← GitHub Actions workflow
  └── deployment-guide.md   ← Play Store release checklist
```

---

## 🛠️ Getting Started

```bash
# 1. Clone the repo
git clone https://github.com/smaruf/android-study.git
cd android-study

# 2. Open any project in Android Studio
#    File > Open > select the project folder (e.g., 01-basics/HelloWorldApp)

# 3. Let Gradle sync complete, then Run on emulator or device
```

---

## 📚 Documentation

| Doc | Description |
|-----|-------------|
| [AI Tools Setup](docs/ai-tools-setup.md) | Configure Panda AI & Gemini in Android Studio |
| [Android Studio Setup](docs/android-studio-setup.md) | Install SDK, emulator, and recommended plugins |
| [Production Deployment](docs/production-deployment.md) | Sign APK/AAB and publish to Play Store |

---

## 🤝 Contributing

1. Fork the repo and create a feature branch
2. Use AI (Panda / Gemini) to help write your code
3. Ensure tests pass and code is clean
4. Open a pull request describing what you built

---

## 📄 License

MIT License — see [LICENSE](LICENSE) for details.
