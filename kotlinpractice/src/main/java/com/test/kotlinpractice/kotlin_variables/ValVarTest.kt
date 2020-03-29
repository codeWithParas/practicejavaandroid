package com.test.kotlinpractice.kotlin_variables

fun main()
{
    /*
    * 1)  Val : cannot reassigned
    * */
    val sVal  = 1
    //sVal = " "      //compile time error

    /*
    * 2) Var : can be reassigned
    *  */
    var sVar = 1
    sVar = 2
    print(sVar)

    /*
    * 3) Lists : mutable and read-only
    * */

    val mutableList = mutableListOf<String>("Java")
    mutableList.add("Kotlin")                             //mutable list

    val readOnlyList = listOf<String>("Java")
    //readOnlyList.add("Kotlin")                          //read-only list
    println(readOnlyList.get(0))

}