package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Trash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trash);

        Button deleteyes = (Button)findViewById(R.id.deleteYes);
        Button deleteno = (Button)findViewById(R.id.deleteNo);

        deleteyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);
                //MainActivity.class로 넘어가면 하단바 구성이 사라지므로 InitialScreen.class로 넘어가야한다.
                //다른 버튼들도 마찬가지
                Toast toast = Toast.makeText(getApplicationContext(), "옷이 삭제되었습니다.", Toast.LENGTH_LONG);
                toast.show();
                startActivity(intent);
            }
        });

        deleteno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);
                Toast toast = Toast.makeText(getApplicationContext(), "옷이 삭제되지 않았습니다.", Toast.LENGTH_LONG);
                toast.show();
                startActivity(intent);
            }
        });
    }
}
