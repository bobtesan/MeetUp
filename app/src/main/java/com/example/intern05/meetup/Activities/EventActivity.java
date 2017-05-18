package com.example.intern05.meetup.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.intern05.meetup.Adapters.MyAdapter;
import com.example.intern05.meetup.Models.Events;
import com.example.intern05.meetup.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    private List<Events> eventsList=new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private FloatingActionButton fab;

    DateFormat df ;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        df=new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        date=df.format(Calendar.getInstance().getTime());

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        myAdapter=new MyAdapter(eventsList);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EventActivity.this,EventCreateActivity.class);
                startActivity(i);
            }
        });

        prepareEventData();
    }
    private void prepareEventData(){
        Events events=new Events("EventName",date);
        eventsList.add(events);

        events=new Events("Event2",date);
        eventsList.add(events);

        events=new Events("Event3",date);
        eventsList.add(events);
    }
}
