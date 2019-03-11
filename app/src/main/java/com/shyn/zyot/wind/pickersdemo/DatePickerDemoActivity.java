package com.shyn.zyot.wind.pickersdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerDemoActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TextView tvDate;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_demo);

        tvDate = findViewById(R.id.tvDate);
        datePicker = findViewById(R.id.datePicker);

        // get current date
        calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = day + "/" + (month + 1) + "/" + year; // month start form 0 to 11, so we plus it by 1
        tvDate.setText(date);

        // API >= 26
//        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
//                tvDate.setText(date);
//            }
//        });

        // If we want to set Max / Min Date for Date Picker --> the format of date must be in format (long)millisecond

        calendar.set(2018, 8, 24); // set date for calendar(example: 24/9/2018)
        long mDate = calendar.getTimeInMillis(); // transform date into millisecond format(long)

        datePicker.setMinDate(mDate);


        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                tvDate.setText(date);
            }
        });
    }
}
