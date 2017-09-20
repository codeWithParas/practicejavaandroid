package com.example.logicprogram.stringplay;

/**
 * Created by parasmani.sharma on 14/06/2017.
 */

public class bConvertStringToArray {

    public static void main(String[] arg)
    {
        //get character at position k=8;

        int k = 8;

        String str = "AnyString";
        String[] array = new String[str.length()];

        for (int i=0; i< str.length(); i++)
        {
            array[i] = String.valueOf(str.charAt(i));
        }

        for (int i=0; i< array.length; i++)
        {
            if(i == k-1)
            {
                System.out.println("\nData req : " + array[i]);
            }
            //System.out.println("\nString array : " + array[i]);
        }
    }

}
