package com.example.logicprogram.otherproblems.generalpblms;

/**
 * Created by parasmani.sharma on 15/06/2017.
 */

/**
 * Question : A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

 Expected Time Complexity: O(Log n)

 Input:

 The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array.
 The second line of each test case contains N space separated integers denoting array elements.

 Output:
 Corresponding to each test case, in a new line, print the minimum element in the array.

 Constraints:

 1 ≤ T ≤ 100
 1 ≤ N ≤ 500
 1 ≤ A[i] ≤ 1000

 Example:

 Input
 1
 5
 4 5 1 2 3

 Output
 1
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class logN_Example {
    public static Scanner scan;
    public static ArrayList<TestCaseData> listTestCases = new ArrayList<>();

    /*
    * for O(log n) we can use binary search algorithm
    * */

    public static void main(String arg[])
    {

        //inserting elements

        System.out.print("Enter Number of TestCases : ");
        scan = new Scanner(System.in);
        int numbTestCase = scan.nextInt();
        ArrayList<Integer> elements = new ArrayList<>();


        for(int i = 0 ; i<=numbTestCase-1; i++)
        {
            System.out.println("\nEnter size of TestCase " + (i+1) + " : ");
            int tsize = scan.nextInt();
            listTestCases.add(i, new TestCaseData());
            listTestCases.get(i).setTestCaseSize(tsize);

            System.out.println("Enter "+tsize+" elements for TestCase : " + (i+1));
            for (int j = 0; j < listTestCases.get(i).getTestCaseSize(); j++) {
                int element = scan.nextInt();
                elements.add(element);
            }

            listTestCases.get(i).setElements(elements);

        }

        //read sorting algorithms
        for(int i=0; i<listTestCases.size(); i++)
        {
            sortElements(listTestCases,i);
        }


        /*System.out.println("\nEnter testcase value to check its minimum number : ");
        int testCase = scan.nextInt();
        getMinimum(listTestCases, testCase);*/

    }

    private static void sortElements(ArrayList<TestCaseData> listTestCases, int index)
    {
        //using selection sort

        for(int i=0; i<listTestCases.get(index).getElements().size(); i++)
        {
            for(int j=i+1; j<listTestCases.get(index).getElements().size(); j++)
            {
                try{
                if(listTestCases.get(i).getElements().get(i) > listTestCases.get(i).getElements().get(j))
                {
                    int temp = listTestCases.get(i).getElements().get(i);
                    listTestCases.get(i).getElements().set(i, listTestCases.get(i).getElements().get(j));
                    listTestCases.get(i).getElements().set(j, temp);
                }
                }catch (Exception e){}
            }
            int j = 0 ;
            System.out.print("\nT min : "+ listTestCases.get(i).getElements().get(j));
        }

    }

    private static void getMinimum(ArrayList<TestCaseData> listTestCases, int testCase) {

        int size = listTestCases.get(testCase-1).getElements().size();
        int mid = size/2;


    }


}

class TestCaseData implements Serializable
{
    int testCaseSize ;

    ArrayList<Integer> elements = new ArrayList<>();

    int tMinElement ;

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    public int getTestCaseSize() {
        return testCaseSize;
    }

    public void setTestCaseSize(int testCaseSize) {
        this.testCaseSize = testCaseSize;
    }



    public int gettMinElement() {
        return tMinElement;
    }

    public void settMinElement(int tMinElement) {
        this.tMinElement = tMinElement;
    }
}

