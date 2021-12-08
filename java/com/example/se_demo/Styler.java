package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class Styler extends AppCompatActivity {

    String[] items_styler = {"행거1번", "행거2번", "행거3번", "행거4번", "행거5번", "행거6번", "행거7번", "행거8번", "행거9번", "행거10번"};
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.styler);



        Button styleryes = (Button)findViewById(R.id.stylerYes);
        Button stylerno = (Button)findViewById(R.id.stylerNo);
        Spinner styler_spinner = (Spinner)findViewById(R.id.styler_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items_styler
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        styler_spinner.setAdapter(adapter);

        styler_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //hanger_txt.setText(items[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //hanger_txt.setText("행거번호 선택");
            }
        });
        styleryes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StylerReservation.class);
                startActivity(intent);

            }
        });

        stylerno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "스타일러를 예약하지 않으셨습니다", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);
                startActivity(intent);
            }
        });
    }
}
