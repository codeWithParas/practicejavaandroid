package com.example.logicprogram.datastructure.scaler.sc_M5_Intermediate;


import java.util.ArrayList;
import java.util.Arrays;

public class M5L1_Sorting {
    public static void main(String[] args) {

        // Test Bubble Sort
        //int[] array = {21,23,34,32,1,3,8,2,5,9};
        int[] array = {1,3,8,2,5};
        int[] arr = bubbleSort(array, "decr");
        System.out.println("Decreasing Order");
        for (int k : arr) {
            System.out.println("Element : " + k);
        }

        // Test Minimum Cost : Element Removal
        int[] ar = {8,0,10};
        int minCost = elementRemoval(ar);
        System.out.println("\nminCost : " + minCost);

        // Test Novel Integer : For count value of greater number then P.
        //int[] a = {-3,0,2,5};
        int[] a = {-2, 8, 8, 6, -2, 3, -2, -7, 3, 3, -2, 0, 4, -3, -4, -2, -1, -10, -4, -2, 7, -1, 0, -7, 3, -7, 7, 3, 2, -4, -5, 2, 6, 5, -2, 7, -1, 6, -10, 4, -9, -10, -6, -2, -3, 0, -2, 6, -8, 4, 7, 9, -7, 9, -8, -2, -7, -10, -9, -3, 8, 9, 1, 5, 4, 9, 2, 5, -3, -6, -1, -1, -6};
        int nobleCount = nobleIntCount(a);
        System.out.println("\nNoble Int Count : " + nobleCount);

        // Sort to distinct factors
        System.out.println("Sort Distinct ");
        int[] aarr = {46, 17, 10, 13, 40, 40, 3, 20};
        int[] sortDistinct = sortDistinctFactors(aarr);
        for (int j : sortDistinct) {
            System.out.print("   " + j);
        }

        System.out.println("\n\nCustom Comparator Example");
        /*
         * Custom Comparator Example
         * */
        //int [] intList = { 46, 17, 10, 13, 40, 40, 3, 20 };
        int[] intList = {8, 89};
        //int [] intList = { 3, 30, 34, 5, 9 };    // Output : 9534330
        String ans = largestNumber(intList);
        System.out.println("Largest Number   " + ans);
    }

    public static String largestNumber(final int[] A) {

        // Convert to integer array
        Integer[] arr = new Integer[A.length];
        int c = 0;
        boolean isNumber = false;
        for (int value : A) {
            if (value != 0) {
                isNumber = true;
            }
            arr[c] = value;
            c++;
        }

        if (!isNumber) {
            return "0";
        }

        Arrays.sort(arr, (a, b) -> customCompare(a, b));

        StringBuilder strBuilder = new StringBuilder();
        for (Integer integer : arr) {
            strBuilder.append(integer);
        }

        return strBuilder.toString();
    }

    private static int customCompare(Integer k1, Integer k2) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        str1.append(k1);
        str1.append(k2);
        str2.append(k2);
        str2.append(k1);
        //StringBuilder str2 = new StringBuilder(k2);
        long joinFirst = Long.parseLong(str1.toString());
        long joinSecond = Long.parseLong(str2.toString());

