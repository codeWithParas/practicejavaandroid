package com.example.logicprogram.java_basics.java_operators;

/**
 * Created by parasmani.sharma on 17/11/2017.
 */

public class Unary_Operator {

    /*
    * Unary operator are :
    *     ++ -- ~ !
    *
    * */

    public static void main(String args[]){
        int a=10;
        int b=-10;
        int e= 5;
        boolean c=true;
        boolean d=false;
        System.out.println(~a);//-11 (minus of total positive value which starts from 0) -(1+10)
        System.out.println(~b);//9 (positive of total minus, positive starts from 0)      -(1-10)
        System.out.println(!c);//false (opposite of boolean value)
        System.out.println(!d);//true
    }


}
