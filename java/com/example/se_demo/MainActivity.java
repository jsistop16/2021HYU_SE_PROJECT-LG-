package com.example.se_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        Button top_btn = (Button) findViewById(R.id.checkBox1);
        Button bottom_btn = (Button) findViewById(R.id.checkBox2);

        List button_list;
        button_list = new ArrayList<Integer>();

//        button_list.add(R.id.checkBoxlong1);//상의긴팔
//        button_list.add(R.id.checkBoxhalf1);//상의반팔
//        button_list.add(R.id.checkBoxlong2);//하의긴바지
//        button_list.add(R.id.checkBoxhalf2);//하의반바지




        Button top_long_btn = (Button) findViewById(R.id.checkBoxlong1);//상의 긴팔
        Button top_half_btn = (Button) findViewById(R.id.checkBoxhalf1);//상의 반팔
        Button bottom_long_btn = (Button) findViewById(R.id.checkBoxlong2);//하의 긴바지
        Button bottom_half_btn = (Button) findViewById(R.id.checkBoxhalf2);//하의 반바지


        top_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Subactivity_top.class);
                startActivity(intent);
            }
        });

        bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Subactivity_bottom.class);
                startActivity(intent);
            }
        });

        top_long_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                startActivity(intent);
            }
        });

        top_half_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                startActivity(intent);
            }
        });

        bottom_long_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                startActivity(intent);
            }
        });

        bottom_half_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                startActivity(intent);
            }
        });



    }
}