package com.test.kotlinpractice.kotlin_language

class KotlinInheritance {


}

fun main() {
    val dog = Dog()
    dog.fourLegs()
    println("${dog.legsCount}")
}

//Overriding Class
class Dog : Animal("Dog") {
    // Overriding Properties
    override val legsCount: Int
        get() = 4

    // Overriding Method
    override fun fourLegs() {
        println("Overrided legsCount $legsCount")
    }
}

open class Animal(private val name: String) {
    open val legsCount: Int = 0
    open fun fourLegs() {
        println("$legsCount")
    }
}