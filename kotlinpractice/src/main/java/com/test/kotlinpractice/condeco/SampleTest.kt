package com.test.kotlinpractice.condeco

class SampleTest {
    fun testOperator(totalItemCount: Int, lastVisibleItemPosition: Int) {
        /*if(totalItemCount % 5 == 0 //Satisfy API calling limit (multiple of 5)
            //&& lastVisibleItemPosition % 10 == 0 //When scroll element is on decimal position (40)
            //&& totalItemCount!=lastVisibleItemPosition
        ) {
            if (lastVisibleItemPosition >= totalItemCount - 10) {
                println("lastVisibleItemPosition $lastVisibleItemPosition")
            }
        }*/
        if (lastVisibleItemPosition >= totalItemCount - 10) {
            println("lastVisibleItemPosition $lastVisibleItemPosition")
        }
    }
}

fun main() {
    //SampleTest().testOperator(100, 93)

    println(202 % 50)
}