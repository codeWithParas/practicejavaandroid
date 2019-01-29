package collection;

import java.util.Arrays;

/**
 * Created by zafar.imam on 20-09-2017.
 */

public class ArrayDemo {



    public static void main(String arg[]) {
        int arr[] = {10, 7, 20, 15, 14, 19};
        System.out.println("Before Replace items : " + Arrays.toString(arr));
        printArray(arr);

    }

    private static void printArray(int[] arr) {
        //print {10,7,20,15,14,19} as {20,20,20,19,19,19}
        //first find biggest element in array
        //replace all left side element with biggest value

        int biggest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (biggest < arr[i]) {
                biggest = arr[i];
            }
        }
        System.out.println(" biggest : " + biggest);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= biggest) {
                if (arr[i] == biggest) {
                    // now find the right side biggest value just lower than the existing biggest.
                    //replace second largest value to right of every item of biggest value.
                    biggest = findSecondBig(i, biggest, arr);
                    System.out.println("Second Biggest : " + biggest);
                    break;
                }
                arr[i] = biggest;
            }
        }

        System.out.println("After Replace items : " + Arrays.toString(arr));
    }

    private static int findSecondBig(int position, int biggest, int[] arr) {

        System.out.println("Biggest Position : " + position);
        biggest = arr[position + 1];
        for (int i = position + 1; i < arr.length; i++) {
            if (biggest < arr[i]) {
                biggest = arr[i];
            }
        }

        for (int i = position + 1; i < arr.length; i++) {
            arr[i] = biggest;
        }
        return biggest;
    }
}
