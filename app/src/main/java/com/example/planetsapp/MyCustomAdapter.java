package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetArrayList;
    private Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        // Initializing the custom adapter with the layout and data
        super(context, R.layout.item_list_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    // View Holder Class
    // Used to cache references to the views within an item layout so that they don't need to be repeatedly looked up during scrolling
    private static class MyViewHolder {
        TextView planetName, moonCount;
        ImageView planetImage;
    }

    // getView()
    // Used to create and return a view for a specific item in the list
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1- Get the planet object for the current position
        Planet planet = getItem(position);

        // 2- Inflate Layout
        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null) {
            // If the convertView is null, it means a new view needs to be created
            myViewHolder = new MyViewHolder();

            // Inflate the layout for each list item
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false);

            // Finding Views
            myViewHolder.moonCount = convertView.findViewById(R.id.moonCount);
            myViewHolder.planetImage = convertView.findViewById(R.id.planetImage);
            myViewHolder.planetName = convertView.findViewById(R.id.planetName);

            // Save the convertView as a result
            result = convertView;
            convertView.setTag(myViewHolder);
        } else {
            // the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }
        myViewHolder.planetName.setText(planet.getPlanetName());

        // Convert moonCount to String before setting it in the TextView
        myViewHolder.moonCount.setText(String.valueOf(planet.getMoonCount()));

        myViewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return result;
    }
}