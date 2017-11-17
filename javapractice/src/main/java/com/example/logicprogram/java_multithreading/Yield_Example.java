package com.example.logicprogram.java_multithreading;

/**
 * Created by Parasmani Sharma on 10/12/2017.
 */

public class Yield_Example {

    /*
    * Prevent current thread execution by giving chance to other thread of same or greater priority.
    * */

    public static void main(String args[])
    {
        MyThread mt = new MyThread();
        mt.start();
        System.out.println("Main Thread Start");
    }

}

class MyThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            System.out.println("My Thread Start");
            Thread.yield();
        }
    }
}
