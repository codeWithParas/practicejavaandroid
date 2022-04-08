package com.test.kotlinpractice.kotlin_language

class F_KotlinSAM {
}

// https://kotlinlang.org/docs/fun-interfaces.html#functional-interfaces-vs-type-aliases
// An interface with only one abstract method is called a functional interface, or a Single Abstract Method (SAM) interface.
// The functional interface can have several non-abstract members but only one abstract member.
// To declare a functional interface in Kotlin, use the fun modifier.
fun interface KRunnable {
    fun invoke()
}

// Example

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }

// Creating an instance of a class
val isEvenNoLambda = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")
}