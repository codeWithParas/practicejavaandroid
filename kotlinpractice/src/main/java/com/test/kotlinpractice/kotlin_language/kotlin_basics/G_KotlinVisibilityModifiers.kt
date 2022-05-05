package com.test.kotlinpractice.kotlin_language.kotlin_basics

class G_KotlinVisibilityModifiers {
}

//There are four visibility modifiers in Kotlin: private, protected, internal, and public.
// The default visibility is public.

// Example :
// file name: G_KotlinVisibilityModifiers.kt
// package com.test.kotlinpractice.kotlin_language

private fun foo() {} // visible inside G_KotlinVisibilityModifiers.kt

public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in G_KotlinVisibilityModifiers.kt

internal val baz = 6    // visible inside the same module
