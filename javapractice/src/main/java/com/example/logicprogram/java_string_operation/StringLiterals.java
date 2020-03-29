package com.example.logicprogram.java_string_operation;

public class StringLiterals {

    public static void main(String[] args) {

        if(("a" + "b" + "c").intern() == "abc")
        {
            System.out.println("True");
        }

    }
}
