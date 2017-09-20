package com.example.logicprogram.otherproblems.generalpblms;

import java.util.Scanner;

/**
 * Created by parasmani.sharma on 16/06/2017.
 */

public class SearchElemInRotatedArray {

    private static Scanner scan;

    public static void main(String[] args)
    {

        System.out.print("Enter Number of TestCases : ");
        scan = new Scanner(System.in);
        int numbTestCase = scan.nextInt();
        int[] array ;

        // One by one run for all input test cases
        int count = 0;
        while (count<=numbTestCase)
        {
            System.out.println("\nEnter size of TestCase " + (count) + " : ");
            int tsize = scan.nextInt();
            array = new int[tsize];
            System.out.println("Enter "+tsize+" elements for TestCase : " + (count));
            for(int i=0;i<=tsize; i++)
            {
                array[i] = scan.nextInt();
            }



        }

    }


}
