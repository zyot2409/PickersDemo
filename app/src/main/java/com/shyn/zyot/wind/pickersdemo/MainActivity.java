package com.shyn.zyot.wind.pickersdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDatePicker;
    private Button btnTimePicker;
    private Button btnNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = findViewById(R.id.btnDatePicker);
        btnTimePicker = findViewById(R.id.btnTimePicker);
        btnNumberPicker = findViewById(R.id.btnNumberPicker);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnNumberPicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDatePicker: {
                Intent intent = new Intent(getBaseContext(),DatePickerDemoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnTimePicker: {
                Intent intent = new Intent(getBaseContext(),TimePickerDemoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnNumberPicker:{
                Intent intent = new Intent(getBaseContext(),NumberPickerDemoActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
