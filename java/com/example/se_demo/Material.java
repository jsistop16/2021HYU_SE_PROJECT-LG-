package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class Material extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material);

        Button material1 = (Button) findViewById(R.id.material1);
        Button material2 = (Button) findViewById(R.id.material2);
        Button material3 = (Button) findViewById(R.id.material3);
        Button material4 = (Button) findViewById(R.id.material4);
        Button material5 = (Button) findViewById(R.id.material5);
        Button material6 = (Button) findViewById(R.id.material6);
        Button material7 = (Button) findViewById(R.id.material7);
        Button material8 = (Button) findViewById(R.id.material8);
        Button material9 = (Button) findViewById(R.id.material9);
        Button material10 = (Button) findViewById(R.id.material10);
        Button material11 = (Button) findViewById(R.id.material11);

        material1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });

        material11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LastDate.class);
                startActivity(intent);
            }
        });
    }
}
