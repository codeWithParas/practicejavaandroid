package com.test.kotlinpractice.kotlin_language

class KotlinConditionalStatement {
}

fun main() {
    //When expression
    //when defines a conditional expression with multiple branches. It is similar to the switch statement
    val x = 1
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    //when can be used either as an expression or as a statement.
    //If when is used as an expression, the else branch is mandatory
    val numericValue = when (Bit.ONE) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
        // 'else' is not required because all cases are covered
    }

    //To define a common behavior for multiple cases, combine their conditions in a single line with a comma
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    when (x) {
        in 1..10 -> print("x is in the range")
        //in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    //when can also be used as a replacement for an if-else if chain
    val y = 0
    when {
        x % 3 == 0 -> print("x is odd")
        y % 2 == 0 -> print("y is even")
        else -> print("x+y is odd")
    }
}

enum class Bit {
    ZERO, ONE
}