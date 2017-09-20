package com.example.logicprogram.datastructure.LinearDS;

/**
 * Created by parasmani.sharma on 07/06/2017.
 */

public class InfixToPostfix
{

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack stack = new Stack();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                // If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }



    // Driver method
    public static void main(String[] args)
    {
        String exp = "a+b";
        System.out.println(infixToPostfix(exp));
    }

}

class Stack
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
