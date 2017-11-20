package com.example.logicprogram.java_multithreading.inter_thread_communication;

/**
 * Created by Parasmani Sharma on 11/19/2017.
 */

public class Wait_Notify_Test {

    public static void main(String args[])
    {
        Calculate cal = new Calculate();
        cal.start();
        synchronized (cal)
        {
            try {
                cal.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Total : "+cal.total);
        }
    }

}

class Calculate extends Thread
{
    public int total = 0;
    public void run()
    {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                total = total + 1;
            }

            this.notify();
        }



    }

}
