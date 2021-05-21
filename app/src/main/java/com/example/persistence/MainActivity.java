package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

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
}
