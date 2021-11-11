package com.example.ramadankareem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Calendar extends AppCompatActivity {

    Timer timer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                First f = new First();
                FragmentManager fm =getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frame,f);
                //ft.addToBackStack(null);
                ft.commit();

            }
        }, 0000);
    }

    public void First(View view) {
        First f = new First();
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,f);
        //ft.addToBackStack(null);
        ft.commit();
    }

    public void Second(View view) {
        Second s = new Second();
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,s);
        //ft.addToBackStack(null);
        ft.commit();
    }

    public void Third(View view) {
        Third t = new Third();
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,t);
        //ft.addToBackStack(null);
        ft.commit();
    }
}