# Prototype reflection: where AI stopped

## What AI did well

- Rapid scaffolding of Jetpack Compose UI components (Cards, TopAppBar, Lists).
- Generating mock data structures and sample instances for UI testing.
- Setting up navigation boilerplate between prototype screens.

## What broke when you stressed it

- **Rotate the device:** Form fields and mock scanned data reset because state was stored using basic `remember { mutableStateOf() }` without `rememberSaveable` or a `ViewModel`.
- **Kill and reopen the app:** All newly added medication entries vanished because data was only held in memory.

## What is missing for production

| Gap in the prototype | Lab that fixes it |
|---|---|
| No separation of UI and logic; state resets on rotation | Lab 4 (architecture & ViewModel) |
| No remote endpoint integration for encrypted backup | Lab 5 (networking & Retrofit) |
| Nothing saved across app restarts | Lab 6 (persistence & Room DB) |
| No background sync or offline queue | Lab 7 (offline-first & WorkManager) |
| Manual dependency instantiation | Lab 8 (dependency injection & Hilt) |
| No automated unit or UI tests | Lab 9 (testing & CI gate) |
| Mock OCR scanner instead of actual ML Kit inference | Lab 10 (integrated ML concept) |

## One sentence

AI rapidly generated the visual shell and UI layout, but building a production application requires explicit engineering decisions around state preservation, offline persistence, network synchronization, and security architecture that AI cannot provide without guided step by step instructions.
