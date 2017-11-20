package com.example.logicprogram.java_multithreading.inter_thread_communication;

/**
 * Created by parasmani.sharma on 02/06/2017.
 */

public class WaitNotify_Usage {

    public static void main(String args[]) {
        System.out.println("Main Thread Starts Child Thread");

        ThreadA t = new ThreadA();
        t.start();


        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        synchronized (t) {
            try {
                t.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n\nMain Thread is now Working");
            int total = 0;
            for (int i = 0; i < 5; i++) {
                total = total + i;
            }

            t.setOutput(total);
            t.notify();
        }

    }
}

class ThreadA extends Thread {

    public void run() {
        System.out.println("\nChild Thread Started ");

        synchronized (this) {
                System.out.print("\nChild Thread is Waiting for MainThread O/p");

            this.notify();
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
