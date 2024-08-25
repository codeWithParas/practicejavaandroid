package com.example.logicprogram.datastructure.scaler.sc_M4_Intermediate.scM4_4_2DMatrix;

public class M4L9_Matrices {

    /*
    * A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
    * */
    static int[][] matrices = new int[3][3];
    static int[][] matricesRect = new int[3][3];

    public static void main(String[] args) {
        //Ques3
        int[] r1 = {1,-2,-3};
        int[] r2 = {-4,5,-6};
        int[] r3 = {-7,-8,9};
        matrices[0] = r1;
        matrices[1] = r2;
        matrices[2] = r3;
        //System.out.println("Main Diagonal Sum = " + squareDiagonalSumLR(matrices));

        //Ques4
        int[] r11 = {1,2,3,4,5};
        int[] r22 = {6,7,8,9,10};
        int[] r33 = {11,12,13,14,15};
        matricesRect[0] = r11;
        matricesRect[1] = r22;
        matricesRect[2] = r33;
        //rectangularDiagonalSum_RL(matricesRect);

        //Ques5
        int[] r111 = {1,2,3};
        int[] r222 = {4,5,6};
        int[] r333 = {7,8,9};
        matricesRect[0] = r111;
        matricesRect[1] = r222;
        matricesRect[2] = r333;
        transposeOfMatrix(matricesRect);
    }

    //Q3. N*N Matrices get Main Diagonal Sum from R->L
    public static int squareDiagonalSumLR(final int[][] A){
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
    /**
     * Boundary Conditions : watching matrices from right to left
     * 1) j goes on decreasing -> j>=0
     * 2) i goes on increasing -> i<N
     * o/p :
     * 1
     * 2   6
     * 3   7   11
     * 4   8   12
     * 5   9   13
     */
    public static int rectangularDiagonalSum_RL(final int[][] A){
        int n = A.length; // 3
        int i =0; int j = 0;
        int sum = 0;
        while(j<A[0].length)
        {
            System.out.println("");
            int jTemp = j;
            while(i<n && jTemp>=0)
            {
                System.out.print(A[i][jTemp]+"   ");
                sum = sum + A[i][jTemp];
                i++;
                jTemp--;
            }

            j++;
            i = 0;
            sum = 0;

        }

        return sum;
    }

    //Q5. N*N Transpose of a matrix. SC -> O(1)
    public static void transposeOfMatrix(final int[][] A){

        int row = 0; int col = 0;

        while(row<A.length){
            int temp1 = A[row][col-1];
            int temp2 = A[row-1][col];
            A[row][col-1] = temp2;
            A[row-1][col] = temp1;
            row++;
            col++;
        }

        //Print transpose matrix1
        for(row=0; row<A.length; row++)
        {
            for(col=0; col<A[0].length; col++)
            {
                System.out.print(A[row][col]+"  ");
            }
            System.out.println(" ");
        }

    }



    /*for(col=0; col<row_Length; col++)
    {
        for(row=0; row<col_Length; row++)
        {
            if(row != col){
                int temp1 = A[row][col];
                int temp2 = A[col][row];

            }
        }
    }*/

}


