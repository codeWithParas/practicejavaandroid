package com.example.logicprogram.ZafarTest.multithreading;

/**
 * Created by zafar.imam on 13-10-2017.
 */

public class MultithreadDemo extends Thread{

    public static void main(String ...arg){
        int n = 8; // number of thread
        for (int i = 0; i < n; i++) {
            MultithreadDemo thread = new MultithreadDemo();
            thread.start();
            try {
                thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {

        try {

            //Displaying thread which is running
            System.out.println("Thread : " + Thread.currentThread().getId() + " is running");
        }catch (Exception e){
            System.out.println("Exception is caught here : "+e.getMessage());
        }
    }
}




