package com.afrian.xd.arrowfamillies;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CardView card = (Context
//        card.setCardBackgroundColor(Color.parseColor("#E6E6E6"));
//        card.setMaxCardElevation(0.0);
//        card.setRadius(5.0);

        ImageView Arrow = (ImageView) findViewById(R.id.imgArrow);
        Arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingArrowActivity.class);
                startActivity(intent);
            }
        });


        ImageView Good = (ImageView) findViewById(R.id.imgGoodGuy);
        Good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GoodGuysActivity.class);
                startActivity(intent);
            }
        });
        ImageView Bad = (ImageView) findViewById(R.id.imgBadGuy);
        Bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BadGuysActivity.class);
                startActivity(intent);
            }
        });





}
}
