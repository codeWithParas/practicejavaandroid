package com.test.kotlinpractice.kotlin_language.kotlin_basics

class L_KotlinGenerics {
}

//https://www.youtube.com/watch?v=yuJNXSZFET8

/*class ArrayUtil(private val array : Array<Int>) {
    fun findElement(element:Int, foundElement: (index: Int, element: Int?) -> Unit) {
        for(i in array.indices){
            if(array[i] == element){
                foundElement(i, array[i])
                return
            }
        }
        foundElement(element, null)
        return
    }
}

fun main1() {
    val arrayUtil = ArrayUtil(arrayOf(1,2,3,4,5,6))
    arrayUtil.findElement(3) { index, element ->
        println("Index $index")
        println("Element $element")
    }
}*/

// Converting above scenario to generic type
/*
class ArrayUtil<T>(private val array : Array<T>) {
    fun findElement(element:T, foundElement: (index: Int, element: T?) -> Unit) {
        for(i in array.indices){
            if(array[i] == element){
                foundElement(i, array[i])
                return
            }
        }
        foundElement(0, null)
        return
    }
}

fun main() {

    val arrayUtil = ArrayUtil<Int>(arrayOf(1,2,3,4,5,6))
    val arrayUtilStr = ArrayUtil<String>(arrayOf("1","2","3","4","5","6"))

    arrayUtil.findElement(3) { index, element ->
        println("Index $index")
        println("Element $element")
    }
    arrayUtilStr.findElement("3") { index, element ->
        println("Index $index")
        println("Element $element")
    }

}*/

// Optimise more in above generic case

fun <T> findElement(array: Array<T>, element: T, foundElement: (index: Int, element: T?) -> Unit) {
    for (i in array.indices) {
        if (array[i] == element) {
            foundElement(i, array[i])
            return
        }
    }
    foundElement(0, null)
    return
}

fun main() {

    // Higher Order Function
    // If callback is the last arguements then we can take out lambda outside of () brackets. This process called Trailing lambda.
    /*findElement(arrayOf(1,2,3,4,5,6), 3, { index, element ->

    })*/


    // Trailed lambda
    findElement(arrayOf(1, 2, 3, 4, 5, 6), 3) { index, element ->
        println("Index $index")
        println("Element $element")
    }
    findElement(arrayOf("1", "2", "3", "4", "5", "6"), "3") { index, element ->
        println("Index $index")
        println("Element $element")
    }
}