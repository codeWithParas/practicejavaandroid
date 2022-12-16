package com.example.logicprogram.datastructure.scaler.sc_M6_Advance.arrays;


/*
 * Agenda :
 * 1) Prefix recap
 * 2) Continous Sum Query
 * 3) Rain water trapped
 * 4) Max sub-array sum
 * */
public class ArrayOne {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 5, 1};
        int maxSubArraySum = maxSubArraySum(arr, arr.length);

        System.out.println("Max Sub Array Sum : " + maxSubArraySum);
    }

    //4) Max sub-array sum
    public static int maxSubArraySum(int[] arr, int n) {

        //Using brute force
        /*
         * Step 1 : Create every sub-array using nested loop
         * Step 2 : Calculate sum of each sub array.
         * Step 3 : Check if(sum of sub-array > ans)
         * Step 4 : If above case is true the assign sum of sub-array to ans.
         * */

        // 3 2 4 6 5 1

        int sum = arr[0];
        int ans = sum;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                sum = sum + arr[j];
                if (sum > ans) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
