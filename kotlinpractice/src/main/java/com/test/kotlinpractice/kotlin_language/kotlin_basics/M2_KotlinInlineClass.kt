package com.test.kotlinpractice.kotlin_language.kotlin_basics

class M_KotlinInlineClass {
}

// https://www.youtube.com/watch?v=299JutMzT3Y
// https://kotlinlang.org/docs/inline-classes.html#members

// it is wrapper that holds desired value
// inline class provide safety in parameter passing


//@JvmInline
inline class Width(val value: Long)

//@JvmInline
inline class Height(val value: Long)

class Rectangle(width: Width, height: Height) {
    private val width: Width? = width
    private val height: Height? = height
    fun printSpec() {
        println("${this.width}, ${this.height}")
    }
}

fun main(array: Array<String>) {
    val width = Width(100L)
    val height = Height(50L)
    // var shape = Rectangle(height, width)   // Not work with inline
    var shape = Rectangle(width, height)
    shape.printSpec()
}