package com.example.logicprogram.datastructure.scaler.sc_M4_Intermediate.scM4_6_BitManipulation;

public class M3L14_BitManipulation2 {



    // Left Shift Operator
    // left shift by 2 : (0000100)'2 -> denoted as (1<<2)
    // (0000100)'2 = 2^2 = 4
    // (0010000)'2 = 2^4 = 16
    /*
    * N = 45 = 101101 (do left shift by 2)
    *
    * Analyze below cases for OR operation
    * Case 1 :
    *       101101
    *       000100
    * OR -  101101 -> 45
    *
    * Case 2 :
    *       101101
    *       010000
    * OR -  111101 -> 61
    *
    * find (N | 1<<i) ?
    *       if ith bit is set -> N
    *       if ith bit is unset -> N+2^i
    * */

    /*
     * N = 45 = 101101 (do left shift by 2 and 4)
     * Analyze below cases for AND operation
     *
     * Case 1 :
     *        101101
     *        000100
     * AND -  100100 ->
     *
     * Case 2 :
     *       101101
     *       010000
     *       000000
     *
     * find (N | 1<<i) ?
     *       if ith bit is set -> 2^i
     *       if ith bit is unset -> 0
     * */

    /*
     * N = 45 = 101101 (do left shift by 2 and 4)
     * Analyze below cases for XOR operation
     *
     * Case 1 :
     *        101101
     *        000100
     * XOR -  101001 -> 41 (decreased)
     *
     * Case 2 :
     *       101101
     *       010000
     *       111101 -> increased
     *
     * find (N | 1<<i) ?
     *       flips ith bit -> toggle ith bit
     * */

    /*
    * Ques : Unset ith bit of a number, only if it is set, else no change.
    * Using Left Shift
    * N = 45,  i = 2
    * 101101 -> 101001 (Answer)
    *
    * N = 45,  i = 4
    * 101101 -> 101101 (Answer)
    *
    * if(checkIfBitIsSet(N,i))
    *   N = N ^[1<<i]
    * else
    *   no change
    *
    * checkBit is set or not :
    *  1) N & (1<<i) = 1<<i   using AND
    *  2) N | (1<<i) = N      using OR
    *  3) N^(1<<i) < N        using XOR
    *
    *  Using Right Shift ?
    *
    * */

    /*
     * Using Right Shift
     * Ques : Unset ith bit of a number, only if it is set, else no change.
     * Using Left Shift
     * N = 45,  i = 2
     * 101101 -> 101001 (Answer)
     *
     * N = 45,  i = 4
     * 101101 -> 101101 (Answer)
     *
     * if(checkIfBitIsSet(N,i))
     *   N = N ^[1<<i]
     * else
     *   no change
     *
     * checkBit is set or not :
     *  1) N & (1>>i) = 1<<i   using AND
     *  2) N | (1<<i) = N      using OR
     *  3) N^(1<<i) < N        using XOR
     *
     *  Using Right Shift
     *
     * */

    /*
    * Ques : Given N, count total set bits in N.
    * N = 45 -> 101101, Ans = 4
    * Solution : Perform right or left shift.
    *
    * Solution 1 :
    * ans = 0
    * for(i=0 to 32/64 data type)
    *       if(ith bit is set)
    *           ans = ans+1
    * return ans;
    *
    * Solution 2 : Optimized
    * ans = 0
    * while(N>0)
    * {
    *
    *      if(N & 1 == 1)
    *           ans = ans+1;
    *      N = N>>1;
    *
    *      // replace if condition :: ans  = ans + (N&1) /// ans += (N&1)
    * }
    * return ans;
    *
    *
    * */


    // Negative Numbers (How to represent ?)
    /*
    * MSB -> Most significant bit
    *
    * N = 45 -> 00101101
    * N = -45 -> ?
    * flip all bits -> 11010010 (1's complement)
    * add 1 +       -> 00000001
    *                  11010011 (2's complement) = -45 Answer
    *
    * */


    /*
    * Range of Integers (4 Bytes) -- 32 bits
    *
    * Min number -> -2^31 = -2147483648 = -2*10^9
    * Max number -> 2^31-1 = 2*10^9
    *
    * Range of Integers (8 Bytes) -- 64 bits
    * Min number -> -2^31 = -2147483648 = -2*10^9
    * Max number -> 2^63-1 = 9*10^18
    * */

    /*
    * Subtract binary numbers
    * 45-12
    *
    * 101101
    *
    * */
}
