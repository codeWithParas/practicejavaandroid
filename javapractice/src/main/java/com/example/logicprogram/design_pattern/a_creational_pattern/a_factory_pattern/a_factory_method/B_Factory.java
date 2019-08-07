package com.example.logicprogram.design_pattern.a_creational_pattern.a_factory_pattern.a_factory_method;

/*
* We have to now create  factory.
* SO we need to group all the factory methods. How we can group them to a separate constructor. ??
* Solution : we can put them into a separate class. This is how create a factory.
* */

class Points
{
    private double x, y;

    //making constructor as public
    private Points(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public static class Factory
    {
        public static Points newCartesianPoint(double x, double y)
        {
            return new Points(x, y);
        }

        public static Points newPolarPoint(double rho, double theta)
        {
            return new Points(Math.sin(rho), Math.cos(theta));
        }
    }
}

public class B_Factory {

    public static void main(String[] args) {
        Points point = Points.Factory.newCartesianPoint(2,3);
        Points pointP = Points.Factory.newPolarPoint(2,3);
    }
}
