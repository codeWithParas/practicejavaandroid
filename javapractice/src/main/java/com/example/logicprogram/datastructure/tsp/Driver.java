package com.example.logicprogram.datastructure.tsp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by parasmani.sharma on 23/05/2017.
 */

public class Driver {

    private ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
            new City("Delhi",28.644800, 77.216721),
            new City("Bhopal",23.2599, 77.4126),
            new City("Roorkee", 29.854263,	77.888000),
            new City("Bareilly", 28.3670, 79.4304),
            new City("Bangalore", 12.9716, 77.5946),
            new City("Dehradun", 30.3165, 78.0322),
            new City("Mussoorie", 30.4599, 78.0664)
    ));


    public static void main(String args[])
    {

        Driver driver = new Driver();
        ArrayList<City> cities = new ArrayList<>();
        cities.addAll(driver.initialCities);
        driver.printShortestPath(new NearestNeighbor().findShortestRoute(cities));


    }


    private void printShortestPath(Route shortestRoute)
    {
        System.out.println("____________________________________________________________________");
        System.out.println("Shortest Route Found So Far            ==> " + shortestRoute);
        System.out.println("w/ total distance : "  +shortestRoute.calculateTotalDistance());
        System.out.println("____________________________________________________________________");
    }

}
