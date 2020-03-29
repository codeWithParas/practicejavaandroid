package com.test.kotlinpractice.kotlin_functions_type.overloading

fun main()
{

    val sum = OverloadedFunction().sum(1, 2)
    val sum1 = OverloadedFunction().sum(1, 2, 3)
    val sum2 = OverloadedFunction().sum()
    print(sum2)
}

class OverloadedFunction
{
    //@JvmOverloads : you can use this with kotlin function when you call kotlin function from java.

    //@JvmOverloads
    fun sum(a: Int = 0, b: Int = 0, c:Int = 0) = a+b+c
}