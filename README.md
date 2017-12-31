# Cirkle
Cirkle is a circularly-addressable `List` and `MutableList` for Kotlin.

Any negative index will wrap around from the end of the `List`, and any overly positive index will continue wrapping around back to the start of the `List`. This is partially inspired by Python and all of the times I could have used this during Advent of Code 2017.

## Quick Start

Copy the following into your `build.gradle` or `build.xml`, cirkle has no additional dependencies.

**Gradle**
```groovy
compile 'com.ginsberg:cirkle:1.0.0'
```

**Maven**
```xml
<dependency>
    <groupId>com.ginsberg</groupId>
    <artifactId>cirkle</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

Convert a `List` to a circularly-addressable list:

```kotlin
val cirkle = listOf("a", "b", "c").circular()
```

Convert a `MutableList` to a circularly-addressable list:

```kotlin
val cirkle = mutableListOf("a", "b", "c").circular()
```

## Examples

**Get with negative index**
```kotlin
val cirkle = listOf("a", "b", "c").circular()
cirkle[-1]  // "c"
cirkle[-4]  // "c"
```

**Get with overly positive index**
```kotlin
val cirkle = listOf("a", "b", "c").circular()
cirkle[3]  // "a"
cirkle[6]  // "a"
```

**Set with negative index**
```kotlin
val cirkle = mutableListOf("a", "b", "c").circular()
cirkle[-1] = "d"  // ["a", "b", "d"] or...
cirkle[-4] = "d"  // ["a", "b", "d"]
```


**Set with overly positive index**
```kotlin
val cirkle = mutableListOf("a", "b", "c").circular()
cirkle[3] = "d"  // ["d", "b", "c"] or...
cirkle[6] = "d"  // ["d", "b", "c"]
```


**SubList with negative indexes**
```kotlin
val cirkle = listOf("a", "b", "c").circular()
cirkle.subList(-3, -1)  // ["a", "b"]
```


**SubList with overly positive indexes**
```kotlin
val cirkle = listOf("a", "b", "c").circular()
cirkle.subList(3, 5)  // ["a", "b"]
```


**Add with negative index**
```kotlin
val cirkle = mutableListOf("a", "b", "c").circular()
cirkle.add(-1, "d")   // ["a", "b", "d", "c"] or...
cirkle.add(-4, "d")   // ["a", "b", "d", "c"]
```


**Add with overly positive index**
```kotlin
val cirkle = mutableListOf("a", "b", "c").circular()
cirkle.add(3, "d")   // ["d", "a", "b", "c"] or...
cirkle.add(6, "d")   // ["d", "a", "b", "c"]
```


## Contributing and Issues

Please feel free to file issues for change requests or bugs. If you would like to contribute new functionality, please contact me first!

Copyright &copy; 2018 by Todd Ginsberg