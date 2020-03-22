package com.example.logicprogram.design_pattern.a_creational_pattern.singleton;

/**
 * Created by parasmani.sharma on 01/11/2017.
 */

class SingletonPattern
{

    public static void main(String args[])
    {
        Singleton obj = Singleton.getInstance();
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
    }


}

/*
* Link  :  http://www.geeksforgeeks.org/singleton-design-pattern/
* The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
* Using synchronized will make getInstance() method thead safe. Otherwise different-different object will be created for different threads.
*
*
* */

class Singleton
{
    private static Singleton singleton;

    private Singleton()
    {

    }

    /*
    * here :
    * static is used to provide class level lock.
    * synchronised is used for thread safety.
    * */
    public static synchronized Singleton getInstance()
    {
        if(singleton == null)
        {
            System.out.print("Object is Initialized inside singleton class\n");
            singleton = new Singleton();
            return singleton;
        }
        else
        {
            System.out.println("Object was already initialized.");
            return singleton;
        }

    }

}