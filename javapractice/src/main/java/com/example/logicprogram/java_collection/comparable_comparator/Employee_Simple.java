package com.example.logicprogram.java_collection.comparable_comparator;

/**
 * Created by parasmani.sharma on 26/09/2017.
 */

public class Employee_Simple {

    String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    int employeeNumber;


    public Employee_Simple(String name, int number)
    {
        this.employeeName  = name;
        this.employeeNumber = number;
    }

}
