package com.example.logicprogram.datastructure.scaler.sc_M4_Intermediate.scM4_3_Arrays;

public class M4L4_ArraysIntro {


    /*
     * Content Problems
     * 1) Arrays Basics.
     * 2) Count no. of elements, having at-least 1 element greater than itself.
     * 3) Check for a pair of elements who's sum equals K.
     * 4) Reverse the entire array
     * 5) Rotate array from last to first by K times, in O(N) time and O(1) space
     *
     * */


    static int[] arr = {4, 6, 8, 2, 3, 9, 8, 7, 3, 7};
    static int kRotation = 21;

    //Expected O/p : 7 4 6 8 2 3 9 8 7 3

    // About Array Refer :
    // Array is defined as an ordered set of similar data items. All the data items of an array are stored in consecutive memory locations in RAM. The elements of an array are of the same data type and each item can be accessed using the same name.
    // https://www.scaler.com/topics/data-structures/array-data-structure/
    // About Array Refer :
    // An array starts at a specific memory address. Each element occupies the same amount of bytes element_size. The array elements are located one after another in the memory from the start address on. So you can calculate the memory address of the element i with start + i * element_size. This computation is independent of the array size and is therefore O(1).
    // https://www.scaler.com/topics/data-structures/array-data-structure/

    /*
     * Idea :
     * 1) Reverse the entire array.
     * 2) Reverse the first K elements.
     * 3) Reverse the last (n-k) elements.
     * */

    public static void main(String[] args) {

        // Question : Array rotation by Kth times
        // Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
        solve(arr, kRotation);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] solve(int[] A, int B) {

        int kElements = B > A.length ? B % A.length : B;

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
