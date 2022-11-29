package com.example.logicprogram.datastructure.scaler.sc_M5;

public class M5L5_Recursion1 {

    public static void main(String[] args) {

        //show(5);
        fib(5);
    }

    // Print all numbers till n in increment order
    public static int show(int n) {

        if (n == 1) {
            return 1;
        }
        return show(n - 1);
        //System.out.println(n);
    }

    public static int fib(int n) {

        System.out.println(n);
        if (n == 0) {
            return 0;
        }
        return fib(n - 2) + fib(n - 1);
    }
}
