package com.example.intern05.meetup.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.intern05.meetup.R;

import org.w3c.dom.Text;


public class FragmentChat extends Fragment  {

    private View rootView;
    TextView tv;

    SharedPreferences pref ;

    public FragmentChat() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv=(TextView)rootView.findViewById(R.id.textView11);

        pref= getActivity().getSharedPreferences("MyPref", 0);



        tv.setText(pref.getString("temp_key",null));

    }



}
