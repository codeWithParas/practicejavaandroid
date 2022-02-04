package com.test.kotlinpractice.kotlin_nullability


fun main()
{
    /*
    * Safe Operator -> ?.
    * Elvis Operator -> ?:
    * */

    val s : String? = null
    val length : Int = s?.length ?: 0

    println(length)

    //var s1 : Boolean? = null
    //var s1 : String = ""
    //var length : Int = s1.length ?: 0
    //print("Hello")
}
