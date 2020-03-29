package com.example.logicprogram.design_pattern.a_creational_pattern.a_factory_pattern.b_abstract_factory_pattern;


import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

/*
*
* Other refer example : http://www.newthinktank.com/2012/09/abstract-factory-design-pattern/
* */

/*
* A pattern which makes a correspondence between the hierarchy of object and hiearachy of factories which are
* used to construct that object.
*
* */
public class AbstractFactory {

    public static void main(String[] args) {
        new HotDrinkMachine();
    }

}

//1st level hierarchy
interface HotDrink
{
    void consume();
}

class Tea implements HotDrink
{
    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}

class Coffee implements HotDrink
{
    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

//2nd level we go with the hierarchy
interface HotDrinkFactory
{
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory
{

    @Override
    public HotDrink prepare(int amount) {

        System.out.println("Put in tea bag, boil water, puor " + amount + "ml, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory
{

    @Override
    public HotDrink prepare(int amount) {

        System.out.println("Grind some beans, boil water, puor " + amount + "ml, add cream and sugar, enjoy!");
        return new Coffee();
    }
}

class HotDrinkMachine
{
    /*
    * $ Pair class : https://www.geeksforgeeks.org/pair-class-in-java/
    * also refer to as java tuples
    * //Java tuples :
    * */
    /*
    *  javatuples ? classes
        Java tuples supports tuples of size up to '10' and for each size it has provided a tuple implementation like below.

        Unit (one element)
        Pair (two elements)
        Triplet (three elements)
    * */

    //Pair<Integer, Integer> onePair = new Pair<>(1, 2);
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine()
    {
        //https://www.geeksforgeeks.org/reflection-in-java/
        //lets make reflection
        //new Reflections()

    }

}