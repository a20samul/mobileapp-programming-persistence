package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;


    private List<Location> getLocations() {
        Cursor cursor = database.query(DatabaseTables.Location.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        List<Location> locations = new ArrayList<>();
        while (cursor.moveToNext()) {
            Location location = new Location(
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Location.COLUMN_NAME_CITY)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Location.COLUMN_NAME_COUNTRY)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTables.Location.COLUMN_NAME_POPULATION))
            );
            locations.add(location);
        }
        cursor.close();
        return locations;
    }

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
                Toast.makeText(MainActivity.this, "Data successfully entered", Toast.LENGTH_LONG).show();

            }
        });

        Button read = findViewById(R.id.read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String visible = "";
                List<Location> locations = getLocations();
                for (int i = 0; i < locations.size(); i++) {

                    visible += locations.get(i).toString() + "\n";
                    Log.d("READ ==>", "Sucessfully read data.");
                }
                textView.setText(visible);
                Toast.makeText(MainActivity.this, "Data successfully read", Toast.LENGTH_LONG).show();
                return;
            }
        });
    }

    private long addLocation (String city, String country, int population) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Location.COLUMN_NAME_CITY, String.valueOf(city));
        values.put(DatabaseTables.Location.COLUMN_NAME_COUNTRY, String.valueOf(country));
        values.put(DatabaseTables.Location.COLUMN_NAME_POPULATION, String.valueOf(population));
        return database.insert(DatabaseTables.Location.TABLE_NAME, null, values);
    }
}
