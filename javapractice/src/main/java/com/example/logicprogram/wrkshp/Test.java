package com.example.logicprogram.wrkshp;

public class Test {

    public static void main(String[] args) {

        System.out.println("Main Thread is Started.");
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Main Thread is Ends.");
    }
}

class MyThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mythread is running : " + i);
        }
    }
}
