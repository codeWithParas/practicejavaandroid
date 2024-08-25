package com.example.logicprogram.datastructure.scaler.sc_M4_Intermediate.scM4_3_Arrays;


/*
 * Agenda : Problem Types
 * 1) Count of Pairs with 2 given Chars. Brute Force - O(n^2). [Optimised : Do it in O(n)]
 * 2) Leaders in an array.
 * 3) Basics of Sub-array.
 * 4) Min-max of sub-array length.
 *
 * */
public class M4L6_ArrayCarryForward {

    public static void main(String[] args) {


        /*
         * 1) Count of Pairs with 2 given Chars. Brute Force - O(n^2). [Optimised : Do it in O(n)]
         * Question : Given a Char arr, count no of pairs of i,j such that i<j and arr[i]='a' and arr[j]='g'.
         * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
         *
         * Hint Help : When question is having very long array. Then reduce its count value by using modulo.
         * Explanation : Modulo gives remainder as a answer and by definition reminder of a number when divided by x is always
         * between 0 and x-1. So final answer will be between 0 and 10^9+6.
         * Or directly Change return statement to return ans%1000000007
         * */
        char[] arr = {'a', 'd', 'g', 'a', 'g', 'a', 'g', 'f', 'g'};
        String str = "adgagagfg";
        //String str = "aaaaaa";
        int count = countPairs(str); // Optimised approach : Using Prefix Sum (right to left)
        System.out.println("countPairs of 'ag' = " + count);
        //int count = solveCountPairs(str);  // Using left to right
        //System.out.println("\nModulo = " + (int)Math.pow(10,9)+7);    // Understand this : Used when answer is very long.




        /*
         * 2) Count leaders in an array.
         * Leaders : An element is leader if it is greater than all elements on its right.
         * Note : element arr[n-1] is always a leader.
         * */
        //int[] arrL = {2,8,5,4,3,6,3,1,2};
        int[] arrL = {93, 57, 83, 41, 100, 10, 79, 27, 94, 22, 4, 96, 48, 18, 89, 37, 21, 5, 46, 81, 15, 30, 47, 23, 34, 65, 55, 9, 36, 20, 54, 17, 7, 56, 78, 84, 87, 97, 16, 69, 28, 11, 44, 49, 8, 25, 98, 75, 53, 62, 19, 24, 80, 68, 50, 91, 1, 86, 77, 14, 72, 66, 42, 63, 73, 45, 31, 61, 85, 64, 35, 32, 92, 71, 74, 3, 99, 52, 90, 43, 6, 40, 38, 2, 12, 59, 29, 82, 76, 60, 67, 13, 70, 58, 39, 33, 95, 88, 51, 26};
        int countLeaders = getLeadersCount(arrL);
        System.out.println("\ncountLeaders = " + countLeaders);


        /*
         * 4) Calculate smallest sub-array that has Min-max of sub-array.
         * */

    }

    private static int getLeadersCount(int[] arrL) {
        // Idea iterate from right to left -> Keep track of max -> compare with current element.

        int ans = 1;
        int max = arrL[arrL.length - 1];  // arr[n-1] always be an leader

        for (int i = arrL.length - 2; i >= 0; i--) {
            if (arrL[i] > max) {
                ans++;
                max = arrL[i];
            }
        }
        return ans;

        /*ArrayList ans = new ArrayList<Integer>();
        int max = 0;  // arr[n-1] always be an leader
        int count = 0;
        for (int i = A.size()-1; i >= 0; i--) {
            if(A.get(i) > max){
                //ans[count] = A[i];
                ans.add(A.get(i));
                count++;
                max = A.get(i);
            }
        }
        return  ans;*/
    }

    private static int countPairs(String str) {
        char[] arr = str.toCharArray();
        // Idea : Count prefix sum of each 'g' index in reverse order
        //int[] pSumOfG = new int[arr.length];
        int count = 0;
        int ans = 0;
        int modulo = (int) Math.pow(10, 9) + 7;    // To support hard cases
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 'g') {
                count++;
            } else if (arr[i] == 'a') {
                ans = (ans + count) % modulo;
            }
        }
        return ans;
    }

    public static int solveCountPairs(String A) {

        /*
         * Question : You have given a string A having Uppercase English letters.
         * You have to find how many times subsequence "AG" is there in the given string.
         * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.  : int m = (int)Math.pow(10,9)+7
         *
         * */

        int count = 0;
        int ag_count = 0;
        int N = A.length();
        int modulo = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < N; i++) {
            if (A.charAt(i) == 'A') {
                count++;
            }
            if (A.charAt(i) == 'G') {
                ag_count = (ag_count + count) % modulo;
            }
        }

        return ag_count;
    }
}
