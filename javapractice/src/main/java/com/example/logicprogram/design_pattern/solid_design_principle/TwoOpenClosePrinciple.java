package com.example.logicprogram.design_pattern.solid_design_principle;

import java.awt.HeadlessException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Stream;

public class TwoOpenClosePrinciple {

    /*
    * Requirement  : Lets consider you have a e-commerc site contains some products based on COLOR,SIZE
    * and you want to design a custom filter as your manager told. So there may be some case in future when your
    * manager asked you to upgrade the filteration method by some more product features (like- BRAND, WEIGHT etc)
    * So we need to satisfy this case in such a way so that our functionality will update as asked but
    * previous functionality wont effect at code level modification. (Open for extention but close for modification).
    * */

    public static void main(String arg[])
    {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL, Weight.LIGHT);
        Product tree = new Product("tree", Color.GREEN, Size.LARGE, Weight.HEAVY);
        Product car = new Product("car", Color.RED, Size.LARGE, Weight.HEAVY);

        List<Product> products = Arrays.asList(apple, tree, car);
        ProductFilter pf = new ProductFilter();
        System.out.print("Old Way : Filter By Green Color \n" );
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" - " + p.name + " " + p.color));

        /*
        * Till now we are violating OCP : we are jumping in the class(ProductFilter) everytime when we
        * need to add more filteration creteria.
        * So How We can improve upon this ?
        * Ans : We can build a better architecture using specification pattern.
        * We need to make evrything generic and very flexible.
        * */

        BetterFilter bf = new BetterFilter();
        System.out.print("\n\nNew Way : Filter By Green Color \n" );
        bf.filter(products, new ColorSpecification(Color.GREEN))
        .forEach(p -> System.out.println(" - " + p.name + " " + p.color));

        /*
        * So Now if we add any creteria we dnt need to change implementation
        * Example adding WEIGHT
        * */

        System.out.print("\nNew Way : Filter By Heavy Weight \n" );
        bf.filter(products, new WeightSpecification(Weight.HEAVY))
                .forEach(p -> System.out.println(" - " + p.name + " " + p.weight));

        /*
        * TO make multi checking creteria filter we need a combinator pattern so we make AndSpecification class.
        * */

        System.out.print("\nNew Way : Multi Filter By Green Color and Heavy Weight \n" );
        bf.filter(products, new AndSpecificaton<>( new ColorSpecification(Color.GREEN),
        new WeightSpecification(Weight.HEAVY))).forEach(p -> System.out.println(" - " + p.name + " " + p.weight));

    }
}

class AndSpecificaton<T> implements Specification<T>
{

    private Specification<T> first, second;

    public AndSpecificaton(Specification<T> first, Specification<T> seconsd)
    {
        this.first = first;
        this.second = seconsd;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

interface Specification<T>
{
    /*Checking if product satidfy perticular creteria*/
    boolean isSatisfied(T item);
}

interface Filter<T>
{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class WeightSpecification implements Specification<Product> {
    private Weight weight;

    public WeightSpecification(Weight weight)
    {
        this.weight= weight;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.weight == weight;
    }
}

class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color)
    {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size)
    {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class BetterFilter implements Filter<Product>
{

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

enum Weight
{
    LIGHT, MEDIUM, HEAVY, MEGA
}

enum Size
{
    SMALL, MEDIUM, LARGE, YUGE
}

enum Color
{
    RED, YELLOW, GREEN
}

class Product
{
    public String name;
    public Color color;
    public Size size;
    public Weight weight;

    public Product(String name, Color color, Size size, Weight weight)
    {
        this.name = name;
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

}

class ProductFilter
{
    public Stream<Product> filterByColor(List<Product> products, Color color)
    {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size)
    {
        return products.stream().filter(p -> p.size == size);
    }

    /*
     * Taking lots of arguement (Two criteria COLOR and SIZE)
     * Imaging if we have more criteria then this will take more arguements which is not good, a kind of GOD
     * object is creating for large set of criteria.
     * */
    public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size)
    {
        return products.stream().filter(p -> p.color == color && p.size == size);
    }

}
