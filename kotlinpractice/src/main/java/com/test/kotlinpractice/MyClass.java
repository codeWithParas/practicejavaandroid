package com.test.kotlinpractice;

import java.util.Arrays;

public class MyClass {

    public static void main(String[] arg) {
        MyClass v = new MyClass();
        v.drawTriangle(5);

        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 4;
        int result1 = binarySearch(arr, x);
        System.out.print(result1);

        int[] array = {21, 23, 34, 32, 1, 3, 8, 2, 5, 9};

        //int[] arr = bubbleSort(array);
        int[] arrayy = bubbleSortIterator(array);

        for (int i = 0; i < arrayy.length; i++) {
            System.out.print("\nElement : " + arrayy[i]);
        }


        //Build heap
        int arrr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int nn = arrr.length;
        buildHeap(arrr, nn);
        printHeap(arrr, nn);
    }

    static int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was not present
        return -1;
    }

    private static int[] bubbleSort(int[] array) {

        int count = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return array;
    }

    private static int[] bubbleSortIterator(int[] array) {
        for (int j = 0; j < array.length; j++) {
            try {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        return bubbleSort(array);
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Function to build a Max-Heap from the Array
    static void buildHeap(int arr[], int n) {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    //using iteration

    // A utility function to print the array
    // representation of Heap
    static void printHeap(int arr[], int n) {
        System.out.println(
                "Array representation of Heap is:");

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    private void drawTriangle(int size) {

        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                //System.out.print("$");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }


    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
            System.out.println("\nPivot Element : " + pi + "\n");

            // Recursively sort elements before
            // partition and after partition

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

}

