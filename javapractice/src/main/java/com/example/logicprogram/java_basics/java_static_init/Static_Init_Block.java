package com.example.logicprogram.java_basics.java_static_init;

/**
 * Created by parasmani.sharma on 18/11/2017.
 */

public class Static_Init_Block extends Parent{

    static {
        System.out.println("1 inside child static block");
    }

    Static_Init_Block() {
        System.out.println("3 inside child constructor of child");
    }

    {
        System.out.println("3 inside child initialization block");
    }

    public static void main(String[] args) {

        System.out.println("00000 inside main");
        new Static_Init_Block();
        //new Static_Init_Block();

    }

}


class Parent {
    static {
        System.out.println("1 inside parent Static block");
    }

    {
        System.out.println("2 inside parent initialisation block");
    }

    Parent() {
        System.out.println("2 inside parent constructor");
    }
}
