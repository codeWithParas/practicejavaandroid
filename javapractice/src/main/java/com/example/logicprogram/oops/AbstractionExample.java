package com.example.logicprogram.oops;

/**
 * Created by parasmani.sharma on 25/07/2017.
 */

/*
* Best example to analyze and think when you talk about Client-Server based interaction using Abstract.
* This type of interaction we have done in Aidl example - (Aidl_Test_Cover)
* Try to assume this program as client-server interaction. Here you can consider that Bank Abstract class is client side
* and its implementation is on server side i.e SBI server.
* Here we have shown abstract class only at Client Side. But in real world senerio one Abstract class (with the
* same name as Client Abstract class) is also present at Server Side (as like client side Abstract class) as we have done in
* our AIDl_Test_Cover project. By this we can analyze that a pipeline will create for communication between both
* Client and Server(acts like mirror - which uses shared memory concept on same device for communication between two
* Apps using IBinder Interface of Android OS).
* */

class SBI extends Bank
{
    private int cash = 1000000;
    @Override
    public int withdrawelAmount(int i) {
        if(i < 1200)
        {
            System.out.println("Cash withdrawel successfully !!");
            cash = cash-i;
            System.out.println("\nRemaining Account Balance : " + cash);
            return i;

        }else {
            System.out.println("\nYou are not allowed");
        }
        return 0;
    }

    @Override
    public void getLogin() {
        System.out.println("\nUser Logged In Successfully !!");
    }

}

abstract class Bank
{
    public abstract int withdrawelAmount(int i);
    public abstract void getLogin();
}


public class AbstractionExample {

    public static void main(String arg[])
    {
        Bank user1 = new SBI();
        user1.getLogin();
        user1.withdrawelAmount(1000);



    }



}
