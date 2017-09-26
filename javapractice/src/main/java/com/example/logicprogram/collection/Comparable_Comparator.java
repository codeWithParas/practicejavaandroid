package com.example.logicprogram.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sun.nio.cs.StreamDecoder;

/**
 * Created by parasmani.sharma on 22/09/2017.
 */

public class Comparable_Comparator  {

    public static void main(String args[])
    {

        List<Student> list = new ArrayList<Student>();

        list.add(new Student("Shaggy", 3));
        list.add(new Student("Lacy", 2));
        list.add(new Student("Roger", 10));
        list.add(new Student("Tommy", 4));
        list.add(new Student("Tammy", 1));
        //Collections.sort(list);   // Sorts the array list

        for(Student a: list)   // printing the sorted list of names
            System.out.print(a.getName() + ", ");

        // Sorts the array list using comparator
        Collections.sort(list, new Student());
        System.out.println(" ");

        for(Student a: list)   // printing the sorted list of ages
            System.out.println(a.getName() +"  : "+ a.getRollnumber() + ", ");

    }

}
