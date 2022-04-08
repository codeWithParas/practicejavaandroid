package com.test.kotlinpractice.kotlin_language

class I_KotlinCompanionObject {
}
// Previously in java
/*
class Singleton
{
    private static Singleton singleton;

    //Private here avoid creation of object of singleton class outside class scope.
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
*/

// In kotlin we use companion object to create singleton class
