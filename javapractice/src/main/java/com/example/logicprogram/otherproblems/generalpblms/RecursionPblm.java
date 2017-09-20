package com.example.logicprogram.otherproblems.generalpblms;

/**
 * Created by parasmani.sharma on 14/06/2017.
 */

public class RecursionPblm {

    //befor execution try select your answer after looking at code
    //a) 2
    //b) 9
    //c) 3
    //d) 8

    //hint : for such type of recursive pblms first concentrate on recursive call and its working inside this process only. Making repeated call
    //again again will reduce the value of n/r to minimum and hence we can get the solution.

    public static void main(String[] arg)
    {
        RecursionPblm obj = new RecursionPblm();
        System.out.print("Result : "+ obj.foo(513,2));

    }

    private int foo(int n, int r) {

        if(n>0)
        {
            int res = (n%r + foo(n/r,r));

            return res;
        }else
        {
            return 0;
        }

    }
}
