package com.example.intern05.meetup.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.intern05.meetup.R;

public class EventDetails extends AppCompatActivity {

    EditText eventName,eventDate,eventTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        eventName=(EditText)findViewById(R.id.eventDName);
        eventDate=(EditText)findViewById(R.id.eventDDate);
        eventTime=(EditText)findViewById(R.id.timeDStart);


    }
}
