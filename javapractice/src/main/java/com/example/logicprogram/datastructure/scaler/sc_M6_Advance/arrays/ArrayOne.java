package com.example.logicprogram.datastructure.scaler.sc_M6_Advance.arrays;

/*
 * Agenda :
 * 1) Prefix-Sum recap and Prefix-Max & Suffix-Max recap
 * 2) Continuous Sum Query (Google)
 * 3) Rain water trapped
 * 4) Max sub-array sum (Kadane's Algo)
 *
 * Extra Link : https://www.youtube.com/playlist?list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ
 * */
public class ArrayOne {

    //Input to test Kadane's Algo
    // Small input : int[] arrInt =  {-163}; o/p : -163
    // Small input : int[] arrInt =  {-163, -20}; o/p : -20
    // Large input (494 elements) = o/p : 217
    static int[] A = {
            -120, -202, -293, -60, -261, -67, 10, 82, -334, -393, -428, -182, -138, -167, -465, -347, -39, -51, -61, -491, -216, -36, -281, -361, -271, -368, -122, -114, -53,
            -488, -327, -182, -221, -381, -431, -161, -59, -494, -406, -298, -268, -425, -88, -320, -371, -5, 36, 89, -194, -140, -278, -65, -38, -144, -407, -235, -426, -219, 62, -299, 1,
            -454, -247, -146, 24, 2, -59, -389, -77, -19, -311, 18, -442, -186, -334, 41, -84, 21, -100, 65, -491, 94, -346, -412, -371, 89, -56, -365, -249, -454, -226, -473, 91, -412, -30,
            -248, -36, -95, -395, -74, -432, 47, -259, -474, -409, -429, -215, -102, -63, 80, 65, 63, -452, -462, -449, 87, -319, -156, -82, 30, -102, 68, -472, -463, -212, -267, -302, -471,
            -245, -165, 43, -288, -379, -243, 35, -288, 62, 23, -444, -91, -24, -110, -28, -305, -81, -169, -348, -184, 79, -262, 13, -459, -345, 70, -24, -343, -308, -123, -310, -239, 83, -127,
            -482, -179, -11, -60, 35, -107, -389, -427, -210, -238, -184, 90, -211, -250, -147, -272, 43, -99, 87, -267, -270, -432, -272, -26, -327, -409, -353, -475, -210, -14, -145, -164, -300,
            -327, -138, -408, -421, -26, -375, -263, 7, -201, -22, -402, -241, 67, -334, -452, -367, -284, -95, -122, -444, -456, -152, 25, 21, 61, -320, -87, 98, 16, -124, -299, -415, -273, -200,
            -146, -437, -457, 75, 84, -233, -54, -292, -319, -99, -28, -97, -435, -479, -255, -234, -447, -157, 82, -450, 86, -478, -58, 9, -500, -87, 29, -286, -378, -466, 88, -366, -425, -38, -134,
            -184, 32, -13, -263, -371, -246, 33, -41, -192, -14, -311, -478, -374, -186, -353, -334, -265, -169, -418, 63, 77, 77, -197, -211, -276, -190, -68, -184, -185, -235, -31, -465, -297, -277,
            -456, -181, -219, -329, 40, -341, -476, 28, -313, -78, -165, -310, -496, -450, -318, -483, -22, -84, 83, -185, -140, -62, -114, -141, -189, -395, -63, -359, 26, -318, 86, -449, -419, -2, 81,
            -326, -339, -56, -123, 10, -463, 41, -458, -409, -314, -125, -495, -256, -388, 75, 40, -37, -449, -485, -487, -376, -262, 57, -321, -364, -246, -330, -36, -473, -482, -94, -63, -414, -159,
            -200, -13, -405, -268, -455, -293, -298, -416, -222, -207, -473, -377, -167, 56, -488, -447, -206, -215, -176, 76, -304, -163, -28, -210, -18, -484, 45, 10, 79, -441, -197, -16, -145, -422,
            -124, 79, -464, -60, -214, -457, -400, -36, 47, 8, -151, -489, -327, 85, -297, -395, -258, -31, -56, -500, -61, -18, -474, -426, -162, -79, 25, -361, -88, -241, -225, -367, -440, -200, 38,
            -248, -429, -284, -23, 19, -220, -105, -81, -269, -488, -204, -28, -138, 39, -389, 40, -263, -297, -400, -158, -310, -270, -107, -336, -164, 36, 11, -192, -359, -136, -230, -410, -66, 67,
            -396, -146, -158, -264, -13, -15, -425, 58, -25, -241, 85, -82, -49, -150, -37, -493, -284, -107, 93, -183, -60, -261, -310, -380
    };

    //Test Input  : A : [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ] o/p : 6