        if (joinFirst < joinSecond) {
            return 1;
        }
        if (joinFirst > joinSecond) {
            return -1;
        }
        return 0;
    }

    //Ques : Find minimum cost to remove all elements in an array.
    /*
     * Topic :  Elements Removal Algorithm
     *
     * Given N elements at every step remove an array element
     * Hint : cost to remove an element = sum of array elements present in array
     * Ques : Find min cost to remove all elements ?
     *
    * Observation : Deleting elements in decreasing order to get min cost.
     * Ex : ar[4] = {a b c d}
     *                       cost
     *       remove a ---- a+b+c+d
     *       remove b ---- b+c+d
     *       remove c ---- c+d
     *       remove d ---- d
     * Total min cost : (a+2b+3c+4d) = ar[i]*(i+1)
     *
     * Code :
     *       int minCost(int[] ar) {
     *
     *         sort(ar, desc) ---> arrange in decreasing order
     *           int minCost = 0;
     *           for(int i=0; i<n; i++){
     *               minCost = minCost + ar[i]*(i+1)
     *           }
     *           return minCost;
     *       }
     * TC : O(nlogn + n) = O(nlogn)
     * sc : O(1)
     * */

    public static int elementRemoval(int[] A) {
        int[] ar = bubbleSort(A, "decr");
        int minCost = 0;

        for(int i = 0; i<ar.length; i++){
            minCost = minCost + ar[i]*(i+1);
        }

        return minCost;
    }


    // Ques : Noble Integers { whn data is distinct}
    /*
    * Given an array of M elements calculate no of noble integers.
    *
    * Hint : An element ar[i] is said to be Noble if
    * { (count of elements < ar[i]) = ar[i] itself }
    *
    * Ex 1  : {-1,-5,  3,  5, -10, 4}
    * Count :  2   1   3   5   0   4
    * Ans : Count Value is 3 (i.e -> 3,5 and 4)
    *
    * Ex 2  : {-3, 0,  2,   5}
    * Count :  0   1   2   3
    * Ans : Count value is 1 (i.e -> only 2)
    *
    * Code : Brute Force : For every element traverse the whole array and find count of elements less then element itself.
    * Can we do better ? ---> Using sorting
    * So i-index become count of elements itself.
    * Code :
    *       int nobleCount(int[] ar) {
    *           sort(ar, inc) ---> arrange in increasing order
    *           int nobleCount = 0;
    *           for(int i=0; i<n; i++){
    *               if(ar[i] == i) {
    *                   nobleCount++;
    *               }
    *           }
    *           return nobleCount;
    *       }
    * TC : O(nlogn + n) = O(nlogn)
    * sc : O(1)
    *
    * */

    public static int nobleIntCount(int[] A) {
        // count of elements < p and count == p
        /*int[] ar = bubbleSort(A, "decr");
        int nobleInt = 0;
        for(int i = 0; i<ar.length; i++){
            if(ar[i] == i){
                nobleInt++;
            }
        }
        return nobleInt;*/

        Arrays.sort(A);
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            // Do not consider ith element if next element is same because next element cannot be greater than ith element
            // We need to only consider greater element value
            if (A[i] == A[i + 1])
                continue;

            //check if ith element is equal to the count of all right elements after ith position
            if (A[i] == n - i - 1)
                return A[i];
        }

        if (A[n - 1] == 0)
            return A[n - 1];

        return -1;
    }

    // Ques : Noble Integers { whn data is repeating}
    /*
    * Ex 2  : {0,  2,  2,  3,  3,  6}
    * Count :  0   1   1   3   3   5
    * Ans : Count value is 3 (i.e -> 0, 3, 3)
    *
    * Code :
    *       int nobleCount(int[] ar) {
    *           sort(ar, inc) ---> arrange in increasing order
    *           int nobleCount = 0;
    *           int less = 0;
    *           if(ar[0] == 0)
    *               nobleCount = 1;
    *
    *           for(int i=1; i<n; i++){
    *               if(ar[i] != ar[i-1]) {
    *                   // means the element is coming for first time
    *                   less = i;
    *               } else {
    *                      // do nothing
    *               }
    *
    *               if(less == ar[i]){
    *                   nobleCount++;
    *               }
    *           }
    *           return nobleCount;
    *       }
    * TC : O(nlogn + n) = O(nlogn)
    * sc : O(1)
    * */

    public static int[] bubbleSort(int[] ar, String sortingOrder){

        for(int i = 0; i<ar.length; i++){
            for(int j=0; j<ar.length; j++){
                if(sortingOrder.equals("decr")){
                    if(ar[i]>ar[j]) {
                        int temp = ar[i];
                        ar[i] = ar[j];
                        ar[j] = temp;
                    }
                } else {
                    if(ar[i]<ar[j]) {
                        int temp = ar[i];
                        ar[i] = ar[j];
                        ar[j] = temp;
                    }
                }
            }
        }
        return ar;
    }


    // Question : You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors
    // of each element, i.e., element having the least number of factors should be the first to be displayed and the number having
    // highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should
    // come first.
    public static int[] sortDistinctFactors(int[] ar) {

        for (int i = 0; i < ar.length; i++) {
            //int count1 = optimiseFactors(ar[i]);
            int count1 = countFactors(ar[i]);
            for (int j = 0; j < ar.length; j++) {
                //incr
                int count2 = countFactors(ar[j]);
                if (count1 < count2) {
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }else if(count1 == count2){
                    if(ar[i]<ar[j]){
                        int temp = ar[i];
                        ar[i] = ar[j];
                        ar[j] = temp;
                    }
                }
            }
        }

        return ar;
    }

    public static int optimiseFactors(int A) {
        double a = Math.sqrt(A);
        int count = 0;
        for(double i = 1; i<=a; i++){
            if(A % i == 0) {
                if(i * i == A){
                    count++;
                } else {
                    count = count + 2;
                }
            }
        }
        return count;
    }

    public static int countFactors(int A) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(int i = 1; i<=A; i++){
            if(A % i == 0) {
                factors.add(i);
            }
        }
        return factors.size();
    }


}




















