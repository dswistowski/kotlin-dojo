# Android Kotlin Dojo

## Pre-requisites
- Android Studio 2.3 (https://developer.android.com/studio/index.html)
- Kotlin plugin (https://blog.jetbrains.com/kotlin/2013/08/working-with-kotlin-in-android-studio/)
- Android SDK 26

## Description
##### Connect to the `Spotyfy` Api, retrieve and display information
The Spotify SDK is already configured
All the library needed for the excercise are imported


## Tasks

1) Choose an Api to call between the one implemented in *SpotifyService.kt*
2) Create the Data classes for the Response
3) Create the coroutine for retreiving the data
4) Display the data in a list using Anko
5) Apply filtering and or ordering to the response before displaying the result


### Coroutine Documentation

Composing Suspending Functions (https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md#composing-suspending-functions)

>! You may need to implement a `suspending` function that returns a `suspendCoroutine` and that is called from an `async` block

### Anko Documentation

Anko Layouts (https://github.com/Kotlin/anko/wiki/Anko-Layouts#using-anko-layouts-in-your-project)

### Kotlin Collections Documentation
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html
