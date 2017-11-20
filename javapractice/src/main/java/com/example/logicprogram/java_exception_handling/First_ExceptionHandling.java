package com.example.logicprogram.java_exception_handling;

/**
 * Created by parasmani.sharma on 17/11/2017.
 */

/*
* finally without try block cannot be used. Try block is must for finally block to run.
* */

public class First_ExceptionHandling {

    public static void main(String args[])
    {
        try
        {
            System.out.println("Try : "+2/0);
        }
        catch(Exception e)
        {
            System.out.println("Catch ");
        }
        finally {
            System.out.println("Finally");
        }
    }

}
