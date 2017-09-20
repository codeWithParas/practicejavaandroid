package com.example.logicprogram.sortingalgo;

import java.util.Scanner;

/**
 * Created by parasmani.sharma on 16/06/2017.
 */

//hint :
    //arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
            //11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
            //11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
            //11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
            //11 12 22 25 64

public class SelectionSort {


    private static int[] arr = new int[50];

    public static void main(String args[])
    {

        // Input the number of elemnts cases you want to run
        System.out.println("Input number of testcases : ");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            System.out.println("Input Size of Array : ");
            int n = sc.nextInt();

            // Input the array
            System.out.println("Input elements in array : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            // Compute and print result
            for (int i = 0; i < n; i++)
            {
                int[] array = selectionSort(arr, n);
                System.out.println(array[i]);
            }


            t--;
        }
    }

    private static int[] selectionSort(int[] arr, int n) {

        if(arr == null)
            return null;

        for(int i=0; i<n;i++)
        {
            for(int j=i+1; j<n;j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        return arr;
    }
}
