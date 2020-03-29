package com.test.kotlinpractice.kotlin_range

fun main()
{
    print(TestRange().checkRange("Hi"))
    print("\n"+ TestRange().checkRangee("A"))
}

class TestRange
{
    fun checkRange(s : String) : Boolean
    {
        if(s in "A".."H")
        {
            return true
        }
        return false
    }

    //writing method in other way
    fun checkRangee(s : String) : Boolean = s in "A".."H"
    /*{
        if(s in "A".."H")
        {
            return true
        }
        return false
    }*/
}