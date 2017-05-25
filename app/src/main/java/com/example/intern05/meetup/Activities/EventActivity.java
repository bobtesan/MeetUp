package com.example.intern05.meetup.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.intern05.meetup.Adapters.MyAdapter;
import com.example.intern05.meetup.Models.Events;
import com.example.intern05.meetup.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EventActivity extends AppCompatActivity implements MyAdapter.EventItemSelectionListener {


    DatabaseReference root;
    private List<Events> eventsList = new ArrayList<>();

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private FloatingActionButton fab;


    DateFormat df;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        //date = df.format(Calendar.getInstance().getTime());

        root = FirebaseDatabase.getInstance().getReference("Events");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(eventsList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(EventActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EventActivity.this, EventCreateActivity.class);
                startActivity(i);
            }
        });
        prepareEventData();
    }

    private void prepareEventData() {
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot children : dataSnapshot.getChildren()) {
                    HashMap<String, Object> map = (HashMap<String, Object>) children.getValue();
                    String date = (String) map.get("EventDate");
                    String time =(String) map.get("StartTime");

                    eventsList.add(new Events(children.getKey(), date, time));
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onEventSelected(int position, Events event) {
        Intent i = new Intent(EventActivity.this, EventDetails.class);
        startActivity(i);
    }


}
