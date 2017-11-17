package com.example.logicprogram.java_basics;

/**
 * Created by parasmani.sharma on 17/11/2017.
 */

/*
* i. A variable which is declared as static at class level is called as static variable. A static variable is also called as
* class variable, because it is associated with a class and not with individual objects of that class. Instance variables are
* associated with each object of that class, as opposed to static variables.
* ii. There will be only one copy of static variable will be created for each class and same copy will be shared with all the
* objects of that class. Where as each object will have its own separate set of instance variables. Static variables will be
* created at the time of program or class loading time. Where as instance variables will be created when an object for that class
* is created by using new operator.
* iii. If static variable is not private then these variables can be accessed without instantiating the class, and directly by
* using class name.
* iv. Java doesn't support local static variables
*
* */


public class StaticKeyword {

    public static void main(String args[])
    {
        System.out.println(Test.i);
    }

}


class Test
{
    static int i ;
}
