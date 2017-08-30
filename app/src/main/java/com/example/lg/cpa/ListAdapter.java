package com.example.lg.cpa;



import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class ListInfo {
	TextView writeDate;
	TextView memo;
}

public class ListAdapter extends BaseAdapter {
	LayoutInflater inflater;
	Context context;
	ArrayList<MemoInfo> listData;
	ListInfo info;
	public ListAdapter( Context context, ArrayList<MemoInfo> data ) {
		inflater = LayoutInflater.from( context );
		this.context = context;
		listData = data;
	}
	
	public int getCount() {
		return listData.size();
	}
	
	public MemoInfo getItem(int position) {
		return listData.get( position );
	}
	public long getItemId(int position) {
		return position;
	}
	public View getView(int position, View convertview, ViewGroup parent) {
		View v = convertview;
		
		Calendar cal = Calendar.getInstance();
		if( v == null ) {
			info = new ListInfo();
			
			v = inflater.inflate( R.layout.memo_list, null );

			info.writeDate = (TextView)v.findViewById( R.id.writedate );

			cal.setTimeInMillis( listData.get( position ).writeDate );
			info.writeDate.setText( cal.get( Calendar.YEAR ) + "년 " + (cal.get( Calendar.MONTH ) +1)+ "월 " + cal.get( Calendar.DAY_OF_MONTH ) + "일 \n" );

			info.memo = (TextView)v.findViewById( R.id.memostring );
			info.memo.setText( listData.get( position ).memo );
			v.setTag( info );
		}
		else if( ((ListInfo)v.getTag()).memo.getText().toString() != listData.get( position ).memo ) {

			info = new ListInfo();
			v = inflater.inflate( R.layout.memo_list, null );
			info.writeDate = (TextView)v.findViewById( R.id.writedate );
			cal.setTimeInMillis( listData.get( position ).writeDate );
			info.writeDate.setText( cal.get( Calendar.YEAR ) + "년 " + (cal.get( Calendar.MONTH ) + 1)+ "월 " + cal.get( Calendar.DAY_OF_MONTH ) + "일 \n" );
			info.memo = (TextView)v.findViewById( R.id.memostring );
			info.memo.setText( listData.get( position ).memo );
			v.setTag( info );
		}
		return v;
	}

	public void setArrayList(ArrayList<MemoInfo> arrays) {
		listData = arrays;
	}
	
	public ArrayList<MemoInfo> getArrayList() {
		return listData;
	}
}
