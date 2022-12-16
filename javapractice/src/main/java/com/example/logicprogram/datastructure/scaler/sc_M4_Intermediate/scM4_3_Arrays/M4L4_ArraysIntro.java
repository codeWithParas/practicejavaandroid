package com.example.logicprogram.datastructure.scaler.sc_M4_Intermediate.scM4_3_Arrays;

public class M4L4_ArraysIntro {

    static int[] arr = {4, 6, 8, 2, 3, 9, 8, 7, 3, 7};
    static int kRotation = 21;

    //Expected O/p : 7 4 6 8 2 3 9 8 7 3

    public static void main(String[] args) {

        // Question : Array rotation by Kth times
        // Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
        solve(arr, kRotation);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] solve(int[] A, int B) {

        int start = 0;
        int end = A.length-1;
        int kElements = B > A.length ? B % A.length : B;
        int count = 1;

        //reverse complete
        A = reverseComplete(A);
        //reverse first k elements
        A = reverseInParts(A, 0, kElements-1);
        //reverse remainin elements from k+1 to n-1
        A = reverseInParts(A, kElements, A.length-1);

        return A;
    }

    public static int[] reverseComplete(int[] A){
        int start = 0;
        int end = A.length-1;
        while(start < end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return A;
    }

    public static int[] reverseInParts(int[] A, int start, int end){
        while(start < end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return A;
    }

}
