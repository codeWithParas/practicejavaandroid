package com.example.collections;

/**
 * Created by zafar.imam on 22-08-2017.
 */

public class Employee implements Comparable<Employee>{//Comparator<Employee>{//

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    //this is overriden to print the user friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }

       /* @Override
        public int compare(Employee employee, Employee t1) {
            return employee.getAge()- t1.getAge();
        }*/

    @Override
    public int compareTo(Employee employee) {
        return this.id - employee.id;
    }
}
