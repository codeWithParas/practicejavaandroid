package com.example.logicprogram.java_oops;

/**
 * Created by parasmani.sharma on 25/07/2017.
 */

/*
* Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another class.
* Types :
* 1) Single Level
* 2) Multilevel
*
* */

class Parent
{
    int a = 10;

    public void m()
    {
        System.out.print("Parent a : " + a);
    }
}

class Child extends Parent
{
    int a = 20 ;
    public void m()
    {
        System.out.print("\nChild a : " + a);
    }
}

public class Inheritance {

    public static void main(String args[])
    {
        Parent p  = new Child();
        int a = p.a;
        System.out.print("Main a : " + a);
        p.m();

    }

}
