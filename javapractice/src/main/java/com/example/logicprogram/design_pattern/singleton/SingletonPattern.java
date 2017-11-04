package com.example.logicprogram.design_pattern.singleton;

/**
 * Created by parasmani.sharma on 01/11/2017.
 */

class SingletonPattern
{

    public static void main(String args[])
    {
        Singleton obj = Singleton.getInstance();
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

    public static synchronized Singleton getInstance()
    {
        if(singleton == null)
            singleton = new Singleton();
        return singleton;
    }

}