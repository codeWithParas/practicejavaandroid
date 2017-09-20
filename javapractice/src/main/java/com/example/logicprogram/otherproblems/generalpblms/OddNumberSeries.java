package com.example.logicprogram.otherproblems.generalpblms;

/**
 * Created by parasmani.sharma on 17/06/2017.
 */

public class OddNumberSeries {

    static int count = 1;

    public static void main(String[] args)
    {
        /*for(int i=1; i<10; i++)
        {
            System.out.println(2*i-1);
        }*/

        printOdd(count);


    }

    private static int printOdd(int i) {

        if (count == 10) {
            return 1;
        } else {
            System.out.println(2*i-1);
            count++;
            return printOdd(count);
        }
    }

}
