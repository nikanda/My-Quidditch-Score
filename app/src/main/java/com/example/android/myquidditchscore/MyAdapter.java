package com.example.android.myquidditchscore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Chronometer;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> teamList = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        teamList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("getView " + position);
        Item theItem = teamList.get(position);
        View retVal = theItem.theView;
        if (retVal == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            retVal = inflater.inflate(R.layout.list_view_items, null);
            TextView textView = (TextView) retVal.findViewById(R.id.textView);
            ImageView imageView = (ImageView) retVal.findViewById(R.id.imageView);
            Chronometer chronometer = retVal.findViewById(R.id.chronometerFoul);

            System.out.println("Starting chronometer for pos" + position);
            chronometer.start();
            if (theItem.typeOfCard == "yellow") {
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00"))
                            chronometer.stop();

                    }
                });
            } else if (theItem.typeOfCard == "blue") {
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00"))
                            chronometer.stop();
                    }
                });
            } else if (theItem.typeOfCard == "red") {
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00"))
                            chronometer.stop();
                    }
                });
            }
            teamList.get(position).theView = retVal;


            textView.setText(theItem.getTeamName());
            imageView.setImageResource(theItem.getCardImage());
        }
        return retVal;

    }

}