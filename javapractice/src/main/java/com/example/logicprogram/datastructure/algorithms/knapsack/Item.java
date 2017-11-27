package com.example.logicprogram.datastructure.algorithms.knapsack;

/**
 * Created by parasmani.sharma on 24/05/2017.
 */

public class Item
{

    private int iWeight;
    private int iProfit;
    private int iNumber;

    public Item(int iNumber, int iWeight, int iProfit)
    {
        this.iNumber = iNumber;
        this.iWeight = iWeight;
        this.iProfit = iProfit;
    }

    public int getiWeight() { return this.iWeight; }

    public int getiProfit() { return this.iProfit; }

    public int getiNumber() { return  this.iNumber; }

    public int compareProfitDensityRatio(Item item)
    {
        if(item.getiProfit()/item.getiWeight() > this.getiProfit()/this.getiWeight())
        {
            return item.getiProfit()/item.getiWeight();
        }else {
            return this.getiProfit()/this.getiWeight();
        }
    }

}
