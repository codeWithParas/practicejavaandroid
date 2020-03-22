package com.example.logicprogram.other_java.java_bitwise_operation;

public class Test {

    public static void main(String[] args) {

        //int pushMask = 0xFFF1;
        int pushMask1 = 0xFFF1;  // 65521   :   1111 1111 1111 0001
        int pushMask2 = 0xFFF2;  // 65522   :   1111 1111 1111 0010
        int pushMask3 = 0xFFF3;  // 65523   :   1111 1111 1111 0011
        int pushMask4 = 0xFFF4; //  65524   :   1111 1111 1111 0100
        int pushMask5 = 0xFFF11; //  65524   :   1111 1111 1111 0100



        System.out.println(pushMask5+"");
        System.out.println(pushMask4+"");

        int value = 1; // 0000 0000 0000 0001

        /*
        * And Operation :
        * //     0000 0000 0000 0001
        * //     1111 1111 1111 0001
        * //Sol: 0000 0000 0000 0001      0/p : 1
        *
        * */
        System.out.println("\n\n" + (1 & pushMask1) +"");
        System.out.println("\n" +((1 & pushMask1) >> 0)+"");



        //0xFF
        //The hex literal 0xFF is an equal to int(255). Java represents int as 32 bits. It look like this in binary:
        //00000000 00000000 00000000 11111111
        //When you do a bit wise AND with this value(255) on any number, it is going to mask(make ZEROs) all but the lowest 8 bits of the number (will be as-is).
        //... 01100100 00000101 & ...00000000 11111111 = 00000000 00000101


        //0xFFFF
        //It's a 16-bit number with all bits set to one. The meaning will be different depending on whether it's a
        // char or a short, because char is unsigned and short is signed. If it's a char it'll be 2^16 - 1.
        // If it's a short it'll be negative because the MSB is 1, so take the two's complement and you get -1.
        // (Invert all the bits and add 1.) If it's assigned to a type wider than 16 bits, it fits and the MSB is still 0, so it's positive (2^16 - 1 again). BTW, 2^16 is 65536 (all good geeks should know powers of two at least through sweet 16.)
        //******************************************************************************
        //Try to compute numbers in other bases. 0xFFFF is hexidecimal (base 16) meaning that the number
        // is made up of 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F where A=10, B=11, etc. I like to think of it this way:
        //16^3 (4096) 16^2 (256) 16^1 (16) 16^0 (1)
        //--------------------------------------------------
        //F F F F
        //
        //this means that 0xFFFF is 15*4096 + 15*256 + 15*16 + 15*1  (= 65535).
        //In base 10 this number would be represented like this:
        //10^4 (10000) 10^3 (1000) 10^2 (100) 10^1 (10) 10^0 (1)
        //--------------------------------------------------------------
        //6 5 5 3 5
        //A good way to cheat is to use a calculator. Hit the hex button and plug in the hex value. Then change your base back to 10 by
        //hitting the dec button.



    }
}
