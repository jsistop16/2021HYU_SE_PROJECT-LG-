package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class Etc extends AppCompatActivity {

    JSONObject jsonData = new JSONObject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etc);

        Button neck = (Button) findViewById(R.id.neck);
        Button cap = (Button) findViewById(R.id.cap);
        ImageButton cancel_btn = (ImageButton) findViewById(R.id.cancel_btn);

        cancel_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);

                startActivity(intent);
            }
        });


        neck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);
                try{
                    jsonData.put("etc", "neck");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });


        cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Color.class);

                try{
                    jsonData.put("etc", "cap");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });


    }

}
