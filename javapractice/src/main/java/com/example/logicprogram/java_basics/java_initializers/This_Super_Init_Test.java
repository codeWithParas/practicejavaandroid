package com.example.logicprogram.java_basics.java_initializers;

/**
 * Created by Parasmani Sharma on 11/19/2017.
 */

public class This_Super_Init_Test {

    public static void main(String args[])
    {
        B b = new B(10);
        new B();
    }

}

class A
{
    A()
    {
        this(10);
        System.out.println("def con of A");
    }

    A(int i)
    {
        System.out.println("arg con of A");
    }

    {
        System.out.println("init block of A");
    }
}

class B extends A
{
    B()
    {
        super(10);
        System.out.println("def con of B");
    }

    B(int i)
    {
        this();
        System.out.println("arg con of B");
        new A();
    }

    {
        System.out.println("init block of B");
    }
}