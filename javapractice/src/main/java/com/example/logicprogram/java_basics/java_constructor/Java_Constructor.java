package com.example.logicprogram.java_basics.java_constructor;

/**
 * Created by parasmani.sharma on 18/11/2017.
 */

/*
* Refer : http://skillgun.com/java/constructors/tutorial
*
* Constructors :
* 1) Can be private used in singleton pattern
* 2) Constructors not have any return type
* 3) Having a return type for constructor will not give any pblm but then it will act like a normal method.
* 4) Life Cycle of Constructor :
* a)Constructor will be called only after creating the object.
* b)"new" operator will create the object , not the constructor.
* c) Constructor are used to initialize the objects, and to initialize the instance variable.
*
* Note : If you make private constructor then we cannot craete objects of that class from outside world(class).
*
* */





public class Java_Constructor {

    //Java_Constructor o = new Java_Constructor();
    public Java_Constructor() {

        //Java_Constructor o = new Java_Constructor();
    }

    public static void main(String args[]) {
        Java_Constructor o = new Java_Constructor();

    }
}
