package com.example.logicprogram.ZafarTest.multithreading;

/**
 * Created by zafar.imam on 14-10-2017.
 */

//Example of multiple threads executing the
// same object at same time without synchronization.
public class ThreadTest {

    public static void main(String arg[]){

        //class of line obj ie shared among threads
        MyLine objLine = new MyLine();

        //creating the thread ie sharing the same object
        MyThreads thread1 = new MyThreads(objLine);
        MyThreads thread2 = new MyThreads(objLine);

        thread1.start();
        thread2.start();
    }
}

class MyThreads extends Thread{

    private  MyLine objLine;

    public MyThreads(MyLine objLine) {
        this.objLine = objLine;
    }

    @Override
    public void run() {
        objLine.getLine();
    }
}

class MyLine{

    public void getLine() {

        for (int i = 0; i < 11; i++) {

            System.out.println(i);

            try {
                Thread.sleep(1000);
                int i1 = 10 / 0;
            } catch (InterruptedException e) {
                System.out.println("Exception caught : "+e.getMessage());
            }
        }
    }
}