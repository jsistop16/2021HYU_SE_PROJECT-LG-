package com.example.se_demo;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Cloth_search extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cloth_search);

        Button search_top = (Button)findViewById(R.id.search_top);
        Button search_bottom = (Button)findViewById(R.id.search_bottom);
        Button search_long = (Button)findViewById(R.id.search_long);
        Button search_short = (Button)findViewById(R.id.search_short);

    }
}
