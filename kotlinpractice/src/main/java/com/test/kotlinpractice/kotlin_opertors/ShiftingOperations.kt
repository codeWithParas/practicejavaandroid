package com.test.kotlinpractice.kotlin_opertors

class ShiftingOperations {
}

fun main() {
    // Test shifting operations
    val x = -4
    val y = 4
    //Right Shift
    println(x shr 1)
    println(y shr 1)

    //Left Shift
    println(x shl 1)
    println(y shl 1)

    //In Java, the operator ‘>>>’ denotes unsigned right shift operator and always fill 0 irrespective of the sign of the number.
    // z is stored using 32 bit 2's complement form.
    // Binary representation of -1 is all 1s (111..1)
    val z = -1
    // The value of 'x>>>29' is 00...0111
    println(z ushr 29)
    // The value of 'x>>>30' is 00...0011
    println(z ushr 30)
    // The value of 'x>>>31' is 00...0001
    println(z ushr 31)

    val c = -2
    // The value of 'x>>>29' is 00...0111
    println(c ushr 30)
    println(c shr 30)


}