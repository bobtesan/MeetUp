package com.example.intern05.meetup.Activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.intern05.meetup.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.N)
public class EventCreateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef = db.getReference().child("Events");

    Button calendarB;
    EditText dateText;
    EditText timeStart;
    Button createEventB;
    EditText eventName;
    TimePickerDialog mTimePicker;
    String temp_key;

    int day, year, month;

    Calendar mCurrentTime = Calendar.getInstance();
    int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
    int minute = mCurrentTime.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);


        eventName = (EditText) findViewById(R.id.event_name);
        dateText = (EditText) findViewById(R.id.dateText2);
        calendarB = (Button) findViewById(R.id.calendarB);
        timeStart = (EditText) findViewById(R.id.timeStart);

        createEventB = (Button) findViewById(R.id.button3);
        createEventB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Map<String, Object> m = new HashMap<String, Object>();
                    temp_key = myRef.push().getKey();
                    myRef.updateChildren(m);

                    myRef = db.getReference("Events").child(temp_key.toString()).child(eventName.getText().toString());
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("EventDate", dateText.getText().toString());
                    map2.put("StartTime", timeStart.getText().toString());
                    map2.put("Location", "Inca_nu");
                    myRef.updateChildren(map2);
                    Toast.makeText(getApplicationContext(), "Event created successfully.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(EventCreateActivity.this, EventActivity.class);
                    startActivity(i);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Oops. There is an error.", Toast.LENGTH_SHORT).show();
                }


            }
        });
        dateText.setEnabled(false);
        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });


        timeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTimePicker = new TimePickerDialog(EventCreateActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHours, int selectedMinutes) {
                        timeStart.setText(selectedHours + ":" + selectedMinutes);
                    }
                }, hour, minute, true);
                mTimePicker.show();
            }

        });
    }

    Calendar calander = Calendar.getInstance();
    int yearC = calander.get(Calendar.YEAR);
    int monthC = calander.get(Calendar.MONTH);
    int dayC = calander.get(Calendar.DAY_OF_MONTH);

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
