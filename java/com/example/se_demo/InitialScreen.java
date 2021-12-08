package com.example.se_demo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InitialScreen extends AppCompatActivity {
    //(인트로3초 넘어가고)앱 처음 화면
    //하단바까지 포함된 전체 화면
    //하단바 위에 표현되는 화면은 각각 하나씩 Fragment프레임으로 구성
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHanger fragmentHanger = new FragmentHanger();
    private FragmentDrawer fragmentDrawer = new FragmentDrawer();
    private FragmentCalendar fragmentCalendar = new FragmentCalendar();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHanger).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.hanger:
                    transaction.replace(R.id.frameLayout, fragmentHanger).commitAllowingStateLoss();
                    break;
                case R.id.drawer:
                    transaction.replace(R.id.frameLayout, fragmentDrawer).commitAllowingStateLoss();
                    break;
                case R.id.calendar:
                    transaction.replace(R.id.frameLayout, fragmentCalendar).commitAllowingStateLoss();
                    break;
            }
            return true;
        }

    }
}
