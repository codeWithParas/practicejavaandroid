package com.test.kotlinpractice.kotlin_language

class KotlinConstructor(name: String) // Primary Constructor
{
    var firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    //Secondary Constructor
    constructor() : this("Sharma") {
        // First will run properties and init blocks
        // After that control comes here
        println("Secondary constructor executed")
    }
}

fun main() {
    KotlinConstructor("Paras") // Calling Primary Constructor
    KotlinConstructor()   // Calling Secondary Constructor
}