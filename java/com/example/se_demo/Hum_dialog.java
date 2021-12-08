package com.example.se_demo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Hum_dialog extends Dialog {

    Hum_dialog h_oDialog;
    int hum = 50;

    public Hum_dialog(Context context)
    {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.6f;
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.hum_dialog);

        Button hum_up = (Button)findViewById(R.id.hum_up);
        Button hum_down = (Button)findViewById(R.id.hum_down);
        TextView hum_txt = (TextView)findViewById(R.id.hum_degree);
        Button hum_check = (Button)findViewById(R.id.hum_check);
        Button hum_cancel = (Button)findViewById(R.id.hum_cancel);

        h_oDialog = this;
        hum_txt.setText("50%");
        hum_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                hum++;
                hum_txt.setText(hum+"%");
            }
        });
        hum_down.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                hum--;
                hum_txt.setText(hum+"%");
            }
        });
        hum_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "습도가 설정되었습니다", Toast.LENGTH_SHORT);
                toast.show();
                h_oDialog.dismiss();
            }
        });

        hum_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "습도가 설정되지 않았습니다", Toast.LENGTH_SHORT);
                toast.show();
                h_oDialog.dismiss();
            }
        });

    }
}
