package com.example.logicprogram.java_string_operation;

import java.util.Scanner;

/**
 * Created by parasmani.sharma on 20/05/2017.
 */

public class cReverseString {

    public static void main(String a[]){


        System.out.print("Enter your name :");
        Scanner scan = new Scanner(System.in);
        String string = scan.next();

        //1) using string buffer and string builder
        //reverseUsingBuffer(string);

        //2) withought using string buffer and string builder
        reverseIteratively(string);

        //3) withought using for loop
        String str = reverseRecursively(string);
        System.out.println("\n\nReverse String using Recursive Method  : "+str.toString());

    }

    private static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }

    private static void reverseUsingBuffer(String string) {

        char[] chars = new char[string.length()];
        StringBuffer obj = new StringBuffer(string);
        obj.reverse();
        System.out.println("Reverese String : "+obj.toString());
    }

    private static void reverseIteratively(String string) {

        if(string == null || string.isEmpty())
            return;

        String str = "";
        for(int i = string.length()-1; i>=0; i--)
        {
            str = str + String.valueOf(string.charAt(i));
        }

        System.out.print("\n\nReversed String Withought Buffer : "+str);

    }

}
