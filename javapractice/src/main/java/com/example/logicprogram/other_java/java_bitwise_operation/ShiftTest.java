package com.example.logicprogram.other_java.java_bitwise_operation;

public class ShiftTest {

    public static void main(String[] args) {

        /*
        * Signed Right shift operator (>>) –
        * Shifts the bits of the number to the right
        * and fills 0 on voids left as a result. The leftmost bit depends on the sign of initial number.
        * Similar effect as of dividing the number with some power of two.
        *
        *
        * */

        int a = 5;
        int b = 5;

        // left shift operator
        // 0000 0101<<2 =0001 0100(20)
        // similar to 5*(2^2)
        System.out.println("a<<2 = " + (a << 2));

        // right shift operator
        // 0000 0101 >> 2 =0000 0001(1)
        // similar to 5/(2^2)
        System.out.println("b>>2 = " + (b >> 2));

        // unsigned right shift operator
        System.out.println("b>>>2 = " + (b >>> 2));
    }
}
