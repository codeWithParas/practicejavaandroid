package com.example.logicprogram.datastructure.Knapsack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by parasmani.sharma on 24/05/2017.
 */

public class KnapSackProblem {

    private Item item;
    private int knapSackWeight = 35;

    public ArrayList<Item> nItems = new ArrayList<Item>(Arrays.asList(

            //item(itemNumber, weight, profit)
            new Item(1, 2, 10),
            new Item(2, 3, 9),
            new Item(3, 6, 12),
            new Item(4, 7, 14),
            new Item(5, 2, 4),
            new Item(6, 8, 30),
            new Item(7, 2, 40),
            new Item(8, 1, 20),
            new Item(9, 2, 22),
            new Item(10, 4, 20)

    ));

    public ArrayList<Integer> knapSackItems = new ArrayList<>();

    public static void main(String args[]) {

        System.out.println("Suppose we have 10 number of items as : ");

        KnapSackProblem obj = new KnapSackProblem();
        ArrayList<Item> items = new ArrayList<Item>();
        items.addAll(obj.nItems);

        while(obj.nItems.size()>=1)
        {
            for (int i = 0; i < obj.nItems.size(); i++) {
                obj.item = getMaxProfitDensityObject(obj.nItems, obj.nItems.get(i));
            }

            System.out.println("Data + " + obj.item.getiNumber());
            calculateKnapSackWeight_Then_AddObject(obj.item, obj);
        }

            /*if(obj.item.getiWeight() < obj.knapSackWeight) {

            }*/


        //obj.displayData(obj);
    }

    private static void calculateKnapSackWeight_Then_AddObject(Item item, KnapSackProblem obj) {

        int currentWeightof_KnapSack = obj.knapSackWeight;
        System.out.println("currentWeightof_KnapSack + " + currentWeightof_KnapSack);
        if (item.getiWeight() < obj.knapSackWeight) {
            obj.knapSackItems.add(item.getiNumber());
            obj.knapSackWeight = obj.knapSackWeight - item.getiWeight();
            obj.nItems.remove(item);
        }
    }

    private static void displayData(KnapSackProblem obj) {

        System.out.println("Item Added in KnapSack   ==>    " + Arrays.toString(obj.knapSackItems.toArray()));
    }

    private static Item getMaxProfitDensityObject(ArrayList<Item> items, Item item) {

        return items.stream().max((item1, item2) -> {

            int flag = 0;

            if (item1.compareProfitDensityRatio(item) > item2.compareProfitDensityRatio(item))
                flag = 1;
            else flag = -1;

            return flag;
        }).get();
    }
}
