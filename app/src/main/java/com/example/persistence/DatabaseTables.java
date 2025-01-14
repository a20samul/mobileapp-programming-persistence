package com.example.persistence;

class DatabaseTables {

    static class Location {

        static final String TABLE_NAME = "LOCATION";
        static final String COLUMN_NAME_CITY = "city";
        static final String COLUMN_NAME_COUNTRY = "country";
        static final String COLUMN_NAME_POPULATION = "population";

    }

    static final String SQL_CREATE_TABLE_LOCATION =
            // "CREATE TABLE location (city TEXT PRIMARY KEY, country TEXT, population INT)"
            "CREATE TABLE " + Location.TABLE_NAME + " (" +
                    Location.COLUMN_NAME_CITY + " TEXT PRIMARY KEY," +
                    Location.COLUMN_NAME_COUNTRY + " TEXT," +
                    Location.COLUMN_NAME_POPULATION + " INT)";

    static final String SQL_DELETE_TABLE_LOCATION =
            // "DROP TABLE IF EXISTS location"
            "DROP TABLE IF EXISTS " + Location.TABLE_NAME;

}