package com.example.logicprogram.design_pattern.a_creational_pattern.a_factory_pattern.b_abstract_factory_pattern.a_example;

public class LoanFactory extends AbstractFactory{

    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        if(loan == null){
            return null;
        }
        if(loan.equalsIgnoreCase("Home")){
            return new Bussiness();
        } else if(loan.equalsIgnoreCase("Business")){
            return new Education();
        } else if(loan.equalsIgnoreCase("Education")){
            return new Car();
        }
        return null;
    }
}

abstract class Loan {
    protected double rate;

    abstract void getInterestRate(double rate);

    public void calculateLoanPayment(double loanamount, int years) {
        /*
              to calculate the monthly loan payment i.e. EMI

              rate=annual interest rate/12*100;
              n=number of monthly installments;
              1year=12 months.
              so, n=years*12;

            */

        double EMI;
        int n;

        n = years * 12;
        rate = rate / 1200;
        EMI = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1)) * loanamount;

        System.out.println("your monthly EMI is " + EMI + " for the amount" + loanamount + " you have borrowed");
    }
}

class Bussiness extends Loan
{
    @Override
    public void getInterestRate(double r) {
        rate = r;
    }
}

class Education extends Loan
{
    @Override
    public void getInterestRate(double r) {
        rate = r;
    }
}

class Car extends Loan
{
    @Override
    public void getInterestRate(double r) {
        rate = r;
    }
}



