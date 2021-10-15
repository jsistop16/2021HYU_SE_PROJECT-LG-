package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WindSystem extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.windsystem);

        Button windyes = (Button)findViewById(R.id.windYes);
        Button windno = (Button)findViewById(R.id.windNo);

        windyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Toast toast = Toast.makeText(getApplicationContext(), "송풍시스템이 예약되었습니다", Toast.LENGTH_LONG);
                toast.show();
                startActivity(intent);

            }
        });

        windno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Toast toast = Toast.makeText(getApplicationContext(), "송풍시스템을 예약하지 않으셨습니다", Toast.LENGTH_LONG);
                toast.show();
                startActivity(intent);
            }
        });
    }
}
