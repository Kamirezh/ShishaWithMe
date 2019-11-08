package com.kamisolutions.shishawithme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class itemadapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] description;

    public itemadapter(Context c, String[] i, String[] d){

        items = i;
        description = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @Override
    public int getCount() {



        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View View, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.shisha_list_view_detail, null);
        TextView productView = (TextView)v.findViewById(R.id.productView);
        TextView descriptionView = (TextView)v.findViewById(R.id.descriptionView);

        String name = items[i];
        String desc = description[i];

        productView.setText(name);
        descriptionView.setText(desc);



        return v;
    }
}
