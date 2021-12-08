package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class Color extends AppCompatActivity {
    JSONObject jsonData;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color);

        RadioButton color_red = (RadioButton) findViewById(R.id.checkBoxcolor1);
        RadioButton color_yellow = (RadioButton) findViewById(R.id.checkBoxcolor2);
        RadioButton color_green = (RadioButton) findViewById(R.id.checkBoxcolor3);
        RadioButton color_blue = (RadioButton) findViewById(R.id.checkBoxcolor4);
        RadioButton color_mint = (RadioButton) findViewById(R.id.checkBoxcolor5);
        RadioButton color_black = (RadioButton) findViewById(R.id.checkBoxcolor6);
        RadioButton color_white = (RadioButton) findViewById(R.id.checkBoxcolor7);
        RadioButton color_violet = (RadioButton) findViewById(R.id.checkBoxcolor8);

        ImageButton cancel_btn4 = (ImageButton) findViewById(R.id.cancel_btn4);

        Intent intent = getIntent();

        try {
            jsonData = new JSONObject(intent.getStringExtra("jsonData"));
            System.out.println(jsonData.toString());
        }catch(JSONException e){
            e.printStackTrace();
        }

        cancel_btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);

                startActivity(intent);
            }
        });

        color_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "red");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        color_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "yellow");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        color_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "green");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        color_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "blue");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        color_mint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "mint");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });


        color_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "black");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        color_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "white");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        color_violet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Material.class);
                try {
                    jsonData.put("color", "violet");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });
    }
}
