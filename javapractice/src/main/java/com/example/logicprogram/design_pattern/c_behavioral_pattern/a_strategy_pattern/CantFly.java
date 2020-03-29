package com.example.logicprogram.design_pattern.c_behavioral_pattern.a_strategy_pattern;

//Class used if the Animal can't fly

class CantFly implements Flys{

    public String fly() {

        return "I can't fly";

    }

}
