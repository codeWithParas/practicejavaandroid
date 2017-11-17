package com.example.logicprogram.oops;

/**
 * Created by parasmani.sharma on 01/11/2017.
 */

/*
* Interface cannot be instantiated.
* */

class Server implements InterfaceTest
{
    public int add(int a, int b)
    {
        return a+b;
    }
}



public interface InterfaceTest {

    public int add(int a, int b);

}

class Client{

    public static void main(String arg[])
    {
        //Server

    }

}
