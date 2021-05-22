package com.example.persistence;

public class Location {
    private String city;
    private String country;
    private int population;

    public Location(String _city, String _country, int _population) {
        city = _city;
        country = _country;
        population = _population;
    }

    @Override
    public String toString() { return city + ", " + country + ", " + population;}

}
