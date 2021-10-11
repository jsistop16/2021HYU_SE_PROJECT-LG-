package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Color extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color);

        Button color_red = (Button) findViewById(R.id.checkBoxcolor1);
        Button color_orange = (Button) findViewById(R.id.checkBoxcolor2);
        Button color_yellow = (Button) findViewById(R.id.checkBoxcolor3);
        Button color_green = (Button) findViewById(R.id.checkBoxcolor4);
        Button color_blue = (Button) findViewById(R.id.checkBoxcolor5);
        Button color_grey = (Button) findViewById(R.id.checkBoxcolor6);
        Button color_black = (Button) findViewById(R.id.checkBoxcolor7);
        Button color_white = (Button) findViewById(R.id.checkBoxcolor8);


        color_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });

        color_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });

        color_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });

        color_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });

        color_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });

        color_grey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });

        color_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });

        color_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                startActivity(intent);
            }
        });
    }
}
