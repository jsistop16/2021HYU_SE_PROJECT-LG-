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

        Button material1 = (Button) findViewById(R.id.material1);//소재 면
        Button material2 = (Button) findViewById(R.id.material2);//소재 린넨
        Button material3 = (Button) findViewById(R.id.material3);//소재 실크

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
    }
}
