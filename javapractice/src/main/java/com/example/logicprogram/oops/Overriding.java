package com.example.logicprogram.oops;

/**
 * Created by parasmani.sharma on 10/05/2017.
 */


class Overriding
{
    /*
    * it is an dynamic polymorphic process in which overriding of method decided at the time of runtime.
    * */

    public static void main(String args[])
    {
        // ChildClass obj = new ChildClass();
        ParentClass objj = new ChildClass();
        //obj.method();
        objj.method();
        //objj.run();
    }

}

class ParentClass
{
    public ParentClass()
    {
        System.out.println("ParentClass class Constructor");
    }

    public void method()
    {
        System.out.println("ParentClass Class method");
    }

}

class ChildClass extends ParentClass
{
    public ChildClass()
    {
        System.out.println("ChildClass class constructor");
    }

    public void method()
    {

        //super.method();
        System.out.println("ChildClass Class method");
    }

   /* public void run()
    {
        System.out.println("ChildClass class run method");
    }*/

}
