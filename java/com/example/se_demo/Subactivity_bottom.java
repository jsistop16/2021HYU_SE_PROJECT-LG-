package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Subactivity_bottom extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscreen_bottom);

        Button bottom_long = (Button) findViewById(R.id.checkBoxlong2);
        Button bottom_short = (Button) findViewById(R.id.checkBoxhalf2);

        bottom_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                startActivity(intent);
            }
        });

        bottom_short.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                startActivity(intent);
            }
        });
    }
}
