package com.test.kotlinpractice.kotlin_language

class H_KotlinExtensionFunction {
}

// Extension Function :  Works with both 3rd party library class or user defined class.
fun String.getAllWords(): List<String> {
    return this.split(" ")
}

fun main() {
    val name = "Paras Mani Sharma"
    println(name.getAllWords())
}