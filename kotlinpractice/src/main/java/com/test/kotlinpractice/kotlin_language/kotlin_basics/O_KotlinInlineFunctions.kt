package com.test.kotlinpractice.kotlin_language.kotlin_basics

class O_KotlinInlineFunctions {
}


fun main() {

    inlineFunction {
        println("Inline Function Called")
    }
}


// Increase the performance of higher order functions by not creating separate class
// of inline function inside bytecode.
// Check Bytecode of this program. Tools -> Kotlin -> Show kotlin bytecode

inline fun inlineFunction(callback: () -> Unit) {
    //callback()
    println("Inside Inline Function")
    callback()
}