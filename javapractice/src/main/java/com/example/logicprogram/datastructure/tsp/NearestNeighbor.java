package com.example.logicprogram.datastructure.tsp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by parasmani.sharma on 23/05/2017.
 */

public class NearestNeighbor {

    public Route findShortestRoute(ArrayList<City> cities)
    {
        ArrayList<City> shortestRouteCities = new ArrayList<City>(cities.size());
        System.out.println("____________________________________________________________________");
        System.out.println("Initial Route               ==> " + Arrays.toString(cities.toArray()));
        System.out.println("w/ total distance : "  + new Route(cities).calculateTotalDistance());
        System.out.println("____________________________________________________________________");
        //City city = cities.get((int)(cities.size() * Math.random()));
        City city = cities.get(0);
        updateRoutes(shortestRouteCities, cities, city);
        while (cities.size() >= 1 )
        {
            city = getNextCity(cities, city);
            updateRoutes(shortestRouteCities,cities, city);
        }

        return new Route(shortestRouteCities);

    }

    private void updateRoutes(ArrayList<City> shortestRouteCities, ArrayList<City> cities, City city)
    {
        shortestRouteCities.add(city);
        cities.remove(city);
        System.out.println("\nCities in shorttest route  ==> " + Arrays.toString(shortestRouteCities.toArray()));
        System.out.println("\nRemaining Cities  ==> " + Arrays.toString(cities.toArray()) + "\n");

    }


    private City getNextCity(ArrayList<City> cities, City city)
    {
        return cities.stream().min((city1, city2) -> {

            //System.out.print("\nCity 1 : " +city1);
            //System.out.print("\nCity 2 : " +city2);

            int flag = 0;
            if(city1.measureDistance(city) < city2.measureDistance(city)) flag = -1;
            else if(city1.measureDistance(city) > city2.measureDistance(city)) flag = 1;
            return  flag;
        }).get();

    }


}
