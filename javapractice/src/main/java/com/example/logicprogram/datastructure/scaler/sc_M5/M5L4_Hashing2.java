package com.example.logicprogram.datastructure.scaler.sc_M5;

public class M5L4_Hashing2 {

    public static void main(String[] args) {

    }

    /*
     * Content :
     * 1) Pair sum = k.
     * 2) Pair difference = k
     * 3) Sub-array with sum = k.
     * 4) Distinct element in every window of size k.
     * */

    // Ques : 1 Given 'n' array elements, check if there exists a pair [i,j]
    // such that ar[i]+ar[j] = k and i!=j.
    /*
     * Ex : ar[] = [8 9 1 -2 4 5 11 -6 7 5] for K=11
     *
     * ideal solution : nested loop
     * TC : O[n^2] , SC : O[1]
     *
     * 1) Optimise solution : Can sorting help here ?
     * Note : Using 2 pointer approach.
     * TC : O[nlogn], sc : O[1]
     *
     * 2) More optimise solution : Can hashing help here ?
     * Note : Using Hashset
     * TC : O[1]
     * ...insert all element of ar[] into hashset
     * */

    public static boolean isPairPresent(int[] ar, int k) {

        // HashSet<Integer> hs = new HashSet<Integer>(ar.);

        return false;
    }

}