    public static void main(String[] args) {

        //1) Prefix-Max & Suffix-Max recap
        /*
         * Ex : Prefix-Max Example
         * arr[] = 2 1 3 2 1 2 4 3 2 1 3 1
         * pMax  = 2 2 3 3 3 3 4 4 4 4 4 4
         *
         * Ex : Suffix-Max Example (Reverse order)
         * arr[] = 2 1 3 2 1 2 4 3 2 1 3 1
         * sMax  = 4 4 4 4 4 4 4 3 3 3 3 1
         * */

        // 2) Continuous Sum Query (Google) --------------------- Devotee Begger Temple Problem -----------------------------------------------
        //Example Input : A = 5  ,   B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
        //Output : [10, 55, 45, 25, 25]
        int[] devoteeOneGives = {1, 2, 10};
        int[] devoteeTwoGives = {2, 3, 20};
        int[] devoteeThreeGives = {2, 5, 25};
        int[][] devoteeGives = new int[3][];
        devoteeGives[0] = devoteeOneGives;
        devoteeGives[1] = devoteeTwoGives;
        devoteeGives[2] = devoteeThreeGives;
        int[] allBeggersAmount = beggerDevoteeProblem(5, devoteeGives);
        for (int j : allBeggersAmount) {
            System.out.println("Begger Amount " + j);
        }

        // 3) Rain water trapped (Using Prefix Max and Suffix Max)
        /*
         * Idea : Iterate for each index (i)
         * Step 1 : ---------------leftBlock = Prefix Max(pMax)-----------------> ith index <------------------rightBlock = Sufix Max (sMax)------------------------
         * Step 2 : maxWaterCanHold = calculate min(pMax, sMax)
         * Step 3 : exactWaterCanHold = minWaterCanHold - arr[ith index]
         *
         *
         * */


        //4) Max sub-array sum (Kadane's Algo) ------------------------------ Kadane's Algo (Find Max Sum Sub-array)-----------------------------------
        System.out.println("\n\n");
        //String[] arr = {"a","b","c","d","e","f"};
        //int[] arrInt = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] arrInt = {2,4,-6,5,3,1};
        //int[] arrInt =  {-163, -20};
        //int[] arrInt =  {-163};
        /*a, ab, abc, abcd, abcde, abcdef
        b, bc, bcd, bcde, bcdef
        c, cd, cde, cdef
        d, de, def
        e, ef
        f*/
        //Using Brute Force : O(n*n)
        //printAllSubArrays(arr);
        //sumAllSubArrays(arrInt);
        //findMaxSumAllSubArrays(arrInt);


        /*
         * Using Kadane's Algo : O(n)
         *
         * Step 1 : Start with assigning : Sum = A[i] and ans = A[i].
         *
         * Step 2 : Iterate next element. If next number is positive.
         *          Step 2.1 : Check if previous step (sum is -neg) && (next number > sum). Then restart sum = 0.
         *
         * Step 3 : Iterate next element. If next number is -neg.
         *          Step 2.1 : Check if previous step sum is -neg. If -neg then make restart sum = 0.
         *
         * Step 4 : Then assign : sum = sum + A[i];
         * Step 5 : Calculate max : ans = Math.max(sum, ans);
         *
         * Handle Edge Cases :
         * 1) {-163}
         * 2) {-163, -20}
         *
         * */
        findMaxSumUsingKadane(A);
        System.out.println("\n\n");
    }

    public static void printAllSubArrays(String[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str = arr[i];
            System.out.print(str + ", ");
            for (int j = i + 1; j < arr.length; j++) {
                str = str + arr[j];
                System.out.print(str + ", ");
            }
            System.out.println();
        }
    }

    //int[] arrInt = {2,4,-6,5,3,1};
    public static void sumAllSubArrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            System.out.print(sum + ", ");
            for (int j = i + 1; j < arr.length; j++) {
                sum = sum + arr[j];
                System.out.print(sum + ", ");
            }
            System.out.println();
        }
    }

    public static void findMaxSumAllSubArrays(int[] arr) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            System.out.print(sum + ", ");
            for (int j = i + 1; j < arr.length; j++) {
                sum = sum + arr[j];
                System.out.print(sum + ", ");

                if (sum > ans) {
                    ans = sum;
                }
            }
            System.out.println();
        }

        System.out.print("Maximum Sum " + ans);
    }

    // Using Kadane's Algo
    public static void findMaxSumUsingKadane(int[] A) {
        int sum = A[0];
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) {
                // Handle case like : {-163, -20}
                if (sum < 0 && A[i] > sum) {
                    sum = 0;
                }
            } else if (A[i] > 0) {
                // Case when A[i] is positive
                // Check if sum is -neg then -> Restart sum = 0
                if (sum < 0) {
                    sum = 0;
                }
            }
            sum = sum + A[i];
            ans = Math.max(sum, ans);
        }
        System.out.print("Maximum Sum " + ans);
    }

    /*
     * Problem Explanation
     * First devotee donated 10 coins to beggars(A) ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
     * Second devotee donated 20 coins to beggars(A) ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
     * Third devotee donated 25 coins to beggars(A) ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
     *
     * Example Input : A = 5  ,   B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
     * Output : [10, 55, 45, 25, 25]
     * */
    //Continuous Sum Query
    public static int[] beggerDevoteeProblem(int A, int[][] B) {

        int[] a = new int[A];

        for (int i = 0; i < B.length; i++) {

            int sIndex = B[i][0] - 1;
            int eIndex = B[i][1] - 1;
            int amountValue = B[i][2];

            a[sIndex] += amountValue;

            if (eIndex + 1 < A) {
                a[eIndex + 1] += (-amountValue);
            }
        }

        // Calculate Prefix sum of array
        return calculatePrefixSum(a);
    }

    public static int[] calculatePrefixSum(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            arr[i] = sum;
        }

        return arr;
    }


}
