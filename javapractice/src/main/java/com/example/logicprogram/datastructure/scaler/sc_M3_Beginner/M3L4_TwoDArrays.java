package com.example.logicprogram.datastructure.scaler.sc_M3_Beginner;

import java.util.Arrays;
import java.util.Scanner;

public class M3L4_TwoDArrays {

    /*
     * Agenda
     * 1) Questions on 1D Arrays
     * ----> Know About Dynamic Programming
     * 2) Intro to 2D Arrays -> Representation, Input/Output
     * 3) Questions on 2D Arrays
     *
     * */

    public static void main(String[] args) {

        System.out.println("------------- Problem 1 ---------------- ");
        int[] x = {1, 2, 3, 4, 5};

        /*
         * 1) Write a fn that returns Sum of array of the above given array.
         * Hint :
         *        sum[n] = sum[n-1] + A[n]
         *
         * General solution may use 2 loops. Bad approach.
         * Using Dynamic Programming Approach ? :- Use Only Single Loop
         *
         * ************ VERY IMPORTANT ***************
         * Dynamic Programing : Try to form some type of mathematical formula for a problem. And use this formula in coding. Basically doing this,
         * we are trying to reduce the number of loops or minimize internal code cases so that program looks more meaningful and defined.
         * This is called dynamic programing.
         * *******************************************
         *
         * So here we are going to form a formula of Sum.
         * i.e - sum[n] = sum[n-1] + A[n]
         * This formula technically called as "Prefix Sum" formula.
         *
         * */
        int[] sum = new int[x.length];
        sum[0] = x[0];
        for (int i = 1; i < x.length; i++) {
            sum[i] = sum[i - 1] + x[i];
        }
        System.out.println("Sum of Array : " + Arrays.toString(sum));


        System.out.println("------------- Problem 2 ---------------- ");
        int[] a = {3, 5, 2, 4, 8, 6, 1};
        int k = 7;
        /*
         * 2) Given an array and a value k. Write a function that returns true if there exist a pair
         *   A[i], A[j],  such that -> (A[i] + A[j] = k) and (i != j)
         *
         * General solution : Using two loops. We know it already. Can we optimize ?
         *
         * */

        /*
         * Pairs :
         *   (3,5) (3,2) (3,4) (3,8) (3,6) (3,1)
         *   (5,3) (5,2) (5,4) (5,8) (5,6) (5,1)
         *   (2,3) (2,5) (2,4) (2,8) (2,6) (2,1)
         *   (4,3) (4,5) (4,2) (4,8) (4,6) (4,1)
         *   (8,3) (8,5) (8,2) (8,4) (8,6) (8,1)
         *   (6,3) (6,5) (6,2) (6,4) (6,8) (6,1)
         *   (1,3) (1,5) (1,2) (1,4) (1,8) (1,6)
         *
         * Half of the cases are repeating which are not require to run for repeating cases.
         * i.e ->
         *   (3,5) (3,2) (3,4) (3,8) (3,6) (3,1)
         *         (5,2) (5,4) (5,8) (5,6) (5,1)
         *               (2,4) (2,8) (2,6) (2,1)
         *                     (4,8) (4,6) (4,1)
         *                           (8,6) (8,1)
         *                                 (6,1)
         *
         * i.e -> for
         *           i=0, j : 1 to 6
         *           i=1, j : 2 to 6
         *           i=2, j : 3 to 6
         * Conclusion -> for any value of i --- j is always i+1
         * How to solve ?
         * */

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    // true
                }
            }
        }

        System.out.println("------------- Problem 3 : 2D Array---------------- ");
        /*
         * Create a 2D array matrix.
         *   0 1 2
         *   1 2 3
         * */
        int[][] twoD = new int[2][3];
        for (int i = 0; i < twoD.length; i++) { //rows
            for (int j = 0; j < twoD[0].length; j++) {  //cols
                twoD[i][j] = i + j;
                System.out.print(twoD[i][j] + " ");
            }
            System.out.println(" ");
            //System.out.println("Row : " + i + "   "+ Arrays.toString(twoD[i]));
        }

        /*
         * Given a 2D array. Write a fn that returns a transpose of that array.
         * i.e -> (N*M) becomes (M*N)
         * */
        System.out.println("---Inverted or transpose---");
        for (int i = 0; i < twoD[0].length; i++) { //cols
            for (int j = 0; j < twoD.length; j++) {  //rows
                System.out.print(twoD[j][i] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("------------- Problem 4 : 2D Array Print Wave (column wise)---------------- ");

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int mat[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        // Iterating over the columns
        for (int col = 0; col < n; col++) {
            // Iterating over rows
            for (int row = 0; row < n; row++) {
                if ((col % 2) == 1) {
                    System.out.print(mat[n - 1 - row][col]);
                } else {
                    System.out.print(mat[row][col]);
                }
                System.out.print(' ');
            }
        }

        System.out.println();
        sc.close();

    }
}
