package com.example.logicprogram.java_oops.java_interface.model;

/**
 * Created by parasmani.sharma on 23/11/2017.
 */

public class Human  {

    String name;

    public Human(String name, int i) {
        this.name = name;
        this.rollnumb = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollnumb() {
        return rollnumb;
    }

    public void setRollnumb(int rollnumb) {
        this.rollnumb = rollnumb;
    }

    int rollnumb;

}
