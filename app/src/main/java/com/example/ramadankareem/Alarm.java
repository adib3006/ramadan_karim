package com.example.ramadankareem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    EditText timeHour;
    EditText timeMinute;
    Button setTime;
    Button setAlarm;
    EditText timeHour1;
    EditText timeMinute1;
    Button setTime1;
    Button setAlarm1;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        timeHour = findViewById(R.id.etHour);
        timeMinute = findViewById(R.id.etMinute);
        setTime = findViewById(R.id.btnTime);
        setAlarm = findViewById(R.id.btnAlarm);
        timeHour1 = findViewById(R.id.etHour1);
        timeMinute1 = findViewById(R.id.etMinute1);
        setTime1 = findViewById(R.id.btnTime1);
        setAlarm1 = findViewById(R.id.btnAlarm1);

        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(Alarm.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        timeHour.setText(String.format("%02d", hourOfDay));
                        timeMinute.setText(String.format("%02d", minutes));
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }

        });

        setTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(Alarm.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        timeHour1.setText(String.format("%02d", hourOfDay));
                        timeMinute1.setText(String.format("%02d", minutes));
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }

        });

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!timeHour.getText().toString().isEmpty() && !timeMinute.getText().toString().isEmpty()){
                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(timeHour.getText().toString()));
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(timeMinute.getText().toString()));
                    intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Wake up. It's Sahri Time !");
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                        timeHour.setText(null);
                        timeMinute.setText(null);
                    } else{
                        Toast.makeText(Alarm.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Alarm.this,"Please choose a time.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        setAlarm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!timeHour1.getText().toString().isEmpty() && !timeMinute1.getText().toString().isEmpty()){
                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(timeHour1.getText().toString()));
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(timeMinute1.getText().toString()));
                    intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Get Ready. It's Ifter Time !");
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                        timeHour1.setText(null);
                        timeMinute1.setText(null);
                    } else{
                        Toast.makeText(Alarm.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Alarm.this,"Please choose a time.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}