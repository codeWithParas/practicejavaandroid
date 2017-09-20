package com.example.logicprogram.otherproblems;

/**
 * Created by parasmani.sharma on 10/05/2017.
 */


//In real scenario, method is called by programmer or user
class TestAbstraction
{
    public static void main(String args[])
    {
        Shape s=new Circle1();//In real scenario, object is provided through method e.g. getShape() method
        s.draw();
    }
}


abstract class Shape
{

    public Shape()
    {
        System.out.println("Shape Constructor");
    }
    abstract void draw();
}


//In real scenario, implementation is provided by others i.e. unknown by end user
class Rectangle extends Shape
{
    void draw(){System.out.println("drawing rectangle");}
}


class Circle1 extends Shape
{
    public Circle1()
    {
        System.out.println("Circle1 Constructor");
    }

    void draw()
    {
        System.out.println("drawing circle");
    }
}




