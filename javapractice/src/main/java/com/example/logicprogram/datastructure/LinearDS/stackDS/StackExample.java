package com.example.logicprogram.datastructure.LinearDS.stackDS;

/**
 * Created by parasmani.sharma on 07/06/2017.
 */

public class StackExample
{
    public static void main(String args[])
    {

        StackBucket s = new StackBucket();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");

    }




}

class StackBucket
{
    int max = 100;
    int top;
    int[] a = new int[max];

    public boolean push(int i) {

        if (top >= max)
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else
        {
            a[++top] = i;
            return true;
        }

    }

    int pop()
    {
        if (top < 0)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            int x = a[top--];
            return x;
        }
    }

    public boolean isEmpty() {

        return top == -1 ;
    }

    public char peek() {
        return (char) a[top];
    }
}
