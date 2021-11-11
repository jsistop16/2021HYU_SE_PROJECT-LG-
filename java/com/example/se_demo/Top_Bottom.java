package com.example.se_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Top_Bottom extends AppCompatActivity {
    JSONObject jsonData = new JSONObject();
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
                try{
                    jsonData.put("top_bottom", "top");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Subactivity_bottom.class);
                try{
                    jsonData.put("top_bottom", "bottom");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        etc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                //상,하의가 아닌 기타 옷은 바로 color 클래스로 이동
                //"short_long" : "null"로 저장
                try{
                    jsonData.put("top_bottom", "etc");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });





    }
}