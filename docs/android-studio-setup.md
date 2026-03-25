# Android Studio Setup Guide

This guide walks through installing and configuring Android Studio for this project.

---

## 1. Install Android Studio

1. Download **Android Studio** from [developer.android.com/studio](https://developer.android.com/studio)
2. Run the installer and follow the setup wizard
3. Install the default SDK components when prompted (API 34 recommended)

### Recommended Version
**Android Studio Hedgehog (2023.1.1)** or newer for Gemini AI support.

---

## 2. SDK Configuration

Open **File → Settings → Android SDK** (macOS: **Preferences → Android SDK**).

### SDK Platforms
Install:
- ✅ Android 14 (API 34) — latest stable
- ✅ Android 13 (API 33)
- ✅ Android 12 (API 32)

### SDK Tools
Install:
- ✅ Android SDK Build-Tools (latest)
- ✅ Android Emulator
- ✅ Android SDK Platform-Tools
- ✅ Google Play Services

---

## 3. Create a Virtual Device (Emulator)

1. Go to **Device Manager** (right toolbar or **View → Tool Windows → Device Manager**)
2. Click **+ Create Virtual Device**
3. Select **Pixel 7** (or any phone profile) → Next
4. Select **API 34 (UpsideDownCake)** system image → Download if needed → Next
5. Review settings → **Finish**

---

## 4. Recommended Plugins

Install these plugins via **File → Settings → Plugins**:

| Plugin | Purpose |
|--------|---------|
| **Panda AI** | AI code assistant |
| **Rainbow Brackets** | Color-coded brackets |
| **GitToolBox** | Inline git annotations |
| **Kotlin** | Already bundled, keep updated |

---

## 5. Gradle Configuration

All projects in this repo use:
- **Gradle 8.x** with Kotlin DSL (`build.gradle.kts`)
- **JDK 17** (set in File → Project Structure → SDK Location)
- **Android Gradle Plugin 8.x**

To change the JDK:
1. **File → Project Structure → SDK Location**
2. Set **Gradle JDK** to JDK 17

---

## 6. Environment Variables

Add to your shell profile (`~/.bashrc`, `~/.zshrc`, etc.):

```bash
export ANDROID_HOME=$HOME/Android/Sdk          # Linux
export ANDROID_HOME=$HOME/Library/Android/sdk  # macOS

export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/platform-tools
```

---

## 7. Verify Installation

```bash
# Check ADB is working
adb version

# Check available emulators
emulator -list-avds

# Check Gradle (from inside a project directory)
./gradlew --version
```
