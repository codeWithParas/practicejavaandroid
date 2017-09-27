package com.example.logicprogram.collection.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by parasmani.sharma on 26/09/2017.
 */

public class Test_Comparable_Comparator {

    //graph :https://stackoverflow.com/questions/9741300/charts-for-android
    public static void main(String args[]) {

        /**************--Comparable--*************************/

        //Consider Random Data
        ArrayList<Employee_Comparable> list = new ArrayList<Employee_Comparable>();
        list.add(new Employee_Comparable("Zafar", 6));
        list.add(new Employee_Comparable("Paras", 5));
        list.add(new Employee_Comparable("Amit", 2));
        list.add(new Employee_Comparable("Manish", 4));
        list.add(new Employee_Comparable("Abhinabh", 1));
        list.add(new Employee_Comparable("Kharadi", 3));

        System.out.println("Simple Array List Data : \n");
        for (Employee_Comparable e : list) {
            System.out.println(e.getEmployeeName() + "    " + e.getEmployeeNumber());
        }


        comparable_Implementation(list);





        /**************--Comparator--*************************/

        ArrayList<Employee_Comparator> list_comparator = new ArrayList<Employee_Comparator>();
        list_comparator.add(new Employee_Comparator("Zafar", 6));
        list_comparator.add(new Employee_Comparator("Paras", 5));
        list_comparator.add(new Employee_Comparator("Amit", 2));
        list_comparator.add(new Employee_Comparator("Manish", 4));
        list_comparator.add(new Employee_Comparator("Abhinabh", 1));
        list_comparator.add(new Employee_Comparator("Kharadi", 3));

        System.out.println("Simple Array List Data : \n");
        for (Employee_Comparable e : list) {
            System.out.println(e.getEmployeeName() + "    " + e.getEmployeeNumber());
        }


        comparator_Implementation(list_comparator);


    }

    private static void comparator_Implementation(ArrayList<Employee_Comparator> list_comparator) {

        System.out.println("\n\nUsing Comparator : ");
        System.out.println("\nSimple Array List Data : \n");

        //Collections.sort(list_comparator);
        for (Employee_Comparator e : list_comparator) {
            System.out.println(e.getEmployeeName() + "    " + e.getEmployeeNumber());
        }

        /*
        * Comparator Interface is used when we do not want default sorting instead
        * we want our custom sorting over default sorting. Then we should go with Comparator Interface
        * */

        System.out.println("\nSimple Array List Data : \n");

        for (Employee_Comparator e : list_comparator) {
            System.out.println(e.getEmployeeName() + "    " + e.getEmployeeNumber());
        }

    }

    private static void comparable_Implementation(ArrayList<Employee_Comparable> list) {

         /*Case : 1)
        * Explanation :
        * Since ArrayList follow insertion order but not sorting order so it doesnt implement comparable interface internally
        * So explicitly we need to provide Collections.sort(list) for Array list in order to sort the data.
        *
        * */

        System.out.println("\nCase 1 : Using Comparable Interface\n");
        System.out.println("Collection sort on Array List : \n");
        Collections.sort(list);

        for (Employee_Comparable e : list) {
            System.out.println(e.getEmployeeName() + "    " + e.getEmployeeNumber());
        }

        /*Case : 2)
        * Explanation :
        * Since TreeSet did not folllow insertion order but it follow default sorting order as it implement comparable interface internally
        * So explicitly we do not need to provide Collections.sort(list) for TreeSet in order to sort the data. But inside model
        * class we need to tell which type of sorting we need as per our data variables.
        *
        * */
        System.out.println("\n");
        System.out.println("Collection sort on Tree Set :  : \n");
        TreeSet<Employee_Comparable> listt = new TreeSet<Employee_Comparable>(list);
        for (Employee_Comparable e : listt) {
            System.out.println(e.getEmployeeName() + "    " + e.getEmployeeNumber());
        }

    }
}