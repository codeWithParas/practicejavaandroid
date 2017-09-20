package com.example.logicprogram.stringplay;

/**
 * Created by parasmani.sharma on 04/07/2017.
 */

public class aSubString {

    /*A part of string is called substring. In other words, substring is a subset of another string.
    In case of substring startIndex is inclusive and endIndex is exclusive.*/

    public static void main(String args[])
    {
        String s="hello";
        System.out.println(s.substring(0,2));//he //0:inclusive, 2:exclusive
        System.out.println(s.substring(2));//llo  //2:inclusive
    }

}
