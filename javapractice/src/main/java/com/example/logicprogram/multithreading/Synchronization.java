package com.example.logicprogram.multithreading;

/**
 * Created by parasmani.sharma on 31/05/2017.
 */

public class Synchronization {

    public static void main(String arg[])
    {
        Display d1 = new Display();
        //Display d2 = new Display();
        Mythread1 t1 = new Mythread1(d1);
        Mythread2 t2 = new Mythread2(d1);
        t1.start();
        t2.start();

        System.out.println("\nMain Method");

    }
}


class Display
{
  public static synchronized void display(String threadName)
  {

      for(int i=0; i<=5; i++)
      {
          System.out.println("Display Method Executed By " + threadName);
          try {
              Thread.sleep(3000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
}

class Mythread1 extends Thread
{
    Display d;

    public Mythread1(Display d) {
        this.d = d;
    }

    public void run()
    {
        d.display("Mythead 1");
    }
}

class Mythread2 extends Thread
{
    Display d;

    public Mythread2(Display d) {
        this.d = d;
    }

    public void run()
    {
        d.display("Mythead 2");
    }
}