package com.example.logicprogram.datastructure.scaler.sc_M4_Intermediate.scM4_3_Arrays;

public class M4L7_SubArrays {

    /*
     * Points to cover overall
     *
     * Question 1 : Print all sub arrays. O(n^3)
     *
     * Question 2 : Calculate sum of all sub-arrays
     * Approach 1 : Brute Force -> O(n^2)
     * Approach 2 : Prefix Sum -> O(n^2)
     * Approach 3 : Brute Force -> O(n^3)
     *
     * */

    /*
     * Ques 1 : Given an array of size 21, find the total number of subarrays of the array.
     * Ans : n(n+1)/2 : (21*22)/2 = 231
     *
     * */

    public static void main(String[] args) {

        /*
         * Question 1 : Using Brute Force O(n^3)
         * 1) Print all sub arrays.
         * 2) their individual sum.
         * 2) All sub-array sum.
         */
        //int[] arr = {2, 1, 3, 2, 1, 2};
        int[] arr = {2, 1, 2, 3, 2};
        sumUsingBruteForce(arr);


        /*
         * Question 1 : Using Prefix Sum O(n^2)
         * 1) Printing sum of each subarray.
         * 2) All sub-array sum.
         */
        sumUsingPrefixSum(arr);   // O(n^2)


        /*
         * Question 1 : Using More Better Approach O(n)
         */
        sumUsingBetterApproach(arr);   // O(n)
    }

    public static void sumUsingBruteForce(int[] arr) {

        int totalSubArraySum = 0;
        for (int i = 0; i < arr.length; i++) {          // decide starting point
            for (int j = i; j < arr.length; j++) {      // decide the range or end point
                int subArraySum = 0;
                // Range Part
                for (int k = i; k <= j; k++) {          // iterate over range (i->j)
                    subArraySum += arr[k];
                    //System.out.println(arr[k]);
                }
                System.out.println("Sub Array Sum : " + subArraySum);
                totalSubArraySum += subArraySum;
            }
        }
        System.out.println("\nTotalSubArraySum Using Brute Force : " + totalSubArraySum);
    }

    public static void sumUsingPrefixSum(int[] arr) {

        int totalSubArraySum = 0;
        int[] pSumArray = new int[arr.length];
        pSumArray[0] = arr[0];

        // Create Prefix Sum Array
        for (int i = 1; i < arr.length; i++) {
            pSumArray[i] = pSumArray[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int subArraySum = 0;
                if (i == 0) {
                    subArraySum = pSumArray[j];
                } else {
                    // Range Part replaced by prefix sum
                    subArraySum = pSumArray[j] - pSumArray[i - 1];
                }
                System.out.println("SubArraySum = " + subArraySum);
                totalSubArraySum += subArraySum;
            }
        }
        System.out.println("TotalSubArraySum Using Prefix Sum = " + totalSubArraySum);
    }


    public static void sumUsingBetterApproach(int[] arr) {

        int totalSubArraySum = 0;
        int[] pSumArray = new int[arr.length];
        pSumArray[0] = arr[0];

        // Create Prefix Sum Array
        for (int i = 1; i < arr.length; i++) {
            pSumArray[i] = pSumArray[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int subArraySum = 0;
                if (i == 0) {
                    subArraySum = pSumArray[j];
                } else {
                    // Range Part replaced by prefix sum
                    subArraySum = pSumArray[j] - pSumArray[i - 1];
                }
                System.out.println("SubArraySum = " + subArraySum);
                totalSubArraySum += subArraySum;
            }
        }
        System.out.println("TotalSubArraySum Using Prefix Sum = " + totalSubArraySum);
    }


}










