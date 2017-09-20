package com.example.logicprogram.otherproblems;

/**
 * Created by parasmani.sharma on 06/06/2017.
 */

public class ArrayDoubplicatesCheck {

    public static void main(String arg[])
    {
        Integer[] arr = {10,10,40,40,40,50,60,70,70,80,80,80};
        //Integer[] array = getDouplicates(arr);
        Integer[] array = getDupl(arr);
        for(int i=0; i<array.length-1;i++) {
            System.out.print(array[i]);
        }

    }

    private static Integer[] getDupl(Integer[] arr) {

        int count = 1;
        int countDupl = 0 ;
        Integer[] duplicate = new Integer[20];
        int checkNumber = arr[0];

        for (int i=0; i<arr.length-1; i++)
        {
            if(count == arr.length-1)
            {
                checkNumber = arr[count];
            }
            if(checkNumber == arr[count])
            {
                duplicate[countDupl] =  checkNumber;
                count++;
                countDupl++;
            }else {
                count++;
            }

        }

        return duplicate;
    }

    private static Integer[] getDouplicates(Integer[] arr) {

        //O(n^2)

        int count = 0;
        int number = 0 ;
        Integer[] duplicate = new Integer[20];
        Integer[] retun = new Integer[20];

        for(int i=0; i<arr.length;i++)
        {
            number = arr[i];

            for(int j=0; j<arr.length;j++)
            {
                if(number == arr[j] && i!=j)
                {
                    if(count < arr.length)
                    {
                        duplicate[count] = arr[i];
                        count++;
                    }

                    break;
                }
            }
        }


        return duplicate;
    }

}
