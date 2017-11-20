package com.example.logicprogram.java_basics;

/**
 * Created by Parasmani Sharma on 11/19/2017.
 */

/*
* There  are number of REQUIREMENT of final keyword :
* 1) I have a function in base class which want to share with derived classes but they should not be able to override that fn.
* 2) I have a class and I don't want any one to inherit that class.
*
* By default all the function of final class become final methods.
* Final class are also called as immutable classes, because nobody can change the definition of that class.
* Example : All wrapper classes for primitive data types are immutable.
* Example : String, string
*
* Note : The final keyword is used to obstruct the change in given Variable or Method or Class for which it is used.
*
* */

class Base
{
    public final int a = 0;
    String d = "";

    public final void method(int i)
    {
        System.out.println(i);
    }

}

class Child extends Base
{
    //not possible to write if it is final
    /*public void method(int i)
    {

    }*/
}

public class Java_Final_Keyword
{
    public static void main(String args[])
    {
        Child obj = new Child();
        obj.method(10);
    }

}
