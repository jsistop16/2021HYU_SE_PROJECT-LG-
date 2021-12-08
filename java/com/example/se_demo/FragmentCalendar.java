package com.example.se_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;


public class FragmentCalendar extends Fragment {

    public Button weather;
    public Button save_btn;
    public TextView date_txt;
    public TextView textView2;
    public EditText content_txt;
    public CalendarView calendarView;
    Context mBase;
    public String fname;
    public FileInputStream fis;
    public String str;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        weather = (Button) view.findViewById(R.id.weatherlink);
        date_txt = (TextView) view.findViewById(R.id.date_txt);
        content_txt = (EditText) view.findViewById(R.id.content_txt);
        calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        save_btn = (Button) view.findViewById(R.id.save_btn);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.weather.go.kr/w/index.do"));
                startActivity(intent);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                content_txt.setVisibility(View.VISIBLE);
                date_txt.setText(String.format("%d / %d / %d", year, month+1, dayOfMonth));
                checkDay(year,month,dayOfMonth);
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveDiary(fname);
                textView2.setText(str);
                content_txt.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "일정이 추가되었습니다", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        return view;
    }
    public void checkDay(int cYear,int cMonth,int cDay){
        fname=""+cYear+"-"+(cMonth+1)+""+"-"+cDay+".txt";//저장할 파일 이름설정
        FileInputStream fis=null;

        try{
            fis=openFileInput(fname);

            byte[] fileData=new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str = new String(fileData);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveDiary(String readDay){
        FileOutputStream fos=null;

        try{
            fos=openFileOutput(readDay,MODE_NO_LOCALIZED_COLLATORS);
            String content=content_txt.getText().toString();
            fos.write((content).getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        return mBase.openFileInput(name);
    }


    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return mBase.openFileOutput(name, mode);
    }
}
