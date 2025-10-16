# Toc-Tac-Toe (Kotlin, Jetpack Compose, Clean Architecture)

Small Tic-Tac-Toe Android app written with Kotlin & Jetpack Compose. 
The project uses a Clean Architecture style layering (data/domain/presentation/ui) and is developed with TDD approach.

## Features

- Dynamic Tic-Tac-Toe Board (min 3X3)
- Two-player (X / O)
- Win/draw detection
- Reset / Play again
- Unit tests (repository + domain + ViewModel)
- Compose UI

# Versions

- Java 11
- Kotlin 2.0
- Compile SDK 36
- Min SDK 29
- Target SDK 36
- Android Gradle Plugin (AGP) 8.13.0

## How to run

1. Open in Android Studio (Narwhal 3 | 2025.1.3)
2. Run the `app` module, or use Gradle:
   - `./gradlew assembleDebug`
   - `./gradlew test` (Unit Tests)

## [Tic-Tac-Toe App Architecture Diagram]

![Game Screenshot](https://raw.githubusercontent.com/2025-DEV2-010/Tic-Tac-Toe/main/assets/architecture-tic-tac-toe.jpeg)

![GameSnap - Sample-1](https://raw.githubusercontent.com/2025-DEV2-010/Tic-Tac-Toe/main/assets/sample1.png)

![GameSnap - Sample-2](https://raw.githubusercontent.com/2025-DEV2-010/Tic-Tac-Toe/main/assets/sample2.png)
