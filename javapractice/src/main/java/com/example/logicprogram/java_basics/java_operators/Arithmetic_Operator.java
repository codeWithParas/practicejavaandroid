package com.example.logicprogram.java_basics.java_operators;

/**
 * Created by parasmani.sharma on 17/11/2017.
 */

public class Arithmetic_Operator {

    public static void main(String args[]){

        //https://www.javatpoint.com/operators-in-java

        int a=10;
        int b=5;
        System.out.println(a+b);//15
        System.out.println(a-b);//5
        System.out.println(a*b);//50
        System.out.println(a/b);//2
        System.out.println(a%b);//0


        System.out.println(10*10/5+3-1*4/2);       // bodmas  10*2+3-1*2  = 20+3-2 = 21

        int f = 2 * 5 /  2 % 3 + 2*2;
        System.out.println(f);       // bodmas  6
    }

}
