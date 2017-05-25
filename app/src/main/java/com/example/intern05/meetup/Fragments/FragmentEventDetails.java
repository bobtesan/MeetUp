package com.example.intern05.meetup.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.intern05.meetup.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by intern05 on 25.05.2017.
 */

public class FragmentEventDetails extends Fragment{

    EditText eventName;
    EditText eventDate;
   // EditText eventLocation;

    DatabaseReference root= FirebaseDatabase.getInstance().getReference("Events");

    View rootView;
    public FragmentEventDetails() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView=inflater.inflate(R.layout.fragment_event_details, container, false);
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        eventName=(EditText)rootView.findViewById(R.id.editText2);
        eventDate=(EditText)rootView.findViewById(R.id.editText3);

    }
}
