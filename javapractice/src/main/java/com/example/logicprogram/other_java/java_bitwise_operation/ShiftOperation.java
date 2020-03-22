package com.example.logicprogram.other_java.java_bitwise_operation;

public class ShiftOperation {

    public static void main(String[] args) {

        //Question : input OOB Actions are as follows :
        /*
        *
        *   Bit-Position        Type
        *   0                   PushAction(0)
        *   1                   TwistAction
        *   2                   InputNumeric
        *   3                   InputAlphanumeric
        *
        * You have total 2 bytes (2 octet) of data whos value is 1. Then find the respective action w.r.t
        * the given value.
        * Calculate for i = 1, i = 48
        * */

        //octet means 1 byte
        //if value of 1 octet is 1
        //i.e binary representation is :     0.0.0.0.0.0.0.1


        int i  = 11;
        int pushMask = 0xFFF2;

        /*int i  = 2;
        int pushMask = 0xFFF2;
*/
        //int i  = 8;
        //int pushMask = 0x03;

        /*
        *     And Operation :
        *     0000 0000 0000 0010
        *     1111 1111 1111 0010
        * Sol:0000 0000 0000 0010
        *
        * Shift Operation : 0000 0000 0000 0010
        * Solution : 0000 0000 0000 0001(0)
        * Ans : 0000 0000 0000 0001, i.e : 1
        *
        * */


        if((i & pushMask) >> 0 == 1)
        {
            System.out.println("Push Action");
        }
        else if((i & pushMask) >> 1 == 1)
        {
            System.out.println("Twist Action");
        }
        else if((i & pushMask) >> 2 == 1)
        {
            System.out.println("Input Numeric");
        }
        else if((i & pushMask) >> 3 == 1)
        {
            System.out.println("Input Alphanumeric");
        }
    }
}
