package com.test.kotlinpractice.kotlin_language.kotlin_basics

class KotlinConstructor(name: String) {
    var firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    //Secondary Constructor
    constructor() : this("name") {
        println("Secondary constructor executed")
    }
}

fun main() {
    KotlinConstructor()   // Calling Secondary Constructor
    KotlinConstructor("Paras") // Calling Primary Constructor
}