package com.example.logicprogram.datastructure.sortingalgo;

/**
 * Created by parasmani.sharma on 16/06/2017.
 */

public class BubbleSort {

    public static void main(String args[])
    {
        int[] array = {21,23,34,32,1,3,8,2,5,9};

        //int[] arr = bubbleSort(array);
        int[] arr = bubbleSortIterator(array);

        for(int i=0; i<arr.length; i++)
        {
            System.out.print("\nElement : "+ arr[i]);
        }
    }

    private static int[] bubbleSort(int[] array) {

        int count = array.length-1;

            for(int i = 0; i<array.length; i++)
            {
                for(int j=0; j<array.length; j++)
                {
                    try {
                        if (array[j] > array[j + 1]) {
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }catch (ArrayIndexOutOfBoundsException e){}
                }
            }
        return array;
    }

    //using iteration

    private static int[] bubbleSortIterator(int[] array)
    {
        for(int j=0; j<array.length; j++)
        {
            try {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }catch (ArrayIndexOutOfBoundsException e){}
        }

        return bubbleSort(array);
    }
}
