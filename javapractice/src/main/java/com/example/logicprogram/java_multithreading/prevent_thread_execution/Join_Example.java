package com.example.logicprogram.java_multithreading.prevent_thread_execution;

/**
 * Created by Parasmani Sharma on 11/19/2017.
 */

/*
* Join : Prevent thread execution. When join is called then main thread entered into waiting stage and let
* child thread to finish first. And then again get back to run again from that point where it left the execution.
*
* Case : When main thread goes in to waiting stage :
*        At this point if suppose any other thread interrupt main thread then Interrupt Exception occur.
*
* */

public class Join_Example {

    public static void main(String args[])
    {

        MyThreadJoin mt = new MyThreadJoin();
        mt.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread Running : " + i);
            try {
                mt.join();
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class MyThreadJoin extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child Thread Running : "+i);
        }
    }
}
