package com.example.logicprogram.design_architecture.design_pattern.a_creational_pattern.a_factory_pattern.b_abstract_factory_pattern.a_example;

abstract class AbstractFactory {

    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}
