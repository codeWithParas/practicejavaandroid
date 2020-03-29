package com.test.kotlinpractice.kotlin_nullability


//This is something representing the same behavior and solve the same problem as like : ?. (Safe Access)
// This is called as a kind of wrapper that contains value data inside or not. depends on ur implementation

// Nullable types is not equal to optional in terms of performance. Also it will make use of atleast two objects at once.
// @Nullable annotation used having higher performance. Only single object is created.

class Optional<T>(val value : T) {

    fun isPresent() = value != null    //optional element as per requirement

    fun get() = value ?:
            throw NoSuchElementException("No Value Present")
}