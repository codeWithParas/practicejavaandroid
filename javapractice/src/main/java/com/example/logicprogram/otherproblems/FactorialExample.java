package com.example.logicprogram.otherproblems;

import java.util.Scanner;

/**
 * Created by parasmani.sharma on 20/05/2017.
 */

public class FactorialExample {

    public static void main(String arg[])
    {

        System.out.println("Enter any number ?");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int fact = number;


        //using while

        /*while (number>1)
        {
            int a = fact*(number-1);
            fact = a;
            number--;

        }*/

        //using recursion

        System.out.println("\nFactorial is = " + fact(number));
    }


    private static int fact(int n)
    {
        if(n == 0)
            return 1;
        return n * fact(n - 1);
    }


}
