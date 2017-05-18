package com.example.intern05.meetup.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.intern05.meetup.R;

import java.util.List;

/**
 * Created by intern05 on 18.05.2017.
 */

public class SlidingMenuAdapter extends BaseAdapter {

    private Context context;
    private List<ItemSlideMenu> lstItem;


    public SlidingMenuAdapter(Context context, List<ItemSlideMenu> lstItem) {
        this.context = context;
        this.lstItem = lstItem;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ItemSlideMenu> getLstItem() {
        return lstItem;
    }

    public void setLstItem(List<ItemSlideMenu> lstItem) {
        this.lstItem = lstItem;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return lstItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context, R.layout.item_sliding_menu,null);
        ImageView img=(ImageView)v.findViewById(R.id.item_img);
        return v;
    }
}
