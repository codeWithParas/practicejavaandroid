package com.example.logicprogram.datastructure.LinearDS.arrayDS;

import java.util.Arrays;

/**
 * Created by parasmani.sharma on 07/09/2017.
 */

public class RotateArrayBySomePosition {

    // lets say position will be 3


    public static void main(String arg[])
    {
        int postion = 3;
        int[] array = {4,5,6,7,8,9,10,11,12};  //(7,8,9,10,11,12,4,5,6)
        System.out.println("Array : " + Arrays.toString(array));

        int tempFirst ;
        int count = 0 ;

        while (count<postion)
        {
            tempFirst = array[0];
            array = rotateArrayByOneElement(array);
            array[array.length-1] = tempFirst;
            count++;
        }


        System.out.println("Rotated Array : " +Arrays.toString(array));
    }

    private static int[] rotateArrayByOneElement(int[] array) {

        int[] arrayS = new int[array.length];

        for (int i=1;i<array.length;i++)
        {
            arrayS[i-1] = array[i];
        }

        return arrayS;
    }

}
