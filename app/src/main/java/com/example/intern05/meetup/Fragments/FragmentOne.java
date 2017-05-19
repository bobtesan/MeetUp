package com.example.intern05.meetup.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.intern05.meetup.Activities.EventCreateActivity;
import com.example.intern05.meetup.Activities.EventDetails;
import com.example.intern05.meetup.Adapters.MyAdapter;
import com.example.intern05.meetup.Models.Events;
import com.example.intern05.meetup.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class FragmentOne extends Fragment {

    private View rootView;
    private List<Events> eventsList = new ArrayList<>();

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private FloatingActionButton fab;

    DateFormat df;
    String date;

    public FragmentOne() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_one, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        date = df.format(Calendar.getInstance().getTime());

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(eventsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(rootView.getContext(), EventCreateActivity.class);
                startActivity(i);
            }
        });
        prepareEventData();

    }

    private void prepareEventData() {
        Events events = new Events("EventName", date);
        eventsList.add(events);

        events = new Events("Event2", date);
        eventsList.add(events);

        events = new Events("Event3", date);
        eventsList.add(events);
        events = new Events("Event4", date);
        eventsList.add(events);
        events = new Events("Event3", date);
        eventsList.add(events);
        events = new Events("Event3", date);
        eventsList.add(events);
        events = new Events("Event3", date);
        eventsList.add(events);
        events = new Events("Event3", date);
        eventsList.add(events);
        events = new Events("Event3", date);
        eventsList.add(events);
        events = new Events("Event3", date);
        eventsList.add(events);
        events = new Events("Event3", date);
        eventsList.add(events);

    }
}
