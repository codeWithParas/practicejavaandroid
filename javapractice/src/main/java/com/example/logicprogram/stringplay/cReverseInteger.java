package com.example.logicprogram.stringplay;

/**
 * Created by parasmani.sharma on 14/06/2017.
 */

public class cReverseInteger {

    public static void main(String[] arg)
    {
        //Hint:
        //
        /*
        * 1) Take two buckets i.e >>>  a(contain_number) & b(empty_number)
        * 2) Inside while loop if a(contain_bucket) is not empty
        *            then , just ( increment empty_bucket ) by 10 multiplier
        *            insert (in empty_bucket) <- (incremented empty_bucket) + last digit of contain_number
        *            (decrement contain_bucket ) by 10 divisor
        *
        *
        * */

        int number = 654321;
        int rev = 0;
        while (number != 0 )
        {
            rev = rev*10;
            rev = rev+number%10;
            number = number/10;
        }

        System.out.print("Reversed : " +rev);
    }

}
