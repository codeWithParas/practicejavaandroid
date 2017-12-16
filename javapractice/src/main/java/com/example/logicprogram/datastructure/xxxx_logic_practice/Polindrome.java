package com.example.logicprogram.datastructure.xxxx_logic_practice;

/**
 * Created by parasmani.sharma on 08/12/2017.
 */

/*
*
* 1) prog to find polindrome in digits of array. Return size of array of  polindrome data.
Ex : Input : 12345
     output : 0 size
Ex : Input : 1234543
     output : 5 size
* */



public class Polindrome {

    public static void main(String args[])
    {

        checkNumberVariable();
        checkNumberArray();



    }

    private static void checkNumberArray() {

        //Write code here
        /*
        * To find polindrome for array we need to pair digits for each loop iteration.
        * LIke : First iteration condsider two digits
        *        Second ite8ration consider threee digits
        *        Fourth iteration consider four digits
        *      If any polindrom founds save that to temp variable
        *        Fifth iterate now for five digits
        *        and so on.
        * */
        int[] numbArray = {1,2,3,4,5,4,3,2};
        int r,sumRev=0,temp;

        int countArraySize = 3;

        while (countArraySize < numbArray.length)
        {
            int tempData = 0;

            for (int i = 0; i < countArraySize; i++) {



            }

        }








        /*temp=n;
        while(n>0){
            r=n%10;  //getting remainder
            sumRev=(sumRev*10)+r;
            n=n/10;
        }
        if(temp==sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");*/


    }

    private static void checkNumberVariable() {
        //Write code here
        int r,sum=0,temp;
        int n=454;//It is the number variable to be checked for palindrome

        temp=n;
        while(n>0){
            r=n%10;  //getting remainder
            sum=(sum*10)+r;
            n=n/10;
        }
        if(temp==sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");

    }

}
