package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class Subactivity_top extends AppCompatActivity {
    JSONObject jsonData;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscreen_top);

        Button top_long = (Button) findViewById(R.id.checkBoxlong1);
        Button top_short = (Button) findViewById(R.id.checkBoxhalf1);
        ImageButton cancel_btn2 = (ImageButton) findViewById(R.id.cancel_btn2);

        Intent intent = getIntent();

        cancel_btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);

                startActivity(intent);
            }
        });

        try{
            jsonData = new JSONObject(intent.getStringExtra("jsonData"));
            System.out.println(jsonData.toString());
        }catch (JSONException e){
            e.printStackTrace();
        }

        top_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                try{
                    jsonData.put("short_long","long");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        top_short.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                try{
                    jsonData.put("short_long","short");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });
    }
}
