package com.example.logicprogram.java_oops.java_interface;

import com.example.logicprogram.java_oops.java_interface.model.Human;

/**
 * Created by parasmani.sharma on 01/11/2017.
 */

/*
* Interface cannot be instantiated.
* This example can be refer w.r.t activity and fragment communication.
* */


public interface InterfaceTest {

    public void onResponse(Human message);

}

class Parent implements InterfaceTest{

    @Override
    public void onResponse(Human obj) {

        if (obj != null) {
            Child_Two ch = new Child_Two();
            ch.runData(obj);
        }

    }
}


class Child_One extends Parent
{
    public static void main(String args[])
    {

        Human h = new Human("Ram", 23);
        InterfaceTest ch  = new Child_One();
        //InterfaceTest interfaceTest1 = (InterfaceTest) ch;
        ch.onResponse(h);


    }
}

class Child_Two extends Parent
{
    public void runData(Human obj)
    {
        System.out.print("Name " + obj.getName() + "   Roll Nmbr : " + obj.getRollnumb());
    }

}
