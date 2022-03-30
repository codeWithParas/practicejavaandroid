package com.test.kotlinpractice.kotlin_language

class O_KotlinInlineFunctions {
}


fun main() {

    inlineFunction {
        println("Calling Inline Function")
    }
}


// Increase the performance of higher order functions by not creating separate class
// of inline function inside bytecode.
// Check Bytecode of this program. Tools -> Kotlin -> Show kotlin bytecode

inline fun inlineFunction(callback: () -> Unit) {
    callback()
    println("Inside Inline Function")
}