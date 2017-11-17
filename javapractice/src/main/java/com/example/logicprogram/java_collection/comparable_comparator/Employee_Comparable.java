package com.example.logicprogram.java_collection.comparable_comparator;

/**
 * Created by parasmani.sharma on 26/09/2017.
 */

public class Employee_Comparable implements Comparable<Employee_Comparable> {

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


    public Employee_Comparable(String name, int number)
    {
        this.employeeName  = name;
        this.employeeNumber = number;
    }


    @Override
    public int compareTo(Employee_Comparable o) {
        return this.employeeName.compareTo(o.employeeName);
    }
}
