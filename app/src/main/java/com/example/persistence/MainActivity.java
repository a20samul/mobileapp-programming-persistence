package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        final EditText editCity, editCountry, editPopulation;
        editCity = findViewById(R.id.edit_text1);
        editCountry = findViewById(R.id.edit_text2);
        editPopulation = findViewById(R.id.edit_text3);
        final TextView textView = findViewById(R.id.text1_view);

        // Click values into database
        Button write = findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = editCity.getText().toString();
                String country = editCountry.getText().toString();
                int population = Integer.parseInt(editPopulation.getText().toString());
                addLocation(city, country, population);
                Log.d("ENTERED ==>", "Data successfully entered!");
            }
        });
    }

    private long addLocation(String city, String country, int population) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Location.COLUMN_NAME_CITY, String.valueOf(city));
        values.put(DatabaseTables.Location.COLUMN_NAME_COUNTRY, String.valueOf(country));
        values.put(DatabaseTables.Location.COLUMN_NAME_POPULATION, String.valueOf(population));
        return database.insert(DatabaseTables.Location.TABLE_NAME, null, values);
    }
}
