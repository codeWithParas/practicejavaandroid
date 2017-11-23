package com.example.logicprogram.java_oops.java_inheritance;

/**
 * Created by parasmani.sharma on 23/11/2017.
 */

/*
* Refer : http://www.geeksforgeeks.org/g-fact-63/
* In Java, if name of a derived class static function is same as base class static function then the derived class static
* function shadows (or conceals) the base class static function. For example, the following Java code prints “A.fun()”
*
* Note :If we make both A.fun() and B.fun() as non-static then the above program would print “B.fun()”.
*
* */


class A {
    static void fun() {
        System.out.println("A.fun()");
    }
}

class B extends A {
    static void fun() {
        System.out.println("B.fun()");
    }
}


public class Shadowing {

    public static void main(String args[]) {
        A a = new B();
        a.fun();  // prints A.fun()
    }
}
