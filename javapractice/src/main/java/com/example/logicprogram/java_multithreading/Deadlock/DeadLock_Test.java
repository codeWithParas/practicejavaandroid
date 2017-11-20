package com.example.logicprogram.java_multithreading.Deadlock;

import static java.lang.Thread.sleep;

/**
 * Created by Parasmani Sharma on 11/19/2017.
 */

/*
* Cause : Due to synchronized keyword. So we need to take special care while using it
*
* Note : wait(), notify(), notify : releases the current object lock
*        sleep() did not release the current object lock
*
* */

public class DeadLock_Test extends Thread {
    A a = new A();
    B b = new B();

    public void method()
    {
        this.start();
        a.m1(b);
    }
    public void run()
    {
        b.m2(a);
    }
    public static void main(String args[])
    {
        DeadLock_Test obj = new DeadLock_Test();
        obj.method();

    }
}

class A
{
    public synchronized void m1(B b)
    {
        System.out.println("Inside A m1 method");
        try {
            sleep(3000);
            //b.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.disp();
    }

    public synchronized void disp(){
        System.out.println("Inside A disp");
    }
}

class B
{
    public synchronized void m2(A a)
    {
        System.out.println("Inside B m2 method");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.disp();
    }

    public synchronized void disp(){
        System.out.println("Inside B disp");
    }
}
