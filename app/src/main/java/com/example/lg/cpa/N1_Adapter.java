package com.example.lg.cpa;


/**
 * Created by kdh on 2016-06-05.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gom on 2016-06-05.
 */
public class N1_Adapter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<N1> data = null;
    private LayoutInflater inflater = null;

    public N1_Adapter(Context c, int l, ArrayList<N1> d) {
        this.mContext = c;
        this.layout = l;
        this.data = d;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data;
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        TextView LargeText = (TextView) convertView.findViewById(R.id.LargeText);
        TextView MediumText = (TextView) convertView.findViewById(R.id.MediumText);

        LargeText.setText(data.get(position).LargeText);
        MediumText.setText(data.get(position).MediumText);

        return convertView;
    }
}