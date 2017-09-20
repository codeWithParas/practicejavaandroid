package com.example.logicprogram.sortingalgo;

import java.util.Arrays;

/**
 * Created by parasmani.sharma on 20/06/2017.
 */

/*
* hint : find the pivot element for an array.
* */

public class QuickSort {

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;


        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
            System.out.println("\nPivot Element : " + pi+ "\n");

            // Recursively sort elements before
            // partition and after partition

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        //int arr[] = {10, 7, 8, 9, 1, 5};
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;

        System.out.println(arr.toString()+"\n\n");


        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);

        QuickSort obj = new QuickSort()
        {
            @Override
            int partition(int[] arr, int low, int high) {
                return super.partition(arr, low, high);
            }
        };
    }


}
