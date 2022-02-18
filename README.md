# MealPack - Built on Mordern Android Architecture
The project tries to combine popular Android tools and to demonstrate best development practices by utilizing up to date tech-stack like Compose, Kotlin Flow and Hilt.

## Description

* UI 
   * [Compose](https://developer.android.com/jetpack/compose) declarative UI framework
   * [Material design](https://material.io/design)

* Tech/Tools
    * [Kotlin](https://kotlinlang.org/) 100% coverage
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Flow](https://developer.android.com/kotlin/flow) for async operations
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose) 
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) for navigation between composables
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that stores, exposes and manages UI state
    * [Retrofit](https://square.github.io/retrofit/) for networking
    * [Coil](https://github.com/coil-kt/coil) for image loading
    
* Modern Architecture
    * Single activity architecture (with [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)) that defines navigation graphs
    * MVVM for presentation layer
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
    * [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions
    
    ## Presentation patterns layers
* View - Composable screens that consume state, apply effects and delegate events upstream.
* ViewModel - [AAC ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that manages and set the state of the corresponding screen. Additionally, it intercepts UI events as callbacks and produces side-effects. The ViewModel is scoped to the lifetime of the corresponding screen composable in the backstack.
* Model - Data source classes that retrieve content. In a Clean architecture context, one could use UseCases or Interactors that tap into repositories or data sources directly.

![](https://i.imgur.com/OdPje6D.png)

As the presentation layer is defined with MVVM, there are a two core components described:
* **State** - data class that holds the state content of the corresponding screen e.g. list of `FoodItem`, loading status etc. The state is exposed as a Compose runtime `MutableState` object from that perfectly matches the use-case of receiving continuous updates with initial value.

* **Effect** - plain object that signals one-time side-effect actions that should impact the UI e.g. triggering a navigation action, showing a Toast, SnackBar etc. Effects are exposed as `ChannelFlow` which behave as in each event is delivered to a single subscriber. An attempt to post an event without subscribers will suspend as soon as the channel buffer becomes full, waiting for a subscriber to appear.

Every screen/flow defines its own contract class that states all corresponding core components described above: state content and effects.

### Dependency injection
[Hilt](https://developer.android.com/training/dependency-injection/hilt-android) is used for Dependency Injection as a wrapper on top of [Dagger](https://github.com/google/dagger). 

Most of the dependencies are injected with `@Singleton` scope and are provided within the `FoodMenuApiProvider` module.

For ViewModels, we use the out-of-the-box `@HiltViewModel` annotation that injects them with the scope of the navigation graph composables that represent the screens.

## Screenshots

![1](https://user-images.githubusercontent.com/89233917/154663548-1d9678e7-0029-406c-850f-cccd7399a5df.png)             ![2](https://user-images.githubusercontent.com/89233917/154663551-930af72a-e2f4-4633-a765-97c834057337.png)


![3](https://user-images.githubusercontent.com/89233917/154663554-b71c9c57-38c7-4262-836d-fa30ef9e854d.png)             ![4](https://user-images.githubusercontent.com/89233917/154663561-e4c28012-82c6-4932-a6cb-7ec94c9aedee.png)


![5](https://user-images.githubusercontent.com/89233917/154663566-051279e0-a4a8-4a96-9d8c-a28e931dbec1.png)             ![6](https://user-images.githubusercontent.com/89233917/154663571-85c53bca-3fc1-4eb6-949a-144535967958.png)


![7](https://user-images.githubusercontent.com/89233917/154663573-ef8bdb31-c8e5-4c6a-b5fa-572cdb6d3cd8.png)             ![7a](https://user-images.githubusercontent.com/89233917/154663574-e7a787c1-8dd7-496e-a099-5672b47f1705.png)


![8](https://user-images.githubusercontent.com/89233917/154663579-3452f3c7-6383-45b2-99ed-1421375198a7.png)             ![9](https://user-images.githubusercontent.com/89233917/154663582-aa4e2535-cfd5-4846-a11d-a2990304057e.png)


![10](https://user-images.githubusercontent.com/89233917/154663587-6debad6e-212e-4ad8-b78f-14b970d90e5e.png)             ![11](https://user-images.githubusercontent.com/89233917/154663589-2f074abc-e668-4d2e-91bf-8871f06533d8.png)


![12](https://user-images.githubusercontent.com/89233917/154663596-97e287c3-a3b2-4f78-967e-faa907971066.png)             ![13](https://user-images.githubusercontent.com/89233917/154663601-0241d7c0-eb8a-4bf2-a0c1-aaeca27610d8.png)


![14](https://user-images.githubusercontent.com/89233917/154663603-ae706ae1-10ba-4a27-b0a5-7ba06f3841d7.png)              ![15](https://user-images.githubusercontent.com/89233917/154663528-34b1af7d-96f1-4ee5-815d-0d53da2f4464.png)

