package com.example.logicprogram.otherproblems.generalpblms;

import java.util.Arrays;

/**
 * Created by parasmani.sharma on 16/06/2017.
 */

//example to rotate an array by one
    /*Following are steps.
            1) Store last element in a variable say x.
            2) Shift all elements one position ahead.
            3) Replace first element of array with x.*/

public class RotateArrayByOne {

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,7};
        System.out.print("\nInput : "+Arrays.toString(array));
        //expected
        //{7,1,2,3,4,5,6}

        rotateArray(array);
    }

    private static void rotateArray(int[] array)
    {
        int x = array[array.length-1];
        for(int i=array.length-1; i>0;i--)
        {
           array[i] = array[i-1];
        }

        array[0] = x;

        System.out.println("\nOutput : "+Arrays.toString(array));
    }

}
