package com.example.logicprogram.collection.comparable_comparator;

import com.example.logicprogram.collection.Sorting_Comparamble_Comparator;

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


        //comparable_Implementation(list);





        /**************--Comparator--*************************/

        /*
        * Why we use comparator ? In which scenerio we go with coparator() interface ?
        *
        * Ans : Please Understand Clearly
        * Consider two bussiness logic case first -> A & Second -> B
        * Since we do our sorting with comparable also but we can use camparator also..Y ?..lets suppose
        * In our one of model class (in project) we have lots of data. At the time of development we need to sort
        * this data to satisfy any bussiness logic(A). So inside our model class we can implement comparable interface
        * and override compareTo() method , inside compareTo() method we can give our sorting algo. And overall after
        * completion of project we call this sorting as default sorting which will be mendatory case.
        *     Now suppose after some days we need to make an update in list of data that we have sorted before to
        *     satisfy second bussiness logic i.e B. So to do this updation without touching (effecting) previous
        *     implementation we will add-one B bussiness logic with A bussiness logic. So to do dis we can use
        *     comparator interface. Comparator interface will make use of previous model class (which is
        *     implementing comparable interface already by default) only we need to provide another sorting method
        *     i.e compare() method and inside compare method we will execute second bussiness logic "B". So we call
        *     this implementation as custom sorting.(we called this "Custom sorting" becouse we considering
        *     first-level-sorting(comaparable) as default which is used by comparator sorting method.)
        *
        *
        * Note**: If we use both sorting together (comparable and comparator) for one model class. Then we use term
        * -----> *for comparable interface as default sorting technique. And
        * -----> *for comparator interface as custom sorting technique.
        *
        * Hence ,
        * Comparator Interface : When We want our custom sorting over default sorting.
        *                       Then we should go with Comparator Interface
        *
        * */

        System.out.println("\nCase  : Using Comparator Interface\n");

        Collections.sort(list,new Employee_Comparator());   // using

        for (Employee_Comparable std :list) {
            System.out.println(std.getEmployeeName()+ "    " + std.getEmployeeNumber());
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
        * Note : All wrapper class (Ex : String.class , Integer.class, Float.class) implements comparable interface. Inorder to
        *        provide default sorting order.
        *
        *
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



        /*
        * Hence by using Collection.sort(arraylist) we cant provide custom sorting , only default sorting
        * for arraylist case.
        * But using Treeset we can provide custom sorting.
        *
        * */

    }
}