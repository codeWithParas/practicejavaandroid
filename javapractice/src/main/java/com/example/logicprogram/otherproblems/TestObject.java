package com.example.logicprogram.otherproblems;

/**
 * Created by parasmani.sharma on 22/05/2017.
 */

public class TestObject {

    /*Two stages one after the other :
    * Note : till "new TestObject" parsing takes place. At this point class is loaded :
    * 1) first - static block and static variables initialized and initialized only at one time .
    * 2) second - init block and init variables initialized and can be initialized number of times as much "new TestObject" is called.
    * Note : when "new TestObject()" is parsed completely : At this point :
    * 3) third - constructor of the class is called and object has been created number of times as much "new TestObject()" is called .
    *
    * */


    //TestObject test = new TestObject();
    //TestObject obj;
    int a;
    static int b;

    {
        a = 0;
        System.out.println("a = " +a);
        a = 1;
        System.out.println("init");
    }

    static
    {
        System.out.println("b = " +b);
        b = 1;
        System.out.println("static");
    }

    TestObject(){
        System.out.println("a = " +a);
        System.out.println("Constructor");
    }

    //TestObject test = new TestObject();



    public int show()
    {
        System.out.println("Show");
        //return  (true ? null : 0);
        return  0;
    }


    public static void main(String arg[])
    {

        for(int i=0; i<5; i++)
        {
            TestObject obj = new TestObject();
        }

        //TestObject obj ;
        //obj.show();
    }


}
