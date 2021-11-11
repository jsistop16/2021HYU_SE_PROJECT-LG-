package com.example.se_demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;

import static android.content.ContentValues.TAG;

public class Photo extends AppCompatActivity {

    String postUrl = "http://54.180.125.238/cloth";
    JSONObject jsonData;
    TextView txt;

    private final int GET_GALLERY_IMAGE = 200;//사진
    private ImageView imageView;//사진


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        imageView = (ImageView)findViewById(R.id.cloth_photo);//사진
        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });//사진
        Intent intent = getIntent();
        try{
            jsonData = new JSONObject(intent.getStringExtra("jsonData"));
        }catch(JSONException e){
            e.printStackTrace();
        }

        Button btn_complete = (Button)findViewById(R.id.finalbutton);
        txt = (TextView)findViewById(R.id.txt);
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
                                txt.setText(response.toString());
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
                Intent intent = new Intent(getApplicationContext(), WindSystem.class);
                startActivity(intent);

                jsonObjectRequest.setShouldCache(false);
                sendHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
                sendHelper.requestQueue.add(jsonObjectRequest);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //사진
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            imageView.setImageURI(selectedImageUri);
        }
    }
    //사진

}
