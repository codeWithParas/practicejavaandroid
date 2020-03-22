package com.example.logicprogram.design_pattern.a_creational_pattern.a_factory_pattern.a_factory_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//refer : https://www.javatpoint.com/factory-method-design-pattern

/*
* Follow Dynamic Polymorphism :
* A Factory Pattern or Factory Method Pattern says that just define an interface or abstract
* class for creating an object but let the subclasses decide which class to instantiate.
* In other words, subclasses are responsible to create the instance of the class.
* The Factory Method Pattern is also known as Virtual Constructor.
* */

public class FactoryPatternClient {

    public static void main(String[] args) {

        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("Enter the name of plan for which the bill will be generated: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String planName= null;
        int units = 0;
        try {
            planName = br.readLine();
            System.out.print("Enter the number of units for bill will be calculated: ");
            units=Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


        Plan p = planFactory.getPlan(planName);
        //call getRate() method and calculateBill()method of DomesticPaln.

        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
        p.getRate();
        p.calculateBill(units);
    }
}


//////////////////////////////////////////////////////////

class GetPlanFactory{

    //use getPlan method to get object of type Plan
    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        }
        else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

////////////////////////////////////////////////

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class  DomesticPlan extends Plan{
    //@override
    public void getRate(){
        rate=3.50;
    }
}

class  CommercialPlan extends Plan {
    //@override
    public void getRate() {
        rate = 7.50;
    }
}

class  InstitutionalPlan extends Plan {
    //@override
    public void getRate() {
        rate = 5.50;
    }
}