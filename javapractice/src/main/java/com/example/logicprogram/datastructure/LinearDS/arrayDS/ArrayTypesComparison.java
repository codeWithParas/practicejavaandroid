package com.example.logicprogram.datastructure.LinearDS.arrayDS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by parasmani.sharma on 01/06/2017.
 */

public class ArrayTypesComparison {

    public static void main(String[] arrgs) {

        System.out.println("One Dimensional Array Comparisons");

        oneDcompare();


        System.out.println("\n\n\n\nTwo Dimensional Array Comparisons");

        multiDcompare();


        System.out.println("\n\n\n\nConverting arraylist to string array");

        convertArrayListToArray();

        /*write for-loops that initialize "array" so that the following patterns are printed:
        (a) 1 0 0 0
            2 3 0 0
            4 5 6 0
            7 8 9 10
        (b) 1 0 0 0
            1 2 0 0
            1 2 3 0
            1 2 3 4
        (c) 1 2 3 4
            0 3 4 5
            0 0 5 6
            0 0 0 7
        (d) 1 0 1 0
            0 1 0 1
            1 0 1 0
            0 1 0 1
        */
        /*System.out.println("\n\n\nPrint Pattern : ");
        printPattern();*/

    }

    private static void printPattern() {

        Integer[][] array = new Integer[10][10];
        int[] count = new int[array.length];
        for(int i=0; i<=count.length-1; i++)
        {
            count[i] = i+1;
        }

        int countn = 0;
        for(int i=0; i<=array.length-1; i++)
        {
            for(int j=0; j<=array.length-1; j++)
            {
                //to insert in format 1 0 0 0
                if(j <= i)
                {
                    //sol (a)
                    /*array[i][j] = countn;
                    countn++;*/

                    //sol (b)
                    array[i][j] = count[j];


                }else {
                    array[i][j] = 0;
                }

            }
        }

        for(int i=0; i<=array.length-1; i++)
        {
            for(int j=0; j<=array.length-1; j++)
            {
                System.out.print( array[i][j] + " " );
                if(j == array.length-1)
                {
                    System.out.print( "\n" );
                }
            }
        }

    }

    private static void convertArrayListToArray() {

        /*1) First and Major difference between Array and ArrayList in Java is that Array is a fixed length data structure
    while ArrayList is a variable length Collection class. You can not change length of Array once created in Java but ArrayList
    re-size itself when gets full depending upon capacity and load factor. Since ArrayList is internally backed by Array in Java,
    any resize operation in ArrayList will slow down performance as it involves creating new Array and copying content from old
    array to new array.

    2) Another difference between Array and ArrayList in Java is that you can not use Generics along with Array,
    as Array instance knows about what kind of type it can hold and throws ArrayStoreException,
    if you try to store type which is not convertible into type of Array. ArrayList allows you to use Generics to ensure type-safety.

    3) One more major difference between ArrayList and Array is that, you can not store primitives in ArrayList,
    it can only contain Objects. While Array can contain both primitives and Objects in Java.

    What is autoboxing and unboxing in Java

    Java automatically converts a primitive type like int into corresponding wrapper class object
    e.g. Integer than its called autoboxing  because primitive is boxed into wrapper class while in opposite case is called unboxing,
    where an Integer object is converted into primitive int. All primitive types e.g. byte, short, char, int, long, float,
    double and boolean has corresponding wrapper class e.g. Byte, Short, Integer, Character etc and participate in autoboxing and unboxing.
    Since the whole process happens automatically without writing any code for conversion its called autoboxing and auto-unboxing.


    Read more: http://javarevisited.blogspot.com/2012/07/auto-boxing-and-unboxing-in-java-be.html#ixzz4ikOe1WSN

    Read more: http://www.java67.com/2012/12/difference-between-array-vs-arraylist-java.html#ixzz4ikO930BU
    */

        /*
        *
        * converting arraylist to string array
        *
        * */

        //ArrayList containing string objects
        ArrayList aListMonth = new ArrayList();
        aListMonth.add("Jan");
        aListMonth.add("Feb");
        aListMonth.add("mar");

                /*
                 * To convert ArrayList containing String elements to String array, use
                 * Object[] toArray() method of ArrayList class.
                 */

        //First Step: convert ArrayList to an Object array.
        Object[] objMnt = aListMonth.toArray();

        //Second Step: convert Object array to String array
        String[] strMnts = Arrays.copyOf(objMnt, objMnt.length, String[].class);

        System.out.println("ArrayList converted to String array");

        //print elements of String array
        for (int i = 0; i < strMnts.length; i++) {
            System.out.println(strMnts[i]);
        }
    }

    private static void multiDcompare() {



        /*
        * multidimensional array comparison
        * */

        int[][] a1 = {{2, 4}, {4, 6}, {8, 10}};
        int[][] a2 = {{12, 14}, {14, 16}, {18, 20}};
        int[][] a3 = {{2, 4}, {4, 6}, {8, 10}};

        // checking if two multi-dimensional array of same length but different element equal or not


        boolean result = Arrays.deepEquals(a1, a2);
        System.out.println("Does two dimensional array a1 and a2 are equal : " + result);

        // checking if two multi-dimensional array of same length, elements equal or not
        result = Arrays.deepEquals(a1, a3);
        System.out.println("Does two dimensional array a1 and a3 are equal : " + result);


    }

    private static void oneDcompare() {

         /*
        * one dimensional array comparison
        * */
        //print array type and its hashcode : [I@1693b52b

        int[] arrayOfInts = new int[]{101, 102, 103, 104, 105};
        System.out.println(arrayOfInts);

        short[] arrayOfShorts = new short[]{20, 30, 40, 50, 60};
        System.out.println(arrayOfShorts);

        float[] arrayOfFloats = new float[]{2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
        System.out.println(arrayOfFloats);

        // type of two dimensional array in Java

        int[][] arrayOfArrayOfInts = {{1, 2, 3}, {10, 20, 30}, {100, 200, 300}};
        System.out.println(arrayOfArrayOfInts);

        double[][] arrayOfArrayOfDoubles = {{2.0, 3.0}, {4.0, 5.0}};
        System.out.println(arrayOfArrayOfDoubles);


        //use ArrayTypesComparison.equals(arr1, arr2) for comparing two arrays
        //arr1.equals(arr2) will work as a reference checker in case of array

        String[] cities = new String[]{"London", "Paris", "NewYork", "HongKong", "Tokyo"};
        String[] metros = new String[]{"London", "Paris", "NewYork", "HongKong", "Tokyo"};
        String[] capitals = cities;

        // comparing array using == operator
        System.out.println("cities == metros : " + (cities == metros));  //false
        System.out.println("cities == capitals : " + (cities == capitals)); //true

        // comparing array using equals() method
        System.out.println("cities.equals(metros) : " + cities.equals(metros)); //false reference comparison
        System.out.println("cities.equals(capitals) : " + cities.equals(capitals)); //true

        // comparing array using ArrayTypesComparison.equals() method
        System.out.println("ArrayTypesComparison.equals(cities, metros) : " + Arrays.equals(cities, metros)); //true
        System.out.println("ArrayTypesComparison.equals(cities, capitals) : " + Arrays.equals(cities, capitals)); //true


    }

}
