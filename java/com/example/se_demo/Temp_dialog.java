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

public class Temp_dialog extends Dialog {

    Temp_dialog m_oDialog;
    int temp = 25;

    public Temp_dialog(Context context)
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

        setContentView(R.layout.temp_dialog);

        Button temp_up = (Button)findViewById(R.id.temp_up);
        Button temp_down = (Button)findViewById(R.id.temp_down);
        TextView temp_txt = (TextView)findViewById(R.id.temp_degree);
        Button temp_check = (Button)findViewById(R.id.temp_check);
        Button temp_cancel = (Button)findViewById(R.id.temp_cancel);

        m_oDialog = this;
        temp_txt.setText("25℃");
        temp_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                temp++;
                temp_txt.setText(temp+"℃");
            }
        });
        temp_down.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                temp--;
                temp_txt.setText(temp+"℃");
            }
        });
        temp_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "온도가 설정되었습니다", Toast.LENGTH_SHORT);
                toast.show();
                m_oDialog.dismiss();
            }
        });

        temp_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "온도가 설정되지 않았습니다", Toast.LENGTH_SHORT);
                toast.show();
                m_oDialog.dismiss();
            }
        });

    }
}
