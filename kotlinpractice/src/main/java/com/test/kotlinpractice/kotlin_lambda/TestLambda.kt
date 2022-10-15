package com.test.kotlinpractice.kotlin_lambda

fun main()
{
    // This case expecting a anonymous function.
    // so providing {} will make it to return anonymous function type.
    // val f1 : () -> Int? = null
    val f1 : () -> Int? = { null }

    // returning whole as a null value, & returning function is not Anonymous.
    val f3 : (() -> Int)? = null
    // returning 1 as a integer value, & returning whole as a function which is Anonymous type.
    val f33 : (() -> Int)? = {1}
    val f333 : (() -> Int?)? = {null}
}