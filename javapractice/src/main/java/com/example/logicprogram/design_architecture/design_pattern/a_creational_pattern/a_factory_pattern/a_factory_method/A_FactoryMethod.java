package com.example.logicprogram.design_architecture.design_pattern.a_creational_pattern.a_factory_pattern.a_factory_method;


/*
* Foctory pattern : Component responsible solely for the holesale creation of object.
* Cover the 2 gang of four design pattern.
* Problem with constructor : is the name of containing type we cannot actually define what the arguements are.
* Solution : Using factory method. (Static method)
* */

/*
* Example : Taking two different points Cartesian and Polar in x and y.
* Solution : Making two diffrent constructor (Bad Practice)
* Optimised Sol : Using factory method;
* */
class Point
{
    private double x, y;

    private Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y)
    {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta)
    {
        return new Point(Math.sin(rho), Math.cos(theta));
    }
}

public class A_FactoryMethod {

    public static void main(String[] args) {
        Point point = Point.newCartesianPoint(2,3);
        Point pointP = Point.newPolarPoint(2,3);
    }
}

