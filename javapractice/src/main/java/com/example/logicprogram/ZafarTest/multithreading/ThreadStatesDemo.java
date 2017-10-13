package com.example.logicprogram.ZafarTest.multithreading;

/**
 * Created by zafar.imam on 13-10-2017.
 */

public class ThreadStatesDemo implements Runnable{

    public static ThreadStatesDemo statesDemo;
    public static Thread thread1;

    public static void main(String arg[]){
        statesDemo = new ThreadStatesDemo();
        thread1 = new Thread(statesDemo);

        Object object = new ThreadStatesDemo();
        //thread1 is created and currently in new State
        System.out.println("State of thread1 after creating is : "+thread1.getState());
        thread1.start();

        //thread1 moved to runnable state just after calling start method
        System.out.println("Thread1 state after calling start() method on it : "+thread1.getState() );
    }


    @Override
    public void run() {

        MyThread myThread = new MyThread();
        Thread thread2 = new Thread(myThread);

        //thread1 is created and currently in RUNNABLE state
        System.out.println("State of thread2 after creating it : "+thread2.getState());//NEW
        thread2.start();

        //thread2 moved to runnable state just after calling start method
        System.out.println("Thread2 state after calling start() method on it : "+thread2.getState() ); //RUNNABLE

        //moving thread1 on timed waiting state
        try {
            //moving thread2 to timed waiting state
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //state of thread2 after calling sleep on it
        System.out.println("State of thread2 after calling sleep on it : "+thread2.getState());


        try {
            // waiting for thread2 to die
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread2 when it has finished it's execution : "+thread2.getState());
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {

        //moving thread2 to timed waiting state
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread1 while it called join method on thread2 : "+ThreadStatesDemo.thread1.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}