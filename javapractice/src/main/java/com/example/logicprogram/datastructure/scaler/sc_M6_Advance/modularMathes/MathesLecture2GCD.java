package com.example.logicprogram.datastructure.scaler.sc_M6_Advance.modularMathes;


/*
 * Agenda
 * 1) GCD Intro (HCF) - Highest Common Factor
 * 2) Properties of GCD
 * 3) Understanding Euclidean Algo -> gcd(a,b) = gcd(b%a, a) : {T(O) = log(N)} where N = max(a,b)
 * // Check Extended Euclidean Algo before using Euclidean Algo
 * 4) Problem
 * --> Subsequence with GCD = 1
 * --> Delete 1 element
 * */
public class MathesLecture2GCD {

    //FYI : Java : Math.abs(arr[i]) -> used for mod : convert to positive

    // Q1 : Calculate GCD
    // Q2 : Given arr[N] calculate gcd of entire array : ex : arr[3] = {6, 12, 15} :: {T(O) = Nlog(N)} where N = max(arr[])
    // Q3 : Given an arr, check if there exist a SubSequence with gcd = 1. :
    // Ex : arr[5] = {4,6,3,8} = {4,3}, {4,3,8}

    // Q4 : Given arr, we have to delete 1 element such that gcd of remaining array is max.
    // Optimal Approach : Prefix and Suffix GCD Approach


}
