package com.example.logicprogram.java_collection.comparable_comparator;

import java.util.Comparator;

/**
 * Created by parasmani.sharma on 26/09/2017.
 */

public class Employee_Comparator implements Comparator<Employee_Comparable> {

    @Override
    public int compare(Employee_Comparable e1, Employee_Comparable e2) {

        /*
        * Sorting on name basis
        * here called : Custom Sorting
        * */
        return e1.getEmployeeName().compareTo(e2.getEmployeeName());
    }


}
