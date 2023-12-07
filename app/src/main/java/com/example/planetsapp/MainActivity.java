package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Adapter View: A ListView
        listView = findViewById(R.id.listView);

        // 2. Data Source
        planetArrayList = new ArrayList<>();
        // Create Planet objects for all planets and add them to the list
        Planet mercury = new Planet("Mercury", 0, R.drawable.mercury);
        Planet venus = new Planet("Venus", 0, R.drawable.venus);
        Planet earth = new Planet("Earth", 1, R.drawable.earth);
        Planet mars = new Planet("Mars", 2, R.drawable.mars);
        Planet jupiter = new Planet("Jupiter", 79, R.drawable.jupiter);
        Planet saturn = new Planet("Saturn", 82, R.drawable.saturn);
        Planet uranus = new Planet("Uranus", 27, R.drawable.uranus);
        Planet neptune = new Planet("Neptune", 14, R.drawable.neptune);
        Planet pluto = new Planet("Pluto", 1, R.drawable.pluto);

        // Add the planets to the ArrayList
        planetArrayList.add(mercury);
        planetArrayList.add(venus);
        planetArrayList.add(earth);
        planetArrayList.add(mars);
        planetArrayList.add(jupiter);
        planetArrayList.add(saturn);
        planetArrayList.add(uranus);
        planetArrayList.add(neptune);
        planetArrayList.add(pluto);

        // Adapter
        MyCustomAdapter adapter = new MyCustomAdapter(planetArrayList, this);
        listView.setAdapter(adapter);

        // Handling Click Events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Use getItem(position) to get the selected planet
                Toast.makeText(MainActivity.this, "Planet: " + adapter.getItem(position).getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
