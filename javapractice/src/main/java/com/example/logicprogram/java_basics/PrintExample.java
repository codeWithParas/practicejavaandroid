package com.example.logicprogram.java_basics;

/**
 * Created by parasmani.sharma on 17/11/2017.
 */

public class PrintExample {

    public static void main(String args[]) {

        /*
        * 1)
        * */

        long x = 42L;
        long y = 44L;

        System.out.print(" " + 7 + 2 + " ");
        System.out.print("foo" + x + 5 + " ");
        System.out.print(x + y + "foo");

        //ans :  72 foo425 86foo








        /*
        * 2)
        * https://stackoverflow.com/questions/27587288/what-would-be-the-output-of-this-program-and-how
        * 011 = 0*8^2 + 1*8^1 + 1*8^0 = 0+8+1 = 9.
        * */

        int k = 011;
        System.out.println(011 + 1);    // ans : 10  :  011 is actually an octal value. 1*8^1 + 1*8^0 -> 8 + 1 -> 9







        /*
        * 3)
        * Compilation error
        * */

        /*while (1)
        {
            System.out.print("ok");
        }*/



        /*
        * 4) % operator
        *
        * */
        int q = 5;
        int w = 7;
        System.out.println("% operator : " + (w*2)%q);
        System.out.print("  " + (w%q));


    }


}