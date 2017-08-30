package com.example.lg.cpa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Word> words = null;
    private ArrayList<Word> arraylist;

    public ListViewAdapter(Context context, List<Word> words) {
        mContext = context;
        this.words = words;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Word>();
        this.arraylist.addAll(words);
    }



    public class ViewHolder {
        TextView classes;
        TextView word;
        TextView kanzi;
        TextView mean;
        TextView level;
    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Word getItem(int position) {
        return words.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.classes = (TextView) view.findViewById(R.id.classes);
            holder.word = (TextView) view.findViewById(R.id.word);
            holder.kanzi = (TextView) view.findViewById(R.id.kanzi);
            holder.mean = (TextView) view.findViewById(R.id.mean);
            holder.level = (TextView) view.findViewById(R.id.level);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.classes.setText(words.get(position).getClasses());
        holder.word.setText(words.get(position).getWord());
        holder.kanzi.setText(words.get(position).getKanzi());
        holder.mean.setText(words.get(position).getMean());
        holder.level.setText(words.get(position).getLevel());

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("classes",(words.get(position).getClasses()));
                // Pass all data country
                intent.putExtra("word",(words.get(position).getWord()));
                // Pass all data population
                intent.putExtra("kanzi",(words.get(position).getKanzi()));
                intent.putExtra("mean",(words.get(position).getMean()));
                intent.putExtra("level",(words.get(position).getLevel()));

                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        words.clear();
        if (charText.length() == 0) {
            words.addAll(arraylist);
        }
        else
        {
            for (Word wp : arraylist)
            {
                if (wp.getWord().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    words.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
