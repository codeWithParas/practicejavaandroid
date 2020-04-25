package com.example.logicprogram.java_oops.java_interface.functional_interfaces.custom_functional_interface;

public class UseCustomFunctionalInterface {

    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface = str -> System.out.println(str);
        myFunctionalInterface.printMessage("Hello Created Custom Lambda Function.");
    }
}
