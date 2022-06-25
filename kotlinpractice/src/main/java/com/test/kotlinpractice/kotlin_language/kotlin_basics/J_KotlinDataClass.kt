package com.test.kotlinpractice.kotlin_language.kotlin_basics

class J_KotlinDataClass {
}

// https://www.youtube.com/watch?v=L0VulZZPGbI

data class Person(
    val id : Int,
    val name : String
)

// Data class in kotlin cannot be used with "open" and "inner"

fun main() {
    println(Person(1, "Paras"))
}

// We can inherit other class in data class
// But we can't inherit data class in data class (because "open" keyword is not supported with data class)
// Ex : Man cannot inherit Animal

//open data class Animall(val name: String)
open class Human(open val name: String)
data class Man(override val name: String) : Human("")