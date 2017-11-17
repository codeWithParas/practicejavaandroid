package com.example.logicprogram.java_collection;


import java.util.Comparator;

/**
 * Created by parasmani.sharma on 20/09/2017.
 */

public class Student implements Comparator<Student>/*, Comparable<Student> */{
    public Student(String name, int roll)
    {
        this.name = name;
        this.rollnumber = roll;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(int rollnumber) {
        this.rollnumber = rollnumber;
    }

    String name;
    int rollnumber;

    public Student()
    {

    }


    @Override
    public int compare(Student lhs, Student rhs) {

        //+1 after
        //-1 before

        return lhs.getRollnumber()-rhs.getRollnumber();

        //return 0; //duplicate
    }

    public int compareName(Student one, Student two)
    {
        return one.getName().compareTo(two.getName());
    }

    /*@Override
    public int compareTo(Student another) {
        return this.getRollnumber()-another.getRollnumber();
    }*/
}
