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

## How to run

1. Open in Android Studio (Narwhal 3 | 2025.1.3)
2. Run the `app` module, or use Gradle:
   - `./gradlew assembleDebug`
   - `./gradlew test` (unit tests)

## Testing (TDD Flow)

- Unit tests: `./gradlew test`

## [Tic-Tac-Toe App Architecture Diagram](project-images/architecture-tic-tac-toe.jpeg)

## [GameSnap - Sample-1](project-images/sample1.png)

## [GameSnap - Sample-2](project-images/sample1.png)
