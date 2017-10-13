package com.example.logicprogram.ZafarTest.multithreading;

/**
 * Created by zafar.imam on 13-10-2017.
 */

public class ThreadJoining extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(1500);
                System.out.println("ThreadJoining Current Thread : "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("ThreadJoining Exception Caught : "+Thread.currentThread().getName());
            }
            System.out.println(i);
        }
    }
}

class JoinTest{

    public static void main(String ...ver) throws InterruptedException {

        ThreadJoining t1 = new ThreadJoining();
        ThreadJoining t2 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        t1.start();
        System.out.println("Current Thread : "+Thread.currentThread().getName());
        t1.join();

        t2.start();
        System.out.println("Current Thread : "+Thread.currentThread().getName());
        t2.join();


        t3.start();
        System.out.println("Current Thread : "+Thread.currentThread().getName());

    }
}
