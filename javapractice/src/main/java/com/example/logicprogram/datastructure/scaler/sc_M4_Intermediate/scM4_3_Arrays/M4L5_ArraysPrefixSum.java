package com.example.logicprogram.datastructure.scaler.sc_M4_Intermediate.scM4_3_Arrays;

import java.util.Arrays;

public class M4L5_ArraysPrefixSum {

    /*
     * Arrays : Prefix Sum
     * Cases :
     * 1) Background for prefix sum.
     * 2) Problems on prefix sum.
     *   1)Queries in range
     *   2)Equilibrium Index
     *   3)Even no. in ranges.
     *
     * */

    public static void main(String[] args) {

        System.out.println("\nPrefix Sum Queries");
        //Question 1
        //Prefix Sum Queries
        //int[] arr = {-3,6,2,4,5,2,8,-9,3,1};
        int[] arr = {1, -2, 3, 4, 5};    // ans = [10, 5], queries = [[1, 4], [2, 3]]
        int[][] queries = {{1, 4}, {2, 3}};
        //prefixSumQueries(arr, queries);


        System.out.println("\nConstruct prefix sum of the array in the given array itself");
        // Question 2
        // Given an array A of N integers. Construct prefix sum of the array in the given array itself.
        //prefixSumInSameArray(arr);


        System.out.println("\nFind Equilibrium Index");
        // Question 3
        //int[] testEq = { 1, 2, 3, 7, 1, 2, 3};
        int[] testEq = {9444, -2556, 7937, 8560, -8622, 1440, -1076, 5987, 1419, 996, -6530, 4583, 8890, -9127, 8801, 9034, -1579, -4395, 1050, 6527, 5959, -1281, -8832, 1363, -9296, -3791, -1316, 4780, 5836, -706, 4650, -3278, 8168, 1329, -3756, 7923, 7291, -6320, -5414, -136, -9627, 4609, -4626, -4655, -7457, -6424, -3573, -970, -5699, 6139, -6334, 2140, -3101, 8478, 1816, -4737, -8118, 9277, 8167, -4375, 9711, -7224, -7777, 2887, -9884, 1275, -1116, -7240, 5451, -3481, 9449, 5439, -9104, 3421, 6344, 6995, 7847, 5166, 2801, 2217, 1640, -8209, -8756, 1586, 121, -908, 276, -8674, 6499, 818, 6184, -5044, 1257, -5923, 7377, 9104, 1040, 2587, -2676, -1172, -4221, -78, 3611, 4554, -4625, 7293, -8077, 1468, 7559, 9935, -7793, -1770, -9166, 3555, 3671, -7560, 9206, -4264, -3848, 2776, 3998, -5961, -8423, -1288, -527, 9968, 1847, -6388, 5042, 8210, -4318, 9107, 525, -278, -7763, 681, -9369, 7563, 5352, 7773, -8169, 3940, 7088, -1872, -5870, 7555, -3032, -2497, 4134, -2995, 3942, 9092, -7739, 6576, 3955, -5175, -9007, 5402, -6827, -3777, 6057, -150, -4567, -94, 5921, -9395, -6154, 6385, -8445, 8889, 921, -7543, -4650, 6461, -7468, -8693, 328, 1855, 7683, 495, -195, 2554, 7950, -1983, -5252, -5584, -9061, -5734, 5425, -7041, 9495, 4647, 1810, -5899, -1038, -5730, -6674, 3818, -2146, -7694, -9968, -5853, 9552, -164, 7672, 9711, -1281, 1151, -1314, -9926, 2948, -1280, 686, 1711, -624, -5462, -8864, 2365, 7361, -4694, 2877, -339, -1560, -2100, -2342};
        int i = equilibriumIndex(testEq);
        System.out.println("A = " + i);

        System.out.println("\nFind Even numbers in a range");
        // Question 3
        int[] tt = {1, 2, 3, 7, 1, 2, 3};
        int[][] queriess = {{0, 4}, {2, 5}};
        int[] evenCount = evenNumbersInRange(tt, queriess);
        System.out.println("Even numbers = " + Arrays.toString(evenCount));
    }

    private static int[] evenNumbersInRange(int[] tt, int[][] queriess) {

        int[] pSumEven = prefixSumEven(tt);
        int[] evenCount = new int[queriess.length];

        for (int i = 0; i < queriess.length; i++) {
            int leftIndex = queriess[i][0];
            int rightIndex = queriess[i][1];
            if (leftIndex - 1 < 0) {
                evenCount[i] = pSumEven[rightIndex];
            } else {
                evenCount[i] = pSumEven[rightIndex] - pSumEven[leftIndex - 1];
            }

        }
        return evenCount;
    }

    private static int[] prefixSumEven(int[] arr) {

        int[] pSum = new int[arr.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
            pSum[i] = count;
        }

        System.out.println("prefixSumEven = " + Arrays.toString(pSum));
        return pSum;
    }

    public static int equilibriumIndex(int[] A) {

        long[] pSum = prefixSum(A);
        long[] sSum = suffixSum(A);

        for (int i = 0; i < pSum.length; i++) {
            for (int j = i; j < sSum.length; j++) {
                if (pSum[i] == sSum[j]) {
                    System.out.println("pSum[i] = " + i + "    sSum[j] = " + j);
                    System.out.println("pSum[i] = " + pSum[i] + "    sSum[j] = " + sSum[j]);
                }
            }
        }

        int eqIndex = -1;

        for (int i = 0; i < A.length; i++) {
            if (i == 0 && sSum[i + 1] == 0) {
                return i;
            } else if (i == A.length - 1 && pSum[i - 1] == 0) {
                return i;
            } else if (i > 0 && i < A.length - 1 && pSum[i - 1] == sSum[i + 1]) {
                return i;
            }
        }
        return eqIndex;
    }

    private static long[] prefixSum(int[] arr) {

        long[] pSum = new long[arr.length];
        pSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            pSum[i] = pSum[i - 1] + arr[i];
        }

        System.out.println("prefixSum = " + Arrays.toString(pSum));
        return pSum;
    }

    private static long[] suffixSum(int[] arr) {

        long[] suffixSum = new long[arr.length];
        suffixSum[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }
        System.out.println("suffixSum = " + Arrays.toString(suffixSum));
        return suffixSum;
    }

    private static void prefixSumInSameArray(int[] arr) {

        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sum + arr[i];
            sum = arr[i];
        }

        System.out.println("arr = " + Arrays.toString(arr));
    }

    // Ques : Given N array elements and Q queries.
    // For each query. Calculate sum of all the elements in the given range
    /*
     * given ar[10] = -3 6 2 4 5 2 8 -9 3 1
     * Queries = 6
     *   L   R
     *   4   8
     *   3   7
     *   1   3
     *   0   4
     *   6   9
     *   7   7
     * */
    public static void prefixSumQueries(int[] arr, int[][] queries) {

        long[] pSum = getPrefixSum(arr);
        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int leftIndex = queries[i][0] - 1;    // ex : If query value is 4 then index is 4-1 = 3
            int rightIndex = queries[i][1] - 1;
            if (leftIndex - 1 < 0) {
                ans[i] = pSum[rightIndex];
            } else {
                ans[i] = pSum[rightIndex] - pSum[leftIndex - 1];
            }
        }

        System.out.println("ans = " + Arrays.toString(ans) + ", queries = " + Arrays.deepToString(queries));
    }

    private static long[] getPrefixSum(int[] arr) {
        long[] pSum = new long[arr.length];
        pSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            pSum[i] = pSum[i - 1] + arr[i];
        }

        return pSum;
    }
}
