package com.example.intern05.meetup.Activities;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.intern05.meetup.R;

public class EventCreateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    Button calendarB;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);

        datePickerDialog = new DatePickerDialog(getApplicationContext(), this, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        calendarB=(Button)findViewById(R.id.calendarB);
        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
