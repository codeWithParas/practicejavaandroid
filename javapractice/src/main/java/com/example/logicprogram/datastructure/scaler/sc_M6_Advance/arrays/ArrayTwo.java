package com.example.logicprogram.datastructure.scaler.sc_M6_Advance.arrays;


/*
 * Agenda :
 * 0) Find sum of all sub-matrix sum.
 * 1) Calculate prefix sum of 2-D Matrix
 * 2) Calculate sub matrix sum of queries
 * 3) Max sub-matrix sum (when row and col wise we have sorted matrix)
 *
 * */


public class ArrayTwo {

    public static int[][] twoDiamensionalArray = {
            {8, 9, 9, 1, 7},
            {5, 5, 10, 1, 0},
            {7, 7, 5, 8, 6},
            {7, 3, 7, 9, 2},
            {7, 7, 8, 10, 6}
    };

    public static void main(String[] args) {

        //0) Given mat[m][n], find sum of all sub-matrix sum.
        /*
         * Idea : Contribution of every element = frequency * mat[i][j]
         * */

        //1) Calculate prefix sum of 2-D Matrix
        /*
         * Idea : 2D Array A is given.
         * Step 1 : First calculate the horizontal prefix sum of array A. And store all values in hSumA[][] or in same array itself.
         * Step 2 : For hSumA[][] Calculate prefix sum vertically.
         * Step 3 : Add all prefix sum values of hSumA[][] and return the result.
         * */
        int sum = getPrefixSumOf2DArray(twoDiamensionalArray);

    }


    private static int getPrefixSumOf2DArray(int[][] arr) {

        int sum = 0;
        int[][] hSum = new int[arr.length][arr[0].length];

        //Horizontal Prefix Max Calculation
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                hSum[i][j] = sum;
            }
        }

        sum = 0;

        //Vertical Prefix Max Calculation
        for (int j = 0; j < hSum[0].length; j++) {
            sum = 0;
            for (int i = 0; i < hSum.length; i++) {
                sum += hSum[i][j];
                hSum[i][j] = sum;
            }
        }

        sum = 0;

        // Add all hSum
        for (int i = 0; i < hSum.length; i++) {
            for (int j = 0; j < hSum[i].length; j++) {
                sum += hSum[i][j];
            }
        }

        System.out.println("Prefix Sum of 2D Matrix : " + sum);

        return sum;
    }


}
