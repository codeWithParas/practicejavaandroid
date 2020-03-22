package com.example.logicprogram.java_oops.java_abstraction;

import java.util.Scanner;

/**
 * Created by parasmani.sharma on 25/07/2017.
 */

/*
* Abstraction :
*
*
* Why we use : To provide security at coding level we use abstraction.
*
* Best example to analyze and think when you talk about Parent-Server based interaction using Abstract.
* This type of interaction we have done in Aidl example - (Aidl_Test_Cover)
* Try to assume this program as client-server interaction. Here you can consider that Bank Abstract class is client side
* and its implementation is on server side i.e via SBI server.
* Here we have shown abstract class only at Parent Side. But in real world senerio - one Abstract class (with the
* same name as Parent Abstract class) is also present at Server Side (as like client side Abstract class) as we have done in
* our AIDl_Test_Cover project(considered Interface in this case). By this we can analyze that a pipeline will create for communication between both
* Parent and Server(acts like mirror - which uses shared memory concept on same device for communication between two
* Apps using IBinder Interface of Android OS).
*
* By refering & anylising below program we can assume a ery good example of ATM Machine.
* A very good example : ATM machine : If You insert any type of bank card it will redirect you to the desire card related bank server and
* you can withrawal and deposite money . So the ATM machine is providing abstraction at this level by connecting with numbers of bank.
*
* BankServer (SBI       BOB        Punjab        etc.)
*               \        |           |            /
*                \       |           |           /
*                 -------------------------------
*                               |
*                               |
*                          ATM Machine (Provide Bank Abstraction Level)
*                               |
*                               |
*                       User Input ATM Card
*
* */

class SBI extends Bank
{
    private int cash = 10000;
    @Override
    public int withdrawelAmount(int i) {
        if(i < 1200)
        {
            System.out.println("Cash withdrawel successfully !!");
            cash = cash-i;
            return cash;

        }else {
            System.out.println("\nYou are not allowed");
        }
        return 0;
    }

    @Override
    public void getLogin() {
        System.out.println("\nUser Logged In Successfully !!");
    }

    @Override
    public void failed() {
        return;
    }

}

class Failed extends Bank
{

    @Override
    public int withdrawelAmount(int i) {
        return 0;
    }

    @Override
    public void getLogin() {

        System.out.println(" Failed");
    }

    @Override
    public void failed() {
        System.out.println("User connection Faiiled");
        System.out.println("***** Wrong Password *********");
    }
}


/************Top Server Side********************/



/************Down Parent Side********************/

abstract class Bank
{
    public abstract int withdrawelAmount(int i);
    public abstract void getLogin();
    public abstract void failed();
}

public class AbstractionExample {

    public static void main(String arg[])
    {

        /*
        * when user authentication is successfull
        * then pass SBI object
        * else pass failed object
        *
        * Suppose password is : 12345
        * */

        System.out.println("Enter Password to login in bank : " );
        Scanner scan = new Scanner(System.in);
        int passsword = scan.nextInt();

        if(passsword == 12345)
        {
            System.out.println("Your account balance is : 10000" );
            SBI success = new SBI();
            connectBank(success);
        }
        else
        {
            Failed failed = new Failed();
            connectBank(failed);
        }

    }

    private static void connectBank(Object obj)
    {
        if(obj instanceof SBI)
        {
            Bank user1 = (SBI)obj;
            user1.getLogin();
            int amountLeft = user1.withdrawelAmount(1000);
            System.out.println("\nRemaining Account Balance : " + amountLeft);
            System.out.println("\n\n........Session End.......");
        }else
        {
            Bank user1 = (Failed)obj;
            user1.failed();
        }
    }

}
