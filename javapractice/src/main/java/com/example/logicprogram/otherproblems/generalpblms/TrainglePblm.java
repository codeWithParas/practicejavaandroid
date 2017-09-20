package com.example.logicprogram.otherproblems.generalpblms;

/**
 * Created by parasmani.sharma on 14/06/2017.
 */

public class TrainglePblm {

    /*
    * hint :
    * Print * in odd number series : Use formula (2*i-1)
    * */

    public static void main(String arg[])
    {

        TrainglePblm obj = new TrainglePblm();
        obj.drawTriangle(10);

    }

    private void drawTriangle(int size) {

        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i/*(2 * i - 1)*/; k++) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println(" ");
        }

        for (int i = size - 1; i >= 1; i--) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i/*(2 * i - 1)*/; k++) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }


    /*private void drawTriangle(int size) {

        for(int i=1; i<=size; i++)
        {
            for(int j=size; j>=i; j--)
            {
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++)
            {
                System.out.print("*");
            }
            System.out.println(" ");
        }


    }*/




}
