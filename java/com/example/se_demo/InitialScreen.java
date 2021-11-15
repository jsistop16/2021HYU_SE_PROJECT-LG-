package com.example.se_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InitialScreen extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHanger fragmentHanger = new FragmentHanger();
    private FragmentDrawer fragmentDrawer = new FragmentDrawer();
    private FragmentCalendar fragmentCalendar = new FragmentCalendar();
    private FragmentSettings fragmentSettings = new FragmentSettings();

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
                case R.id.settings:
                    transaction.replace(R.id.frameLayout, fragmentSettings).commitAllowingStateLoss();
                    break;
            }
            return true;
        }

    }
}
