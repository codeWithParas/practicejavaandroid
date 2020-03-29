package com.example.logicprogram.java_basics.java_wrapper;

import java.util.ArrayList;

/**
 * Created by parasmani.sharma on 11/10/2017.
 */

/*
* Link : https://www.geeksforgeeks.org/wrapper-classes-java/
*
* About Wrapper : A Wrapper class is a class whose object wraps or contains a primitive data types.
* Example : Integer, Character, Short, Float, Double, Boolean.
*
* */

public class Wrapper_Class {
}

class Autoboxing
{
    public static void main(String[] args)
    {
        char ch = 'a';

        // Autoboxing- primitive to Character object conversion
        Character a = ch;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        // Autoboxing because ArrayList stores only objects
        arrayList.add(25);

        // printing the values from object
        System.out.println(arrayList.get(0));
    }
}

class Unboxing
{
    public static void main(String[] args)
    {
        Character ch = 'a';

        // unboxing - Character object to primitive conversion
        char a = ch;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(24);

        // unboxing because get method returns an Integer object
        int num = arrayList.get(0);

        // printing the values from primitive data types
        System.out.println(num);
    }
}