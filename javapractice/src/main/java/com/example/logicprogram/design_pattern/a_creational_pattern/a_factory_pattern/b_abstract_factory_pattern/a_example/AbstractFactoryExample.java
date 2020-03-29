package com.example.logicprogram.design_pattern.a_creational_pattern.a_factory_pattern.b_abstract_factory_pattern.a_example;

/*
 * Refer : https://www.javatpoint.com/abstract-factory-pattern
 *
 * About : Abstract Factory Pattern says that just define an interface or abstract class
 * for creating families of related (or dependent) objects but without specifying their
 * concrete sub-classes.
 * Example : Refer image : abstarctfactorypattern.png
 * The following example illustrate loan amount calculation of a bank.
 * Select any loan w.r.t bank from different available banks. Each loan has its own set of emi value.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFactoryExample {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the name of Bank from where you want to take loan amount: ");
        String bankName = null;
        try {
            bankName = br.readLine();

            System.out.print("\n");
            System.out.print("Enter the type of loan e.g. home loan or business loan or education loan : ");

            String loanName = br.readLine();
            AbstractFactory bankFactory = FactoryCreater.getFactory("Bank");
            Bank b = bankFactory.getBank(bankName);

            System.out.print("\n");
            System.out.print("Enter the interest rate for " + b.getBankName() + ": ");

            double rate = Double.parseDouble(br.readLine());
            System.out.print("\n");
            System.out.print("Enter the loan amount you want to take: ");

            double loanAmount = Double.parseDouble(br.readLine());
            System.out.print("\n");
            System.out.print("Enter the number of years to pay your entire loan amount: ");
            int years = Integer.parseInt(br.readLine());

            System.out.print("\n");
            System.out.println("you are taking the loan from " + b.getBankName());

            AbstractFactory loanFactory = FactoryCreater.getFactory("Loan");
            Loan l = loanFactory.getLoan(loanName);
            l.getInterestRate(rate);
            l.calculateLoanPayment(loanAmount, years);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








