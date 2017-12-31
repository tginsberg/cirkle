# Module cirkle

This library provides the ability to address List and MutableList in a
circular manner. Negative indexes are treated as offsets from the end
of the List, and positive indexes that are larger than the size wrap around.

This is loosely modeled after Python's array indexing.

```kotlin
val cirkle = listOf("a", "b", "c").circular()

cirkle[-1] // "c"

```

# Package com.ginsberg.cirkle

This package contains all of the functionality for the Cirkle library.