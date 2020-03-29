package com.example.logicprogram.otherproblems;

public class ShiftOperation {

    public static void main(String arg[])
    {
        //mid : 00300001 , vid : 48
        //(vid << 16) | mid

        int i = (48 << 16) | 0x0001;
        System.out.println("Print : " + i);

    }
}
