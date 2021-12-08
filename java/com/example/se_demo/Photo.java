package com.example.se_demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
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
import java.io.UnsupportedEncodingException;
import static android.content.ContentValues.TAG;

public class Photo extends AppCompatActivity {

    String postUrl = "http://13.209.87.94/cloth";
    JSONObject jsonData;
    TextView txt;
    TextView jsontxt;
    Spinner hanger_spinner;
    String[] items = {"행거1번", "행거2번", "행거3번", "행거4번", "행거5번", "행거6번", "행거7번", "행거8번", "행거9번", "행거10번"};
    ImageButton cancel_btn6;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        cancel_btn6 = (ImageButton) findViewById(R.id.cancel_btn6);

        cancel_btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);

                startActivity(intent);
            }
        });

        hanger_spinner = (Spinner) findViewById(R.id.hanger_spinner);

        Intent intent = getIntent();
        try{
            jsonData = new JSONObject(intent.getStringExtra("jsonData"));
        }catch(JSONException e){
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hanger_spinner.setAdapter(adapter);

        hanger_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //hanger_txt.setText(items[position]);
                try{
                    jsonData.put("hangerNo", items[position]);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //hanger_txt.setText("행거번호 선택");
            }
        });

        Button btn_complete = (Button)findViewById(R.id.finalbutton);

        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage();
            }
        });
    }
    void showMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("옷 정보 저장");
        builder.setMessage("옷 정보를 저장하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getApplicationContext(), "다시 설정해주세요", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getApplicationContext(), "옷 정보가 저장되었습니다", Toast.LENGTH_SHORT);
                toast.show();
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        postUrl,
                        jsonData,
                        new Response.Listener<JSONObject>(){
                            @Override
                            public void onResponse(JSONObject response) {
//                                jsontxt = (TextView)findViewById(R.id.jsontxt);
//                                jsontxt.setText(response.toString());
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
                Intent intent = new Intent(getApplicationContext(), InitialScreen.class);
                startActivity(intent);
//                jsontxt = findViewById(R.id.jsontxt);
//                jsontxt.setText(jsonData.toString());
                jsonObjectRequest.setShouldCache(false);
                sendHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
                sendHelper.requestQueue.add(jsonObjectRequest);
                //**************************************************************//
                //Cursor c = getContentResolver().query(Uri.parse());
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}