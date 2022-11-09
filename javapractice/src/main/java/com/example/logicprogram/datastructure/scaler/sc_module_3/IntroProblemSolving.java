package com.example.logicprogram.datastructure.scaler.sc_module_3;

import java.util.ArrayList;


/*
* Q1. Count Factors - 2
* Q2. IsPrime
* Q3. Square root of a number
* Q4. Sum of evens!
* Q5. Power function
* Q6. Sum of N natural numbers
* Q7. Find the time Complexity
* Q8. Divide by 2
* Q9. Logarithmic Properties
*
 * */

public class IntroProblemSolving {

    // Q1. Count Factors - 2
    // https://www.scaler.com/topics/square-root-in-java/
    // 1) Find square root of a number
    public void findSquareRoot(int A) {

        // The square of 3 is 9.0
        int X = 3;
        double S = Math.pow(X, 2);
        System.out.println("The square of " + X + " is " + S);

        // Square root of 9 is 3.
        int Z = 9;
        double R = Math.sqrt(Z);
        System.out.println("The square root of " + Z + " is " + R);
    }

    // Find square root of 13 (Non perfect square number)
    // Hint Read : https://www.scaler.com/topics/square-root-in-java/
    // Use Binary Search Algorithm to find its square root value
    // Hint :
    /*
    * low = 3, high = 4, mid = 3.5, mid * mid = 12.25 < 13
    low = 3.5, high = 4, mid = 3.75, mid * mid = 14.0625 > 13
    low = 3.5, high = 3.75, mid = 3.625, mid * mid = 13.140625 > 13
    low = 3.5, high = 3.625, mid = 3.5625, mid * mid = 12.69140625 < 13
    .
    .
    .
    low = 3.605550, high = 3.605551, mid = 3.605551, mid * mid = 12.9999997 == 13 (up to 6 decimal places)
    *
    * */
    // Home WORK ??????????????

    /*
    * what is TLE and how it occurs, how to predict the time taken by your algorithm. the CPU can perform 100000000 (100 million) operations at 1 second etc, etc.
    * https://www.geeksforgeeks.org/overcome-time-limit-exceedtle/
    * */

    // 2) Count factors of a number
    public int countFactors(int A) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(int i = 1; i<=A; i++){
            if(A % i == 0) {
                factors.add(i);
            }
        }
        return factors.size();
    }

    // How to optimise above case to avoid TLE situation.
    /*
    * We call it as "Reduction Strategy"
    *
    * First Step : Check input and output data size (array) just to analyze
    *               iteration that is going to execute on input data.
    * Second Step : Check if o/p data size is lesser or half of input data size.
    *               Accordingly set the looping limits for iteration.
    * Third Step : After analyzing i/p-o/p data. Check mathe's conditions or formulas (of Math.sqrt())
    *               if we can reduce looping in for loop.
    * Example : Math.sqrt(A) -> will reduce iterations
    * Fourth Step : Inside for loop also check if maximum Output can be covered in single iteration only.
    * Example : count = count + 2 -> Adding here +2 will cover 2 cases at one iteration : 1*25 = 25 && 25*1 = 25
    * */

    /*
    * Iterate over all numbers from 1 to root(N).
For each number check if N % i == 0.
If yes, then increment count by 1 if i * i == N or
by 2 otherwise.
    *
    * */

    public int optimiseFactors(int A) {
        double a = Math.sqrt(A);
        int count = 0;
        for(double i = 1; i<=a; i++){
            if(A % i == 0) {
                if(i * i == A){
                    count++;
                } else {
                    count = count + 2;
                }
            }

        }
        return count;
    }

    // Q2. IsPrime
    // 3) Check Prime : A number only divisible by itself and 1.
    // return 1(true) else 0.
    public int checkIsPrime(long A) {
        int count = -1;
        for(int i = 1; i<=A; i++){
            if(A % i == 0) {
                if(i == 1 || i == A){
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }
        }
        return count;
    }

    public int optimiseIsPrime(long A) {
        int count = 0;
        double a = Math.sqrt(A);
        for(double i = 1; i<=a; i++){
            if(A != 1 && A % i == 0) {
                if(i == 1){
                    count = 1;
                } else {
                    count = 0;
                }
            }
        }
        return count;
    }

    // Q3. Square root of a number
    public int squareRoot(int A) {
        double a = Math.sqrt(A);
        int x = (int)a;
        if(x*x == A){
            return x;
        }else {
            return -1;
        }
    }

    // Q4. Sum of evens!
    public int sumOfEvenNumbers(int A) {
        int sum = 0;
        for(int i=0; i<=A; i++){
            if(i % 2 == 0){
                sum = sum + i;
            }
        }
        return sum;
    }

    // Q5. Power function
    // Refer :  https://www.geeksforgeeks.org/java-program-to-calculate-power-of-a-number/
    // Better Approach (bits-manipulation) using https://www.geeksforgeeks.org/bits-manipulation-important-tactics/
    public int power(final int A, final int B) {
        //return (int)Math.pow(A, B);
        int start = 1;
        int power = B;
        while(power > 0){
            start = start * A;
            power--;
        }
        return start;
    }

    // Q7. Find the time Complexityyou
    /*
    *
    * Find the number of times below code runs where N is a perfect square
    * for i -> 1 to N
    * if(i * i == N)
    * return i
    *
    * Options : N, N/2, sqrt(N), logN
    * Answer : sqrt(N)
    *
    * */

}
