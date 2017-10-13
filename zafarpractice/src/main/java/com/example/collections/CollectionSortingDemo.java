package com.example.collections;

/**
 * Created by zafar.imam on 06-10-2017.
 */

import java.util.Arrays;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zafar.imam on 22-08-2017.
 */

public class CollectionSortingDemo {

    public static void main(String arg[]){

        Employee[] emp = new Employee[4];
        emp[0] = new Employee(1,"name1",24,30000);
        emp[1] = new Employee(4,"same",35,40000);
        emp[2] = new Employee(2,"dame",22,80000);
        emp[3] = new Employee(6,"zame",65,20000);

        Arrays.sort(emp);//default sorting for ojbect

        System.out.println("Default Sorting for empArray:  "+Arrays.toString(emp));

        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return (int) (e1.getSalary()- e2.getSalary());
            }
        };

        Comparator<Employee> ageComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getAge()- e2.getAge();
            }
        };

        Comparator<Employee> nameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return employee.getName().compareTo(t1.getName());
            }
        };

        Arrays.sort(emp,salaryComparator);
        System.out.println("Sorting using salaryComparator:"+Arrays.toString(emp));

        Arrays.sort(emp,nameComparator);
        System.out.println("Sorting using nameComparator:  "+Arrays.toString(emp));

        Arrays.sort(emp,ageComparator);
        System.out.println("Sorting using ageComparator:   "+Arrays.toString(emp));
    }
}

