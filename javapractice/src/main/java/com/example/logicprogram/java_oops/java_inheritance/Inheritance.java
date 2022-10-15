package com.example.logicprogram.java_oops.java_inheritance;

/**
 * Created by parasmani.sharma on 25/07/2017.
 */

/*
*
* REfer : http://www.geeksforgeeks.org/inheritance-in-java/
*
* Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another class.
* Types :
* 1) Single Level
* 2) Multilevel
* 3) Hierarical
* 4) Multiple (Through Interface)
* 5) Hybrid (Though Interface)
*
* Re-usability -> Inheritance supports the concept of “re-usability” :  when we want to create a new class and there is already
* a class that includes some of the code that we want, we can derive our new class from the existing class. By doing this,
* we are reusing the fields and methods of the existing class.
*
* Important Points :
*
*     Default superclass: Except Object class, which has no superclass, every class has one and only one direct superclass
*     (single inheritance). In the absence of any other explicit superclass, every class is implicitly a subclass of Object class.
*     Superclass can only be one: A superclass can have any number of subclasses. But a subclass can have only one superclass.
*     This is because Java does not support multiple inheritance with classes. Although with interfaces, multiple inheritance
*     is supported by java.
*     **CONSTRUCTOR Cannot inherited by its Child : A subclass inherits all the members (fields, methods, and nested classes) from its superclass.
*     Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be
*     invoked from the subclass.
*     Private member inheritance: A subclass does not inherit the private members of its parent class. However, if the superclass
*     has public or protected methods(like getters and setters) for accessing its private fields, these can also be used by the
*     subclass.
*
* */

class Parent {
    int a = 10;

    public int m() {

        return a;
    }
}

class Child extends Parent {
    int a = 20;
    public int m()
    {
        return a;
        //System.out.print("\nChild a : " + a);
    }
}

public class Inheritance {

    public static void main(String args[]) {
        /*Parent p  = new Child();
        int a = p.a;
        System.out.print("Main a : " + a);
        p.m();*/

        Parent o = new Child();
        //o.m();
        System.out.print("\nChild a : " + o.a);
        System.out.print("\nChild a : " + o.m());

    }

}
