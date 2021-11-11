package com.example.ramadankareem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Calendar(View view) {
        Intent cl = new Intent(Home.this,Calendar.class);
        startActivity(cl);
    }

    public void Alarm(View view) {
        Intent al = new Intent(Home.this,Alarm.class);
        startActivity(al);
    }

    public void Zakat(View view) {
        Intent zk = new Intent(Home.this,ZakatCalculator.class);
        startActivity(zk);
    }

    public void Team(View view) {
        Intent tm = new Intent(Home.this,Team.class);
        startActivity(tm);
    }

    public void About(View view) {
        Intent ab = new Intent(Home.this,About.class);
        startActivity(ab);
    }
}