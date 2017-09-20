package com.example.logicprogram.multithreading;

/**
 * Created by parasmani.sharma on 20/09/2017.
 */

public class CreateThread_Java {

    /*
    * we can create tread by two ways :
    * 1) extending thread class
    * 2) implementing Runnable interface
    *
    *                 Runnable(I) ( Run() method)
    *                   /   \
    *                  /     \
    *      Thread(Start())    MyRunnable (our class)
    *               /
    *       MyThread(our thread class)
    * */

    public static void main(String args[])
    {

        MyThread mt = new MyThread();
        mt.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread mtt = new Thread(myRunnable);
        mtt.start();

    }


    private static class MyThread extends Thread
    {
        public void run()
        {
            System.out.println("Mythread is running");
        }
    }

    private static class MyRunnable implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("MyRnnable  is running");
        }
    }

}
