package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization of database and database helper class
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

    }

    private long insertLocation(Location m) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Location.COLUMN_NAME_CITY, m.getCity());
        values.put(DatabaseTables.Location.COLUMN_NAME_COUNTRY, m.getCountry());
        values.put(DatabaseTables.Location.COLUMN_NAME_POPULATION, m.getPopulation());
        return database.insert(DatabaseTables.Location.TABLE_NAME, null, values);
    }



}
