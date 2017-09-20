package com.example.logicprogram.stringplay;

/**
 * Created by parasmani.sharma on 02/08/2017.
 */

public class PrintDuplicateChars {

    public static final int NO_OF_CHARS = 256;
    int i;

    public static void main(String arg[]) {
        String value = "aapp";
        printDups(value);

    }

    private static void printDups(String value) {
        //create an array of size 256 and fill count of every character in it.
        int countArr[] = new int[NO_OF_CHARS];

        //calling method for fillCharCounts
        for (int i = 0; i < value.length(); i++) {
            countArr[value.charAt(i)]++;
        }


        for (int i = 0; i < NO_OF_CHARS; i++) {

            if (countArr[i] > 1) {
                System.out.printf("%c,  Count = %d \n", i, countArr[i]);
            }

        }

    }
}