package com.example.logicprogram.otherproblems;

/**
 * Created by parasmani.sharma on 22/05/2017.
 */

public class A {

    public static void show(){

        System.out.println("Static method called");

    }

    public static void main(String[] args)  {

        /*A obj=null;
        obj.show();*/
        B b = new B();
        b.show();

    }
}

class B
{
    public void show(){

        int array[] = new int[256];
        //int i = 'a';

        array['a'] = 1;
        System.out.println('H'+'a');
        System.out.println("\nA"+'N');
        System.out.println(" method called   "+(int)'a' /*+  array['a'] + "  " + array['b']*/ /*+ " " +array['a']*/);
    }

}
