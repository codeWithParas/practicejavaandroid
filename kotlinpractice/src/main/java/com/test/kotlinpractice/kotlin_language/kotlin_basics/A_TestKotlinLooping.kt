package com.test.kotlinpractice.kotlin_language.kotlin_basics

class A_TestKotlinLooping {

}

fun main() {

    print("for (i in 1..5) print(i) = ")
    for (i in 1..5) print(i)

    println()

    print("for (i in 5..1) print(i) = ")
    for (i in 5..1) print(i)             // prints nothing

    println()

    print("for (i in 5 downTo 1) print(i) = ")
    for (i in 5 downTo 1) print(i)

    println()

    print("for (i in 1..5 step 2) print(i) = ")     // step make even or odd cases
    for (i in 1..5 step 2) print(i)

    println()

    print("for (i in 5 downTo 1 step 2) print(i) = ")
    for (i in 5 downTo 1 step 2) print(i)


    println()
    //Iterating Through an Array
    val language = arrayOf("Ruby", "Kotlin", "Python", "Java")
    for (item in language)
        println(item)

    //Similar like arrays, you can iterate through a String with an index
    val text = "Kotlin"
    for (item in text.indices) {
        println(text[item])
    }
}