package com.example.logicprogram.otherproblems;

/**
 * Created by parasmani.sharma on 22/05/2017.
 */

public class PostPreIncreDecre {


    static int a = 10;
    static int b = 0;
    static
    {
        //a = a-- - --a;
        b = a-- ;
        //b = --a ;
        System.out.println("Inside Static block : "+b+"");
        System.out.println("Inside Static block : "+a+"");
    }

    /*{
        //a = a++ + ++a;
        a = a++ ;
    }*/

    public static void main(String[] args)  {

        System.out.println("Inside main  : " + a);

    }
}
