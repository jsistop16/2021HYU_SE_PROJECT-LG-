package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class StylerReservation extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.styler_reservation);
        CalendarView styler_calendar = (CalendarView)findViewById(R.id.styler_calendar);
        TextView date_txt_styler1 = (TextView)findViewById(R.id.date_txt_styler1);
        TextView date_txt_styler2 = (TextView)findViewById(R.id.date_txt_styler2);
        Button styler_save_btn = (Button)findViewById(R.id.styler_save_btn);
        TimePicker timePicker = (TimePicker)findViewById(R.id.timepicker);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                date_txt_styler2.setText(hourOfDay + "시" + minute + "분");
            }
        });

        styler_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext().getApplicationContext(), "스타일러가 예약되었습니다", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);
                startActivity(intent);
            }
        });

        styler_calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date_txt_styler1.setText(String.format("%d / %d / %d", year, month+1, dayOfMonth));
            }
        });
    }

}
