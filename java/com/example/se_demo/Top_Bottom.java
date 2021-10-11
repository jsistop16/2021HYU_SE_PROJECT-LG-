package com.example.se_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Top_Bottom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        Button top_btn = (Button) findViewById(R.id.checkBox1);
        Button bottom_btn = (Button) findViewById(R.id.checkBox2);
        Button etc_btn = (Button) findViewById(R.id.checkBox3);




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

        etc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                startActivity(intent);
            }
        });





    }
}