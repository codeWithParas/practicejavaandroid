package com.example.logicprogram.datastructure.algorithms.tsp;

/**
 * Created by parasmani.sharma on 23/05/2017.
 */
public class City {

    private static final double EARTH_EQUATORIAL_RADIUS = 6378.1370d;
    private static final double CONVERT_DEGREES_TO_RADIUS = 6378.1370d;
    private static final double CONVERT_KM_TO_MILES = 6378.1370d;

    private double longitude;
    private double latitude;
    private String name;

    public City(String name, double latitude, double longitude)
    {
        this.name  = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName(){return name;}
    public double getLatitude(){return this.latitude;}
    public double getLongitude(){return this.longitude;}


    //Haversine Formula to calculate distance

    public double measureDistance(City city)
    {
        double deltaLongitude = (city.getLongitude() - this.getLongitude());
        double deltaLatitude = (city.getLatitude() - this.getLatitude());
        double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) +
                   Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude), 2D);

        /*double a = (sin(dlat/2))^2 + cos(lat1) * cos(lat2) * (sin(dlon/2))^2*/
        //link : http://andrew.hedges.name/experiments/haversine/

        return CONVERT_KM_TO_MILES * EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    }

    public String toString(){ return this.name;}

}
