package com.example.logicprogram.otherproblems;

/**
 * Created by zafar.imam on 31-05-2017.
 */

public class SynchronizeTest {

    synchronized static  void testSync(int i){
        for (int j = 0; j < 10; j++) {
            System.out.println("Value : "+i);
        }
    }
}

class ThreadOne extends Thread{

    SynchronizeTest sync;

    public ThreadOne(SynchronizeTest sync) {
        this.sync = sync;
    }

    public void run(){
        sync.testSync(1);
    }
}

class ThreadTwo extends Thread{
    SynchronizeTest sync;

    public ThreadTwo(SynchronizeTest sync) {
        this.sync = sync;
    }

    public void run(){
        sync.testSync(2);
    }
}

class ThreadThree extends Thread{
    SynchronizeTest sync;

    public ThreadThree(SynchronizeTest sync) {
        this.sync = sync;
    }

    public void run(){
        sync.testSync(3);
    }
}

class MainTest {
    public static void main(String args[]){
        SynchronizeTest sync = new SynchronizeTest();
        SynchronizeTest sync1 = new SynchronizeTest();
        ThreadOne t1 = new ThreadOne(sync);
        ThreadTwo t2 = new ThreadTwo(sync1);
        ThreadThree t3 = new ThreadThree(sync);
        t1.start();
        t2.start();
        t3.start();
    }
}