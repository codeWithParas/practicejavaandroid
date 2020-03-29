package com.example.logicprogram.design_architecture.design_pattern.a_creational_pattern.a_factory_pattern.b_abstract_factory_pattern.a_example;

public class BankFactory extends AbstractFactory{

    public Bank getBank(String bank){
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("SBI")){
            return new Sbi();
        } else if(bank.equalsIgnoreCase("HDFC")){
            return new Hdfc();
        } else if(bank.equalsIgnoreCase("KOTAK")){
            return new Kotak();
        }
        return null;
    }
    public Loan getLoan(String loan) {
        return null;
    }
}

interface Bank
{
    String getBankName();
}

class Sbi implements Bank
{
    private String bankName;

    Sbi()
    {
        this.bankName = "SBI";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}

class Hdfc implements Bank
{
    private String bankName;

    Hdfc()
    {
        this.bankName = "HDFC";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}

class Kotak implements Bank
{
    private String bankName;

    Kotak()
    {
        this.bankName = "Kotak";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}
