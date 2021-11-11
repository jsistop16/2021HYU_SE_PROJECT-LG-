package com.example.se_demo;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cloth_info_complete);

        Button addbtn = (Button)findViewById(R.id.AddBtn);
        Button savebtn = (Button)findViewById(R.id.SaveBtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Top_Bottom.class);
                startActivity(intent);
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cloth_search.class);
                startActivity(intent);
            }
        });

    }

}
