package com.test.kotlinpractice.kotlin_language.kotlin_basics

// https://stackoverflow.com/questions/45173677/invoke-operator-operator-overloading-in-kotlin#:~:text=Operator%20Function%20invoke()%20Kotlin,class%20without%20a%20method%20name.
//Operator Function invoke() Kotlin provides an interesting function called invoke, which is an operator function.
// Specifying an invoke operator on a class allows it to be called on any instances of the class without a method name.
//A few things to note about invoke() here. It:
//Is an operator function. but why ?
//Can take parameters.
//Can be overloaded.
//Is being called on the instance of a Greeter class without method name.

fun main(args: Array<String>) {
    //this calls the invoke function which takes String as a parameter
    /*val greeter = Greeter(greeting = "Welcome")
    greeter(name = "Kotlin")*/


    //Invoke calling : ()()
    // Note : Always called on any instances of the class. Not at the time of creation of object.
    MyFunction()()
    val obj = MyFunction()
    obj()
}

class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting $name")
    }
}

class MyFunction : () -> Unit {
    override fun invoke() {
        println("Hi Mom")
    }
}