package com.shyn.zyot.wind.pickersdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDemoActivity extends AppCompatActivity {

    private TextView tvTime;
    private TimePicker timePicker;
    private Calendar calendar;
    private Button btn24H;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_demo);

        tvTime = findViewById(R.id.tvTime);
        timePicker = findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        btn24H = findViewById(R.id.btn24H);

        // get current time
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        tvTime.setText((currentHour + " : " + currentMinute));

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tvTime.setText((hourOfDay + " : " + minute));
            }
        });

        // ?? bug : if set 24h first --> no bug, but if not --> can't see the number from 13 -> 24
        timePicker.setIs24HourView(true);
        btn24H.setText("12h form");

        btn24H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timePicker.is24HourView()) { // check if Time Picker is in 24h form
                    timePicker.setIs24HourView(false);
                    btn24H.setText("24h form");
                } else {
                    timePicker.setIs24HourView(true);
                    btn24H.setText("12h form");
                }
            }
        });
    }
}
