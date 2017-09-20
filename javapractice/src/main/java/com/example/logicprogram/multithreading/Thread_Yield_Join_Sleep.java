package com.example.logicprogram.multithreading;

/**
 * Created by parasmani.sharma on 20/09/2017.
 */

public class Thread_Yield_Join_Sleep {

    /*
    * Yield : Gives chance to other threads. If other threads have priority greater than this thread.
    *                   -----------
    *                   :          :
    * BORN__start->__READY______RUNNABLE____DEAD
    *
    *
    * */

    /*
    * Join : Gives chance to other threads. If other threads have priority greater than this thread and goes into waiting state.
    *                   -----waiting------
    *                   :          :
    * BORN__start->__READY______RUNNABLE____DEAD
    *
    *
    * */
    public static void main(String args[])
    {
        //Thread.currentThread().setPriority(5);
        MyThread1 mt = new MyThread1();
        mt.setPriority(7);
        mt.start();
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Main is Running");

            if(i == 4)
            {
                //mt.yield();
                try {
                    mt.join();
                } catch (InterruptedException e) {

                }
            }
        }

    }

    private static class MyThread1 extends Thread
    {
        public void run()
        {
            for (int i = 0; i < 10 ; i++) {
                System.out.println("MyThread is Running");
                /*try {
                    MyThread1.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }

}
