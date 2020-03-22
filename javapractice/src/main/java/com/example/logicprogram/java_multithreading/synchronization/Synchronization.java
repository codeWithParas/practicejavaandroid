package com.example.logicprogram.java_multithreading.synchronization;

/**
 * Created by parasmani.sharma on 31/05/2017.
 */

public class Synchronization {

    /*
    *.......1) What is Synchronization ?  2) Why we use ?  3) Where we can use ?...........
    *
    * 1) If more than one threads are executing on one resource then there it might inconsistency problem
    * due to which our business logic will not work as expected and we will get irregular output. (as in below example
    * if we remove Synchronized keyword from display method we will get irregular o/p).So to avoid this we
    * use Synchronization Concept.
    *
    * Synchronization only work with methods and blocks (ex : static block) .
    * Synchronization concept uses Two Types of Locks : a) Object Level Lock  (b) Class Level Lock
    *
    * a)Object Level Lock : Apply to Case 2 only
    *   Case 1: Without Synchronization : If two threads(t1 & t2) acting on same object(d1) then -> Irregular O/P
    *   Case 2: Using Synchronization : If two threads(t1 & t2) acting on same object(d1) then -> Regular O/P
    *
    *   Explanation : Case 2 : When method display() is Synchronized and only one object is available.
    *                 --> then t1 starts : get the object lock A_FactoryMethod
    *                     execute -->  synchronized display() method
    *                     t1 execution finished.
    *                     t1 Releases Object Lock.
    *                 --> then t2 starts : get the Object Lock Second
    *                     execute --> synchronized display() method
    *                     t2 execution finished.
    *                     t2 Releases Object Lock.
    *
    *                     Output : Regular  (Expected)
    *
    *                 Case 1 : When method display() is not Synchronized
    *                 (or vice-versa : Thread Scheduler dependent)
    *                 --> t1 starts : start execution
    *                 --> t2 starts : start execution
    *
    *                     Output : Irregular Output  (Not as Expected)
    *
    *                 Case 3 : When method display() is Synchronized and different two objects are available.
    *
    *                 --> t1 is having d1 object lock.
    *                 --> t2 is having d2 object lock.
    *
    *                 Output : Irregular Output (In this case there is no meaning to use Synchronized since two different object).
    *                 So, we can solve this by using  " static synchronized with any method or block "
    *
    *                 Case 4 : When method display() is static synchronized and different two objects are available.
    *
    *                 --> t1 is having d1 object lock.
    *                 --> t2 is having d2 object lock.
    *
    *                 Output : Reegular Output   ...... Why ?
    *
    *                 Because now in this case each thread will be get class level lock.
    *
    *
    *
    * */



    public static void main(String arg[])
    {
        /*
        * Check class level lock and object level lock by using two different object of display();
        * */

        Display d1 = new Display();
        Display d2 = new Display();
        //Display d3 = new Display();
        Mythread1 t1 = new Mythread1(d1);
        Mythread2 t2 = new Mythread2(d2);
        //Mythread3 t3 = new Mythread3(d3);
        t1.start();
        t2.start();
        //t3.start();

        System.out.println("\nMain Method");

    }
}


class Display
{
    /*
    * use static here to get class level lock
    * */

    /*
    * The below concept used in Singleton pattern : static is used to provide double security check.
    * By using both "static synchronized" the 2 security check is :-
    *           1) synchronizd : Thread Safety
    *           2) static (class level lock): Making methods and variable common for different created objects
    *           of the class. So in method display_2() : the value of n will be used by both objects d1 and d2.
    *           So, t1(d1) -> n = 10 and t2(d2) => n=11 ; (static case)
    *               t1(d1) -> n = 10 and t2(d2) => n=10 ; (non static case)
    * */

  public static synchronized void display(String threadName)
  {

      for(int i=0; i<=3; i++)
      {
          System.out.println("Display Method Executed By " + threadName);
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }

    static int n =10;
  public static synchronized void display_2()
  {

      System.out.println(n);
      n++;
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
        //d.display("Mythread 1");
        d.display_2();
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
        //d.display("Mythread 2");
        d.display_2();
    }
}

class Mythread3 extends Thread
{
    Display d;

    public Mythread3(Display d) {
        this.d = d;
    }

    public void run()
    {
        d.display("Mythread 3");
    }
}