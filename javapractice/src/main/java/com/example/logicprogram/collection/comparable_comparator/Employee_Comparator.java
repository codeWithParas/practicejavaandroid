package com.example.logicprogram.collection.comparable_comparator;

import java.util.Comparator;

/**
 * Created by parasmani.sharma on 26/09/2017.
 */

public class Employee_Comparator implements Comparator<Employee_Comparator> {

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


    public Employee_Comparator(String name, int number)
    {
        this.employeeName  = name;
        this.employeeNumber = number;
    }

    @Override
    public int compare(Employee_Comparator e1, Employee_Comparator e2) {
        return e1.getEmployeeName().compareTo(e2.getEmployeeName());
    }
}
