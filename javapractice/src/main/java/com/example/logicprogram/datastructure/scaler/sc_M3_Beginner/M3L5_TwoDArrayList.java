package com.example.logicprogram.datastructure.scaler.sc_M3_Beginner;

public class M3L5_TwoDArrayList {

    /*
     * Agenda :
     *
     * 1) Matrix Multiplication
     * 2) Intro to 2D ArrayList -> Representation, I/O
     * 3) Questions on 2D ArrayLists
     * 4) Data types
     *
     * */

    public static void main(String[] args) {

        /*
         * Matrix Multiplication
         * 1) For us to be able to multiply two matrices
         *       A -> rA * CA
         *       B -> rB * CB
         *   then both matrices should satisfy : cA == rB
         * i.e : Matrix A columns count == Matrix B rows count
         *
         * 2) If you are able to multiply then dimension of Resultant Matrix -> rA * cB
         *
         * */

        /*
         * 2D array list
         * */

        /*
         *
         * Identity matrix
         *
         * fun(A, I) -> A
         * */


        /*
         * For matrix multiplication we use 3 loops in general solution.
         * Can we reduce no. of for loops in matrix multiplication.
         * */

    }


    // Some questions from scaler

    /*
     * 1) Identity Matrix
     * Problem Description :
     * You are given a N X N square integer matrix A. You have to tell whether A is an identity matrix or not.
     * Hint : Identity matrix is a special square matrix whose main diagonal elements are equal to 1 and all other elements are 0.
     *
     * Problem Constraints : 2 <= N <= 103
     * A[i][j] equals 0 or 1.
     *
     * Output Format : Return 1 if A is an identity matrix, else return 0.
     *
     * */

    public int checkIfIdentity(final int[][] A) {

        boolean isIdentity = true;
        int rowSize = A.length - 1;
        for (int i = 0; i < rowSize; i++) {
            int colSize = A[i].length - 1;
            for (int j = 0; j < colSize; j++) {
                if (i == j && A[i][j] != 1) {
                    isIdentity = false;
                } else if (i != j && A[i][j] != 0) {
                    isIdentity = false;
                }
            }
        }

        if (isIdentity) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
     * 2) Matrix Transpose
     * Return transpose of 2D Matrix
     *
     * Example Input 1 :
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * Output 1:
     * [[1, 4, 7],
     *  [2, 5, 8],
     *  [3, 6, 9]]
     *
     * */

    public int[][] getTransposeMatrix(int[][] A) {

        int rowSizeA = A.length;
        int colSizeA = A[0].length;
        int colSize = rowSizeA;
        int rowSize = colSizeA;

        int[][] a = new int[rowSize][colSize];

        for (int i = 0; i < rowSizeA; i++) {
            for (int j = 0; j < colSizeA; j++) {
                a[j][i] = A[i][j];
            }
        }
        return a;
    }

    /*
     * Q3. Matrix Multiplication
     * Refer :
     * Problem Description :
     * */

    public int[][] solveMatricsMultiplication(int[][] A, int[][] B) {

        int rowCountA = A.length;
        int colCountA = A[0].length;
        int rowCountB = B.length;
        int colCountB = B[0].length;

        int[][] res = new int[rowCountA][colCountB];

        if (colCountA == rowCountB) {

            for (int i = 0; i < rowCountA; i++) {
                for (int j = 0; j < colCountB; j++) {

                    int sum = getMatricsSumAtPosition(i, j, A, B);
                    res[i][j] = sum;
                }
            }

        }

        return res;
    }

    public int getMatricsSumAtPosition(int i, int j, int[][] A, int[][] B) {

        int sum = 0;
        for (int k = 0; k < A[0].length; k++) {
            int a1 = A[i][k];
            int b1 = B[k][j];

            sum = sum + (a1 * b1);
        }

        return sum;
    }
}
