package com.example.intern05.meetup.Activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.intern05.meetup.R;

@RequiresApi(api = Build.VERSION_CODES.N)
public class EventCreateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    Button calendarB;
    EditText dateText;
    EditText timeStart;
    TimePickerDialog mTimePicker;
    int day,year,month;

    Calendar mCurrentTime = Calendar.getInstance();
    int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
    int minute = mCurrentTime.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);




        calendarB=(Button)findViewById(R.id.calendarB);
        dateText=(EditText)findViewById(R.id.dateText2);
        dateText.setEnabled(false);
        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });




        timeStart=(EditText)findViewById(R.id.timeStart);
        timeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTimePicker=new TimePickerDialog(EventCreateActivity.this,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHours, int selectedMinutes) {
                        timeStart.setText(selectedHours+ ":" +selectedMinutes);
                    }
                },hour,minute,true);
                mTimePicker.show();
            }

        });

    }

    Calendar calander = Calendar.getInstance();
    int yearC=calander.get(Calendar.YEAR);
    int monthC=calander.get(Calendar.MONTH) + 1;
    int dayC=calander.get(Calendar.DAY_OF_MONTH);

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, yearC, monthC, dayC);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            day = selectedDay;
            month = selectedMonth;
            year = selectedYear;
            dateText.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
