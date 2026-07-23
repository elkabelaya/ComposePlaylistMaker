# ComposePlaylistMaker - AI Agent Guidelines

## Project Overview

Android app "Playlist Maker" — a music playlist management application built with Kotlin and Jetpack Compose.

**Package**: `com.elkabelaya.playlistmaker`

## Tech Stack

| Category | Technology |
|----------|------------|
| Language | Kotlin 2.2.0 |
| UI | Jetpack Compose (Material 3) |
| DI | Koin 4.0.2 |
| Navigation | Navigation Compose 2.9.7 |
| Database | Room 2.8.4 |
| Networking | Retrofit 3.0.0 + Gson |
| Image Loading | Coil 3.4.0, Glide 4.14.2 |
| Coroutines | kotlinx-coroutines 1.10.2 |
| Build | Gradle (Kotlin DSL), AGP 8.12.3, KSP 2.3.4 |

**Min SDK**: 33 | **Target SDK**: 35 | **Compile SDK**: 36

## Architecture

MVVM with Clean Architecture layers per feature:

```
feature/
├── data/          # Data sources, repositories implementation, DTOs
├── domain/        # Use cases, repository interfaces, domain models
├── presentation/  # Compose UI, ViewModels, screen state models
├── di/            # Koin modules (DataModule, DomainModule, PresentationModule, ViewModelModule)
```

### Feature Modules

- `common` — Shared utilities, base classes, DI
- `root` — Root activity, bottom navigation
- `search` — Track search (ITunes API)
- `player` — Audio playback with Media3
- `media` — Favorites and playlists tabs
- `playlist` — Playlist details and management
- `editplaylist` — Create/edit playlists
- `settings` — App settings (theme, language)

## Conventions

### ViewModel Pattern
- Abstract `*ViewModel` class defines contract
- `*ViewModelImpl` is the concrete implementation
- `*ViewModelMock` is used for Compose previews
- Base classes: `StateFullViewModel<T>` (LiveData) and `ComposeStateFullViewModel<T>` (StateFlow)

### DI Modules (per feature)
Each feature has 4 Koin modules in `di/`:
- `DataModule` — repositories, data sources
- `DomainModule` — use cases, interactors
- `PresentationModule` — UI-related bindings
- `ViewModelModule` — ViewModel bindings

Feature modules are aggregated in `Modules.kt` via `val featureModules = listOf(...)`.

### Compose Screens
- Use `@Composable` functions, not Activities/Fragments
- ViewModels injected via `koinViewModel()`
- State exposed via `StateFlow` for Compose, `LiveData` for legacy views

### Compose Previews (Required)
Every public composable screen function **must** have a corresponding preview. Follow this pattern:

1. **`*ViewModelMock`** — Abstract ViewModel implementation with no-op methods and mock state
2. **`*PreviewProvider`** — `PreviewParameterProvider<T>` providing multiple state variations
3. **Preview function** — Uses `@AppPreview` annotation + `@PreviewParameter` with the provider

```kotlin
// 1. Mock ViewModel (feature/presentation/preview/*ViewModelMock.kt)
class SearchViewModelMock(mockState: SearchState) : SearchViewModel() {
    private val _state = MutableStateFlow(mockState)
    override var state: StateFlow<SearchState> = _state.asStateFlow()
    override fun observeState() = MutableLiveData(mockState)
    // no-op overrides for abstract methods...
}

// 2. Preview Provider (feature/presentation/preview/*PreviewProvider.kt)
class ComposeSearchPreviewProvider : PreviewParameterProvider<SearchViewModel> {
    override val values = sequenceOf(
        SearchViewModelMock(SearchState.Default),
        SearchViewModelMock(SearchState.Loading),
        SearchViewModelMock(SearchState.Result(mockList())),
    )
}

// 3. Preview function (feature/presentation/Compose*.kt)
@AppPreview
@Composable
fun ComposeSearchPreview(
    @PreviewParameter(ComposeSearchPreviewProvider::class) model: SearchViewModel
) {
    AppTheme { ComposeSearch(model) }
}
```

- Use `@AppPreview` annotation (provides Light + Dark theme previews)
- Place previews in `feature/presentation/preview/` package
- Cover all significant UI states (loading, error, empty, content)

### Strings & Resources
- Strings in `res/values/strings.xml` (English), `res/values-ru/strings.xml` (Russian)
- Theme: `Theme.PlaylistMaker`

## Build & Run

```bash
./gradlew assembleDebug        # Build debug APK
./gradlew installDebug         # Build and install on device
./gradlew test                 # Run unit tests
./gradlew connectedAndroidTest # Run instrumented tests
```

## Code Style

- Kotlin idiomatic style
- No unused imports
- Prefer `val` over `var`
- Use trailing lambda syntax
- Follow existing naming conventions in the codebase
