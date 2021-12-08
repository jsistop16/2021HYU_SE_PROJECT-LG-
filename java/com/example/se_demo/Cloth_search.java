package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import static android.content.ContentValues.TAG;

public class Cloth_search extends AppCompatActivity {

    String postUrl2 = "http://13.209.87.94/cloth/search";
    JSONObject jsonData2 = new JSONObject();
    TextView txt2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cloth_search);

        txt2 = (TextView)findViewById(R.id.txt2);
        CheckBox search_top = (CheckBox)findViewById(R.id.search_top);
        CheckBox search_bottom = (CheckBox)findViewById(R.id.search_bottom);
        CheckBox search_long = (CheckBox)findViewById(R.id.search_long);
        CheckBox search_short = (CheckBox)findViewById(R.id.search_short);
        Button search_btn = (Button)findViewById(R.id.searching);


        search_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_top.isChecked()==true){
                    search_bottom.setChecked(false);
                    try{
                        jsonData2.put("top_bottom","top");
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        search_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_top.setChecked(false);
                if(search_bottom.isChecked()==true){
                    try{
                        jsonData2.put("top_bottom","bottom");
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        search_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_long.isChecked()==true){
                    search_short.setChecked(false);
                    try{
                        jsonData2.put("short_long","long");
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        search_short.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_long.setChecked(false);
                if(search_short.isChecked()==true){
                    try{
                        jsonData2.put("short_long","short");
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        postUrl2,
                        jsonData2,
                        new Response.Listener<JSONObject>(){
                            @Override
                            public void onResponse(JSONObject response) {
                                txt2.setText(response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //logcat에서 오류메시지 확인
                                NetworkResponse response = error.networkResponse;
                                if(error instanceof ServerError && response!=null){
                                    try{
                                        String res = new String(response.data, HttpHeaderParser.parseCharset(response.headers,"uth-8"));
                                        Log.d(TAG, res);
                                    }catch(UnsupportedEncodingException e){
                                        e.printStackTrace();
                                    }
                                    Log.d(TAG, "onErrorResponse: " + String.valueOf(error));
                                }
                            }
                        });
                jsonObjectRequest.setShouldCache(false);
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);
                startActivity(intent);
                sendHelper.requestQueue2 = Volley.newRequestQueue(getApplicationContext());
                sendHelper.requestQueue2.add(jsonObjectRequest);
                txt2.setText(jsonData2.toString());
            }
        });
    }
}
