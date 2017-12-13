package com.example.android.myquidditchscore;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Chronometer;
import android.content.Context;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;

    ListView simpleList;

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<Item> teamList = new ArrayList<>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;
    MyAdapter myAdapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter = 0;

    //Popup
    Button yellowCardBtn, blueCardBtn, redCardBtn, popupBtnTeamA, popupBtnTeamB;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);

        simpleList = (ListView) findViewById(R.id.simpleListView);

        myAdapter = new MyAdapter(this, R.layout.list_view_items, teamList);
        simpleList.setAdapter(myAdapter);

        myAdapter = new MyAdapter(this, R.layout.list_view_items, teamList);
        simpleList.setAdapter(myAdapter);

        //popup
        yellowCardBtn = (Button) findViewById(R.id.yellowCardBtn);
        blueCardBtn = (Button) findViewById(R.id.blueCardBtn);
        redCardBtn = (Button) findViewById(R.id.redCardBtn);
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);

        yellowCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup_card, null);

                popupBtnTeamA = (Button) customView.findViewById(R.id.popupBtnTeamA);

                popupBtnTeamB = (Button) customView.findViewById(R.id.popupBtnTeamB);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                //display the popup window
                popupWindow.showAtLocation(linearLayout1, Gravity.CENTER, 0, 0);

                //dynamic insertion and close the popup window on button click Team A
                popupBtnTeamA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //dynamic insertion
                        teamList.add(new Item("team a", R.drawable.yellow, "yellow"));
                        myAdapter.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });

                //dynamic insertion and close the popup window on button click Team B
                popupBtnTeamB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //dynamic insertion
                        teamList.add(new Item("team b", R.drawable.yellow, "yellow"));
                        myAdapter.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });

            }
        });

        blueCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup_card, null);

                popupBtnTeamA = (Button) customView.findViewById(R.id.popupBtnTeamA);

                popupBtnTeamB = (Button) customView.findViewById(R.id.popupBtnTeamB);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                //display the popup window
                popupWindow.showAtLocation(linearLayout1, Gravity.CENTER, 0, 0);

                //dynamic insertion and close the popup window on button click Team A
                popupBtnTeamA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //dynamic insertion
                        teamList.add(new Item("team a", R.drawable.blue, "blue"));
                        myAdapter.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });

                //dynamic insertion and close the popup window on button click Team B
                popupBtnTeamB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //dynamic insertion
                        teamList.add(new Item("team b", R.drawable.blue, "blue"));
                        myAdapter.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });

            }
        });

        redCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup_card, null);

                popupBtnTeamA = (Button) customView.findViewById(R.id.popupBtnTeamA);

                popupBtnTeamB = (Button) customView.findViewById(R.id.popupBtnTeamB);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                //display the popup window
                popupWindow.showAtLocation(linearLayout1, Gravity.CENTER, 0, 0);

                //dynamic insertion and close the popup window on button click Team A
                popupBtnTeamA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //dynamic insertion
                        teamList.add(new Item("team a", R.drawable.red, "red"));
                        myAdapter.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });

                //dynamic insertion and close the popup window on button click Team B
                popupBtnTeamB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //dynamic insertion
                        teamList.add(new Item("team b", R.drawable.red, "red"));
                        myAdapter.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });

            }
        });

    }

    // Displays given score 10 points for TeamA
    public void incrementA(View v) {
        scoreTeamA = scoreTeamA + 10;
        displayForTeamA(scoreTeamA);

    }

    // Displays removes score 10 points for TeamA
    public void decrementA(View v) {
        scoreTeamA = scoreTeamA - 10;
        displayForTeamA(scoreTeamA);

    }

    // Displays given score 30 points for TeamA
    public void addThirtyForTeamA(View v) {
        scoreTeamA = scoreTeamA + 30;
        displayForTeamA(scoreTeamA);

    }

    // Displays the given score for Team A.
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    int scoreTeamB = 0;

    // Displays given score 10 points for TeamB
    public void incrementB(View v) {
        scoreTeamB = scoreTeamB + 10;
        displayForTeamB(scoreTeamB);

    }

    // Displays removes score 10 points for TeamB
    public void decrementB(View v) {
        scoreTeamB = scoreTeamB - 10;
        displayForTeamB(scoreTeamB);

    }

    //Displays given score 30 points for TeamA
    public void addThirtyForTeamB(View v) {
        scoreTeamB = scoreTeamB + 30;
        displayForTeamB(scoreTeamB);

    }

    // Displays the given score for Team B.
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    // Displays given resets points for TeamA and TeamB
    public void resets(View v) {
        scoreTeamB = 0;
        scoreTeamA = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        ((Chronometer) findViewById(R.id.chronometerGame)).setBase(SystemClock.elapsedRealtime());
        ((Chronometer) findViewById(R.id.chronometerGame)).stop();
    }


    // Chronometer Called when the activity is first created.

    public void startChronometer(View view) {
        ((Chronometer) findViewById(R.id.chronometerGame)).start();

    }

    public void stopChronometer(View view) {
        ((Chronometer) findViewById(R.id.chronometerGame)).stop();
    }

}
