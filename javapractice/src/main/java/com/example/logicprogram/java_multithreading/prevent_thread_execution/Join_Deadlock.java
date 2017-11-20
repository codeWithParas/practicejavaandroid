package com.example.logicprogram.java_multithreading.prevent_thread_execution;

/**
 * Created by Parasmani Sharma on 11/19/2017.
 */

public class Join_Deadlock {

    public static void main(String args[])
    {
        try {

            System.out.print("In this case thread has to wait infinite amount of time");

            Thread.currentThread().join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
