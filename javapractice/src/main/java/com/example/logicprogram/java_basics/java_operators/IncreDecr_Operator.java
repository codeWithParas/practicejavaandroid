package com.example.logicprogram.java_basics.java_operators;

/**
 * Created by parasmani.sharma on 17/11/2017.
 */

public class IncreDecr_Operator {

    public static void main(String args[])
    {
        int[] a = {10,20,30};
        int i = 1;

        a[++i] = --i;
        System.out.print(a[0]+a[1]+a[2] + " i : "+i);    // ans : 31


        int c=10;
        int b=10;
        System.out.println(c++ + ++c);//10+12=22
        System.out.println(b++ + b++);//10+11=21

    }

}
