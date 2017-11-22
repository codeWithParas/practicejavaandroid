package com.example.logicprogram.java_basics.java_constructor;

/**
 * Created by parasmani.sharma on 18/11/2017.
 */

/*
* Example of Shadowing :
*
* Local variable is same as instance variable;
* In this kind of scenerio local variable has given high priority than instance variable.
* It all becouse of scope of variables :
* we can use "this" to avoid shadowing.  this.numb = numb;
*
* */

public class Java_Shadowing {

    int numb;      //instance variable
    String name;

    public Java_Shadowing(int numb, String name)    //local variable
    {
        numb = numb;
        name = name;
    }

    public void disp()
    {
        System.out.print("Roll Num : " +numb);
        System.out.println("Name : " +name);
    }

    public static void main(String args[])
    {
        Java_Shadowing obj = new Java_Shadowing(4, "Ram");
        obj.disp();                                            //output : 0, null

    }


}
