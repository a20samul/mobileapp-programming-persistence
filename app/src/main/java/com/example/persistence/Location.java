package com.example.persistence;

public class Location {
    private String city;
    private String country;
    private int population;

    public Location(String _city, long _country, int _population) {
        city = _city;
        country=Long.toString(_country);
        population = _population;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

}
