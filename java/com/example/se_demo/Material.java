package com.example.se_demo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class Material extends AppCompatActivity {

    JSONObject jsonData;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material);

        RadioButton kimo = (RadioButton) findViewById(R.id.kimo);
        RadioButton nylon = (RadioButton) findViewById(R.id.nylon);
        RadioButton denim = (RadioButton) findViewById(R.id.denim);
        RadioButton linen = (RadioButton) findViewById(R.id.linen);
        RadioButton cotton = (RadioButton) findViewById(R.id.cotton);
        RadioButton suede = (RadioButton) findViewById(R.id.suede);
        RadioButton acryl = (RadioButton) findViewById(R.id.acryl);
        RadioButton wool = (RadioButton) findViewById(R.id.wool);
        RadioButton cashmere = (RadioButton) findViewById(R.id.cashmere);
        RadioButton poly = (RadioButton) findViewById(R.id.poly);
        RadioButton etc = (RadioButton) findViewById(R.id.etc);

        ImageButton cancel_btn5 = (ImageButton) findViewById(R.id.cancel_btn5);

        Intent intent = getIntent();

        try{
            jsonData = new JSONObject(intent.getStringExtra("jsonData"));
        }catch(JSONException e){
            e.printStackTrace();
        }

        cancel_btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);

                startActivity(intent);
            }
        });


        cotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "cotton");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        poly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "poly");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        denim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "denim");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        kimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "kimo");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        acryl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "acryl");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        wool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "wool");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        cashmere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "cashmere");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        nylon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "nylon");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        suede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "suede");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        linen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "linen");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });

        etc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                try {
                    jsonData.put("material", "etc");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                intent.putExtra("jsonData", jsonData.toString());
                startActivity(intent);
            }
        });
    }
}
