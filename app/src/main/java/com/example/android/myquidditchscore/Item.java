package com.example.android.myquidditchscore;

import android.view.View;
import android.widget.TextView;


public class Item {

    String teamName;
    int cardImage;
    View theView;
    String typeOfCard;


    public Item(String teamName, int cardImage, String typeOfCard) {
        this.cardImage = cardImage;
        this.teamName = teamName;
        this.typeOfCard = typeOfCard;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getCardImage() {
        return cardImage;
    }
}