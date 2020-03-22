package com.example.logicprogram.design_pattern.a_creational_pattern.singleton;

/**
 * Created by parasmani.sharma on 01/11/2017.
 */

/*
* Used for memory optimization.
* */
/*
* http://antrix.net/posts/2012/java-lazy-initialization/
*
* Its nothing but initializing the object inside a method call, as we usually do in singleton pattern.
* Cons : Simply avoid resource wastage by reducing memory utilization.
* */
public class LazyInstantiation {

    private static LazyInstantiation lazyInstantiation;

    public static LazyInstantiation getInstance()
    {
        lazyInstantiation = new LazyInstantiation();
        return lazyInstantiation;
    }



}
