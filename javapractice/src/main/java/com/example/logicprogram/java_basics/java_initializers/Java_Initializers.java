package com.example.logicprogram.java_basics.java_initializers;

/**
 * Created by Parasmani Sharma on 11/19/2017.
 */

/*
* Two types of initialzers :
* 1) static block
*
*           a)invoked at the time of class loading
*           b)used to initialize static members.
*           c)is a part of class loading and runs before main.
*           d)static block run ones for every class
*           e)cannot reference non-static members inside it(allocation of memory)
*
*
* 2) init block
*
*           a)invoked at the call of constructor when obj created
*           b)used to initialize non-static members.
*           c)is a part of each & every constructor of class & runs before every constructor.
*           d)it can run number of times whenever constructor of the class is called.
*           e)can reference any static member to reassign value.
*
*
* Conclusion : Control go to 1) Static block first then 2)init block executed and then 3)constructor.
*
* */

public class Java_Initializers {

    public static final void main(String args[])
    {
        //Demo obj = new Demo();
        //new Demo();
        new Demo();
    }
}

class Demo
{
    int a ;
    static int b;

    Demo()
    {
        System.out.println("Constructor");
    }

    {
        System.out.println("Init BLock");
    }

    static
    {
        b = 0;
        new Demo();
        System.out.println("Static BLock");
    }

}
