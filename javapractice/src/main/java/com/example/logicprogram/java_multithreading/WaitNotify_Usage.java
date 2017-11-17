package com.example.logicprogram.java_multithreading;

/**
 * Created by parasmani.sharma on 02/06/2017.
 */

public class WaitNotify_Usage {

    public static void main(String args[]) {
        System.out.println("Main Thread Starts Child Thread");

        ThreadA t = new ThreadA();
        t.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nMain Thread is Working");

        int total = 0;
        for (int i = 0; i < 100; i++) {
            total = total + i;
        }

        t.setOutput(total);
        t.notify();

        System.out.println("\nMain Thread notify child thread");

    }
}

class Disp {
    int total = 0;

    Disp(int op) {
        total = op;
    }

    public synchronized void display() {
        System.out.println(total);
    }

}

class ThreadA extends Thread {

    public void run() {
        System.out.println("\nChild Thread Started ");
        System.out.print("\nChild Thread is Waiting for MainThread O/p");

        synchronized (this) {
            try {
                //sleep(3000);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("\n\nChild Thread got O/P : " + display());
    }

    static int total;

    public void setOutput(int op) {
        total = op;
    }

    private int display() {
        return total;
    }

}
