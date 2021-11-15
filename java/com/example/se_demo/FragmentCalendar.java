package com.example.se_demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FragmentCalendar extends Fragment {

//    View view;
//    TextView cityView = view.findViewById(R.id.cityView);
//    TextView weatherView = view.findViewById(R.id.weatherView);
//    TextView tempView = view.findViewById(R.id.tempView);
//    static RequestQueue requestQueue;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



//        Button button = view.findViewById(R.id.weatherStart);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                CurrentCall();
//            }
//        });
//
//        if(requestQueue == null){
//            requestQueue = Volley.newRequestQueue(getActivity());
//        }

        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        return view;
    }
//    private void CurrentCall(){
//
//        String url = "http://api.openweathermap.org/data/2.5/weather?q={seoul}&appid={93804ba597ecd27e84a40ab55205cb11}";
//
//
//        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onResponse(String response) {
//
//                try {
//
//                    //System의 현재 시간(년,월,일,시,분,초까지)가져오고 Date로 객체화함
//                    long now = System.currentTimeMillis();
//                    Date date = new Date(now);
//
//                    //년, 월, 일 형식으로. 시,분,초 형식으로 객체화하여 String에 형식대로 넣음
//                    SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("yyyy-MM-dd");
//                    SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
//                    String getDay = simpleDateFormatDay.format(date);
//                    String getTime = simpleDateFormatTime.format(date);
//
//
//
//                    //api로 받은 파일 jsonobject로 새로운 객체 선언
//                    JSONObject jsonObject = new JSONObject(response);
//
//
//                    //도시 키값 받기
//                    String city = jsonObject.getString("name");
//
//                    cityView.setText(city);
//
//
//                    //날씨 키값 받기
//                    JSONArray weatherJson = jsonObject.getJSONArray("weather");
//                    JSONObject weatherObj = weatherJson.getJSONObject(0);
//
//                    String weather = weatherObj.getString("description");
//
//                    weatherView.setText(weather);
//
//
//
//                    //기온 키값 받기
//                    JSONObject tempK = new JSONObject(jsonObject.getString("main"));
//
//                    //기온 받고 켈빈 온도를 섭씨 온도로 변경
//                    double tempDo = (Math.round((tempK.getDouble("temp")-273.15)*100)/100.0);
//                    tempView.setText(tempDo +  "°C");
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//
//                return params;
//            }
//
//        };
//
//        request.setShouldCache(false);
//        requestQueue.add(request);
//    }
    

}
