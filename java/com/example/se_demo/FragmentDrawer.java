package com.example.se_demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

public class FragmentDrawer extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drawer, container, false);

        Button drawer1_temp = (Button)view.findViewById(R.id.drawer1_temp);
        Button drawer1_hum = (Button)view.findViewById(R.id.drawer1_hum);
        TextView drawer1 = (TextView)view.findViewById(R.id.drawer1);

        drawer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showDrawermsg();
            }
        });

        drawer1_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp_dialog oDialog = new Temp_dialog(getActivity());
                oDialog.setCancelable(false);
                oDialog.show();
            }
        });
        drawer1_hum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Hum_dialog oDialog = new Hum_dialog(getActivity());
                oDialog.setCancelable(false);
                oDialog.show();
            }
        });
        return view;
    }

    void showDrawermsg(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("서랍 출입");
        builder.setMessage("서랍을 꺼내시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "취소하셨습니다", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        builder.setPositiveButton("출입", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "서랍을 꺼내겠습니다", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
