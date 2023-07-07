package com.example.logicprogram.datastructure.scaler.sc_M2_Beginner;

public class TestPatternOne {

    // Inclusive Values
    // i -> [1, 10]

    // Exclusive values
    // i -> (1, 10]    ----------- here 1 is exclusive

    /*
     * Based on above we will create a simple logic (for N given range)
     * i -> [1, 10] : 1,2,3,4,5,6,7,8,9,10 : Item Count : 10-1 + 1 = 10 items
     * i -> [9, 99] : 9,10,11,12......99   : Item Count : 99-9 + 1 = 91 items
     *
     * i.e ->      ---[9------------99]------- : 99-9 + 1(include 9th item)
     *
     * i.e -> Item Count = R - L + 1
     *
     * */

    public static void main(String[] args) {

        /*
         Print Pattern :
           ***
           ***
           ***
        * */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("x");
            }
            System.out.println();
        }

        /*
         Print :
           ***
           **
           *
        * */

        System.out.println();
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }

        /*
         Print :
           *
           **
           ***
        * */

        System.out.println();
        System.out.println();
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j <= 3 - i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }

        //or
        System.out.println();
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }

        /*
         Print :
           *---*
           *--*
           *-*
           *
        * */
        System.out.println();
        System.out.println();
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n + 1; j++) {
                if (j == i || j == n + 1) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }


        /*
         *
         *
         * *
         * * *
         * * * *
         * */

        System.out.println();
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int st = 1; st <= i; st++) {
                System.out.print("* ");
            }
            System.out.println();
        }



        /*
         * Write a program to input an integer N from user and print hollow inverted right triangle star pattern of N lines using '*'.
         ****
         * *
         **
         *
         *
         * */

    }


}
