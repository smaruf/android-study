# Production Deployment Guide

This guide covers signing, building, and publishing your Android app to the Google Play Store.

---

## 1. App Signing

Every Android app must be signed before release. You'll create a **keystore** file that holds your signing keys.

### Generate a Keystore
```bash
keytool -genkey -v \
  -keystore release-keystore.jks \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000 \
  -alias my-app-key
```

> ⚠️ **Keep your keystore file and passwords secure and backed up.** If you lose them, you cannot update your app on Play Store.

### Configure Signing in build.gradle.kts

```kotlin
// app/build.gradle.kts
android {
    signingConfigs {
        create("release") {
            storeFile = file(System.getenv("KEYSTORE_PATH") ?: "release-keystore.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD") ?: ""
            keyAlias = System.getenv("KEY_ALIAS") ?: "my-app-key"
            keyPassword = System.getenv("KEY_PASSWORD") ?: ""
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
}
```

---

## 2. Build a Release AAB (Android App Bundle)

```bash
./gradlew bundleRelease
```

Output: `app/build/outputs/bundle/release/app-release.aab`

The **AAB format** is required by Play Store (since August 2021). It lets Google optimize delivery by device.

---

## 3. Build a Release APK (optional, for sideloading)

```bash
./gradlew assembleRelease
```

Output: `app/build/outputs/apk/release/app-release.apk`

---

## 4. Play Store Submission Checklist

Before submitting, verify:

- [ ] `versionCode` incremented in `app/build.gradle.kts`
- [ ] `versionName` updated (e.g., `"1.0.1"`)
- [ ] App icon is a 512×512 PNG (no transparency)
- [ ] Screenshots prepared (phone, 7-inch tablet, 10-inch tablet)
- [ ] Feature graphic created (1024×500 PNG)
- [ ] Short description written (≤80 characters)
- [ ] Full description written (≤4000 characters)
- [ ] Privacy policy URL set (required for apps using personal data)
- [ ] Content rating questionnaire completed
- [ ] Target audience and content settings configured
- [ ] Release notes written for this version

---

## 5. Automated CI/CD Pipeline

See [`ci-cd/`](ci-cd/) for a ready-to-use GitHub Actions workflow that:
1. Runs unit tests on every push
2. Builds a signed AAB on tags (e.g., `v1.0.0`)
3. Uploads the AAB to Play Store internal testing track via Fastlane

---

## 6. Versioning Strategy

Use [Semantic Versioning](https://semver.org/) for `versionName`:

| Version | When to bump |
|---------|-------------|
| `1.0.0` | Initial release |
| `1.0.1` | Bug fixes only |
| `1.1.0` | New features, backward-compatible |
| `2.0.0` | Breaking changes / major redesign |

The `versionCode` must be a monotonically increasing integer — increment it with every release to Play Store.

---

## 7. ProGuard / R8 Configuration

Keep commonly needed rules in `proguard-rules.pro`:

```proguard
# Keep data classes used with Gson/Moshi/Kotlinx serialization
-keep class com.example.app.data.model.** { *; }

# Keep Retrofit interfaces
-keep interface com.example.app.data.remote.** { *; }

# Keep Room entities
-keep class com.example.app.data.local.entity.** { *; }
```

---

## 8. Firebase App Distribution (for QA/Beta)

For distributing beta builds to testers before Play Store:

```bash
# Install Firebase CLI
npm install -g firebase-tools
firebase login

# Distribute APK
firebase appdistribution:distribute app/build/outputs/apk/release/app-release.apk \
  --app YOUR_FIREBASE_APP_ID \
  --groups "qa-testers" \
  --release-notes "Beta build for QA testing"
```
