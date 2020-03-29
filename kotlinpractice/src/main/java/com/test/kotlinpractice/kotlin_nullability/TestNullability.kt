package com.test.kotlinpractice.kotlin_nullability

fun main() {
    TestNullability("Kotlin").greet()
    TestNullability(null).greet()
}

class TestNullability(val name: String?) {
    fun greet() {
        println("Hello, $name")
    }
}