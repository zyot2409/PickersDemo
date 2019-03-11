package com.shyn.zyot.wind.pickersdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

public class NumberPickerDemoActivity extends AppCompatActivity {

    private TextView tvNumber;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker_demo);

        tvNumber = findViewById(R.id.tvNumber);
        numberPicker = findViewById(R.id.numberPicker);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(20);

        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS); // if you don't want the soft keyboard to popup

        tvNumber.setText(("Result : " + numberPicker.getValue()));

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if (newVal != oldVal)
                    tvNumber.setText(("Result : " + newVal));
            }
        });

        // set my own format
        numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) { // set format for each value here
                if (value == 0) {
                    String s = "-";
                    return s;
                } else if (value == 1) {
                    String s = "" + value + " bug";
                    return s;
                } else {
                    String s = "" + value + " bugs";
                    return s;
                }
            }
        });
    }
}
