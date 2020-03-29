package com.example.logicprogram.design_architecture.design_pattern.a_creational_pattern.a_factory_pattern.b_abstract_factory_pattern.a_example;

public class FactoryCreater
{
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }

}
