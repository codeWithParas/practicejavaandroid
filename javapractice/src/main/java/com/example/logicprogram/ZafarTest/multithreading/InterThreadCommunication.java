package com.example.logicprogram.ZafarTest.multithreading;

import java.util.Scanner;

/**
 * Created by zafar.imam on 13-10-2017.
 */

public class InterThreadCommunication {

    public static void main(String arg[]) {

        PC pc = new PC();

        //creating a thread object which call pc.produce
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    pc.produce();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        //creating another thread to call pc.consume
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    pc.consume();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        //starting both the threads simultaneously
        thread1.start();
        thread2.start();

        //thread1 finishes before thread2
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static class PC {

        //here print a string and wait for consume
        public void produce() throws InterruptedException {

            synchronized (this) {

                System.out.println("Producer thread is running : ");

                //now release the lock on shared resources
                wait();

                //and wait till some other methods invoke notify
                System.out.println("Producer thread Resume : ");
            }
        }


        //Sleeps for some time and wait for key press,
        // After key is pressed it notifies produce() method
        public void consume() throws InterruptedException {

            Thread.sleep(1500);

            Scanner scanner = new Scanner(System.in);

            synchronized (this) {

                System.out.println("Consumer() : Waiting for return Key : ");
                scanner.nextLine();
                System.out.println("Consumer() : Return key is pressed : ");

                //notifies the produce() thread that it can wake up now.
                notify();

                //Sleep
                Thread.sleep(1500);
            }
        }
    }
}
/*
Lets understand how our produce and consume method works.

A_FactoryMethod of all, use of synchronized block ensures that only one thread at a time runs.
Also since there is a sleep method just at the beginning of consume loop, the produce thread gets a kickstart.

When the wait is called in produce method, it does two things.
1)Firstly it releases the lock it holds on PC object.
2)Secondly it makes the produce thread to go on a waiting state until all other threads have terminated,
that is it can again acquire a lock on PC object and some other method wakes it up by invoking notify or notifyAll on the same object.


Therefore we see that as soon as wait is called, the control transfers to consume thread and it prints -“Waiting for return key”.


After we press the return key, consume method invokes notify().
It also does 2 things-
* Firstly, unlike wait(), it does not releases the lock on shared resource therefore for getting the desired result,
  it is advised to use notify only at the end of your method.
* Secondly, it notifies the waiting threads that now they can wake up but only after the current method terminates.


As you might have observed that even after notifying, the control does not immediately passes over to the produce thread.
The reason for it being that we have called Thread.sleep() after notify().

As we already know that the consume thread is holding a lock on PC object, another thread cannot access it until it has released the lock.

Hence only after the consume thread finishes its sleep time and thereafter terminates by itself, the produce thread cannot take back the control.
After a 2 second pause, the program terminates to its completion.*/