package com.example.se_demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class FragmentHanger extends Fragment implements View.OnClickListener{
    //Fragment 화면에서 clicklistener를 상속받을수 없음(이미 Fragment를 상속받았기때문)
    //그래서 View.OnClickListener를 인터페이스로 사용
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cloth_info_complete, container, false);

        Button addbtn = (Button)view.findViewById(R.id.AddBtn);
        Button savebtn = (Button)view.findViewById(R.id.SaveBtn);
        ImageButton cloth = (ImageButton)view.findViewById(R.id.cloth1);
        Button Ventilbtn = (Button)view.findViewById(R.id.VentilBtn);
        Button Stylerbtn = (Button)view.findViewById(R.id.StylerBtn);

        Stylerbtn.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Styler.class);
                startActivity(intent);
            }
        });

        Ventilbtn.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FragmentWindSystem.class);
                startActivity(intent);
            }
        });

        cloth.setOnClickListener(new View.OnClickListener(){
              @Override public void onClick(View view) {
                  showpopmsg();
              }
        });


        addbtn.setOnClickListener(this);
        savebtn.setOnClickListener(this);

        return view;
    }

    void showpopmsg(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("삭제 or 출입");
        builder.setMessage("원하시는 것을 선택해주세요");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showdeletepopmsg();
            }
        });
        builder.setPositiveButton("출입", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showentrypopmsg();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    void showdeletepopmsg(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("옷 삭제");
        builder.setMessage("삭제하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "옷이 삭제되지 않았습니다", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getActivity().getApplicationContext(), InitialScreen.class);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "옷이 삭제되었습니다.", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getActivity().getApplicationContext(), InitialScreen.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    void showentrypopmsg(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("옷 출입");
        builder.setMessage("옷장에 출입하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "옷을 넣지 않겠습니다.", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getActivity().getApplicationContext(), InitialScreen.class);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "옷장에 출입합니다", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getActivity().getApplicationContext(), InitialScreen.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    Intent intent;
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.AddBtn:
                intent = new Intent(getActivity(), Top_Bottom.class);
                startActivity(intent);
                break;
            case R.id.SaveBtn:
                intent = new Intent(getActivity(), Cloth_search.class);
                startActivity(intent);
                break;

        }
    }
}
