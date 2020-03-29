package com.example.logicprogram.design_architecture.solid_design_principle;

interface Machine
{
    void print();
    void scan();
    void fax();
}

public class FourthInterfaceSegregatonPrinciple implements Print, Scan{
    /*
     * Segragating the Machine interface separately
     * */

    @Override
    public void printing() {

    }

    @Override
    public void scanning() {

    }
}

interface Print
{
    void printing();
}

interface Scan
{
    void scanning();
}