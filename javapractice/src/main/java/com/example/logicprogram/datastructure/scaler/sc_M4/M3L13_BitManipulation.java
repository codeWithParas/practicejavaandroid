package com.example.logicprogram.datastructure.scaler.sc_M4;

public class M3L13_BitManipulation {

    public static void main(String[] args) {

    }

    // Decimal number system
    // 342 -> 300+40+2 = 3*10^2 + 4*10 + 2*10
    // Binary Number System to decimal
    // 1 1 0  -> 1*2^2 + 1*2^1 + 0*2^0 = 4+2+0 = 6

    // Ques : Convert binary to decimal
    // Hint : Multiply by 2^x
    // 1011010

    // Ques : Convert decimal to binary
    // Hint : Divide by 2
    // 20

    // Addition of binary number
    /*
    *         1 0 1
    *      +  0 1 1
    * O/p -> 10 0 0
    *
    *         1 0 1
    *      +  1 1 1
    * O/p -> 11 0 0
    *
    * */

    // Bitwise Operations -> AND, OR, XOR, NOT, LEFT SHIFT, RIGHT SHIFT
    // AND -> &
    // OR -> |
    // XOR -> ^
    // NOT -> ! (or ~)
    // Left Shift -> <<
    // Right Shift -> >>

    /*
    *                        Wire Connection
    *                         Series  Parallel
    *           A       B       A&B     A|B     A^B
    *           0       0       0       0       0
    *           0       1       0       1       1
    *           1       0       0       1       1
    *           1       1       1       1       0
    * */


    // Bitwise Operation on numbers
    // Ques : 5 & 6 = 101 & 110 = 100 = 4
    // Ques : 20 & 45 = 010100 & 101101 = 000100 =
    // Ques : 20 | 45 = 010100 | 101101 = 111101 = 61
    // Ques : 20 ^ 45 = 010100 ^ 101101 = 111001 = 57

    // Properties of above logical operations
    // Property 1 :
    // A & 1 = Answer is 0, if last bit is not set (Even Number)
    // A & 1 = Answer is 1, if last bit is set (Odd Number)

    // Property 2 :
    // A & 0 = Answer will always be 0.

    // Property 3 :
    // A & A = A

    // Property 4 :
    // A | 0 : A

    // Property 5 :
    // A | A : A

    // Property 6 :
    // A ^ 0 : A

    // Property 7 :
    // A ^ A : 0

    // Property 8 : Cumulative Property
    // a&b = b&a
    // b|a = a|b
    // a^b = b^a
    // a&b&c = a&b&c (all six order)

    // Property 9 : Associative Property
    // (A_B)_C = A_(B_C)
    // (A&B)&C = A&(B&C)

    // Ques : Evaluate : Using Property 6,7
    // a^b^a^d^b = (a^a)^(b^b)^d = (0)^(0)^d = 0^d = d

    // Ques : Given an integer ar[N] array, where every element occurs twice
    // except one, find the unique element.
    // A = [6,9,6,10,9] = 10
    // Solution : Iterate and do ans^a[i] = 10

    // Left Shift Operator (<<)

    // Max value can store in 8 bits = 255

    // Right Shift Operator (>>)

    //*****************************************************************************************

    // Exercises 1

    //Q1. Binary Addition : O/p : 100010100
    // A = 1001011 and B = 11001001. What is their sum?

    //Q2. Binary to Decimal (Hint : Multiply by 2) : Output : 173
    // 10101101(base 2) to decimal?

    //Q3. Decimal to Binary (Hint : Divide by 2).  Output : 1001100
    //conversion of 76 (base 10) to binary?

    //Q4. Bit Operations : OR = 1011011 , XOR = 0011010 , AND = 1000001
    // Given a = 1010011 and b = 1001001, their OR, XOR and AND are ?

    //Q5. Bit Operations
    //If a&1 = 1, then a is?  Odd

    //Q6. Bit Operations
    //What are the values of a&a, a|a, a^a?

    //Q7.  Any base to decimal
    //Problem Description
    //You are given a number A. You are also given a base B. A is a number on base B.
    //You are required to convert the number A into its corresponding value in decimal number system.
    // Hint :
    //We extract 1 digit from the end of the number A and
    //multiply it with the respective power of the given base
    //B and finally add it to the answer. This process continues
    //until the number A becomes 0, i.e. all the digits of A have
    //been extracted.
    //
    //Time Complexity : O(logA)
    //Space Complexity : O(1)


}


