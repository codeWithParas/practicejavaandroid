package com.example.logicprogram.otherproblems;

import java.util.Scanner;

/**
 * Created by parasmani.sharma on 20/05/2017.
 */

public class FibonacciSeries {

    public static void main(String a[]){

        //0,1,1,2,3,5,8,13........

        System.out.print("Enter number to check fibonacci series :");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();


        /*Integer[] fibArray = new Integer[number];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for(int i=2; i<number; i++)
        {
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }

        for(int i=0;i<fibArray.length;i++)
        {
            if(fibArray[i] < number)
            {
                System.out.print("\nFib series number " + fibArray[i]);
            }

        }*/


        //or

        FibonacciSeries obj = new FibonacciSeries();
        System.out.print("Number of elements in Fibonacci for entered number : " + obj.Fibonacci(number));

    }

    int Fibonacci(int number)
    {

        //next number is a sum of previous two number
        if (number <= 1) return number;
        System.out.println((number-2) + " " + (number-1));
        return Fibonacci(number - 2) + Fibonacci(number - 1);
    }
}
