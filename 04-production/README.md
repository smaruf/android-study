# 04 — Production Level: CI/CD & Deployment

This folder contains production-ready configurations for building, testing, and deploying Android apps.

## Contents

| File | Purpose |
|------|---------|
| [`ci-cd/`](ci-cd/) | GitHub Actions workflow for automated builds |
| [`deployment-guide.md`](../docs/production-deployment.md) | Play Store release checklist |

## GitHub Actions Workflow

The workflow in `ci-cd/.github/workflows/android.yml` does:

1. **On every pull request & push to main:**
   - Runs unit tests
   - Builds a debug APK

2. **On a version tag (e.g., `v1.0.0`):**
   - Runs unit tests
   - Builds a signed release AAB
   - Uploads the AAB as a build artifact

## How to Use

1. Copy the `.github/` folder to your project root
2. Add these secrets to your GitHub repository (**Settings → Secrets → Actions**):

   | Secret | Description |
   |--------|-------------|
   | `KEYSTORE_BASE64` | Your keystore file encoded in base64 |
   | `KEYSTORE_PASSWORD` | Keystore password |
   | `KEY_ALIAS` | Key alias |
   | `KEY_PASSWORD` | Key password |

3. To create the base64-encoded keystore:
   ```bash
   base64 -i release-keystore.jks -o keystore-base64.txt
   ```
   Copy the content of `keystore-base64.txt` as the `KEYSTORE_BASE64` secret.

4. Push a tag to trigger a release build:
   ```bash
   git tag v1.0.0
   git push origin v1.0.0
   ```
