package com.test.kotlinpractice.kotlin_functions_type

fun main()
{
    print("\n"+TestingFunctions().respondToinput("tea")+"\n")
}

class TestingFunctions
{
    fun respondToinput(input : String) = when(input) {
        "y", "yes", "OK", "tea", "done" -> "I'm glad you agree"
        "n", "no" -> "Sorry to hear that"
        else -> "I don't understand you"
    }
}