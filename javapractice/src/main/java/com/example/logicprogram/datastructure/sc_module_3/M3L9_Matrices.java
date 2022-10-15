package com.example.logicprogram.datastructure.sc_module_3;

import java.util.Arrays;

public class M3L9_Matrices {

    /*
    * A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
    * */
    static int[][] matrices = new int[3][3];

    public static void main(String[] args) {
        int[] r1 = {1,-2,-3};
        int[] r2 = {-4,5,-6};
        int[] r3 = {-7,-8,9};
        matrices[0] = r1;
        matrices[1] = r2;
        matrices[2] = r3;



        System.out.println("Main Diagonal Sum = " + diagonalSumLR(matrices));
    }

    //Q3. N*N Matrices get Main Diagonal Sum from R->L
    public static int diagonalSumLR(final int[][] A){
        int n = A.length;
        int i =0; //int j = 0;
        int sum = 0;
        while(i<n)// && j<n)
        {
            sum = sum + A[i][i];
            i++;
            //j++;
        }

        return sum;
    }

    //Q4. N*M Matrices get Diagonal Sum from R->L

}


