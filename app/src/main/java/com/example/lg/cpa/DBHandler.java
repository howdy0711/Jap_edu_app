package com.example.lg.cpa;


import java.util.Calendar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.Button;

public class DBHandler {
	DBHelper helper;
	SQLiteDatabase db;
	Context context;
	String str;
	SharedPreferenceUtil sharedPreferenceUtil;

	public void openDB() {
		helper = new DBHelper( context);
		db = helper.getWritableDatabase();
	}


	public void closeDB() {
		if( helper != null && db != null ) {
			helper.close();
			helper = null;
			db = null;
		}
	}
	
	public DBHandler( Context context ){
		this.context = context;
		openDB();
	}
	
	public static DBHandler open( Context context ) throws SQLException {
		DBHandler handler = new DBHandler( context );
		return handler;
	}

	public void close() {
		closeDB();
	}
	public long insert( String memo ) {
		ContentValues val = new ContentValues();
		Calendar cal = Calendar.getInstance();
		val.put("writedate", cal.getTimeInMillis());
		val.put("content", memo);
		return db.insert( "memo", null, val );
	}
	public void insert ( String word, String mean, String cla) {
		ContentValues values = new ContentValues();
		Calendar cal = Calendar.getInstance();
		ContentValues values2 = new ContentValues();

		values.put("class",cla);
		values.put("word",word);
		values.put("time", cal.getTimeInMillis()); // 단어 테이블 insert

		values2.put("mean", mean); // 뜻 테이블 insert
		values2.put("time",cal.getTimeInMillis());

		db.insert("word", null, values);
		db.insert("mean", null, values2);
	}

	public long update( int id, String memo ) {
		Cursor cursor = db.rawQuery("select * from memo where id='"+id+"'",null);

		cursor.moveToFirst();
		MemoInfo memo1 = new MemoInfo();
		memo1.memo = cursor.getString( 2 );
		String x = memo1.memo;
		sharedPreferenceUtil.removeNote();
		sharedPreferenceUtil.setSharedNote(x);


		ContentValues val = new ContentValues();
		Calendar cal = Calendar.getInstance();
		val.put("writedate", cal.getTimeInMillis());
		val.put("content", memo);
		return db.update("memo", val, "id = ?", new String[] { String.valueOf( id ) });
	}
	
	public Cursor selectAll() throws SQLiteException {
		Cursor cursor = db.query( "memo",
				new String[] { "id", "writedate",  "content" },
				null,  null,  null,  null,  null );
		if( cursor == null ) return null;
		if( cursor.getCount() == 0 ) {
			cursor.close();
			return null;
		}
		

		cursor.moveToFirst();
		return cursor;
	}

	public MemoInfo select( int id ) {
		sharedPreferenceUtil = new SharedPreferenceUtil(context);

		Cursor cursor = db.query( "memo",
				new String[] { "id", "writedate", "content" },
				"id = ?", new String[] { Integer.toString( id ) }, null, null, null );
		if( cursor == null ) return null;
		if( cursor.getCount() == 0 ) {
			return null;
		}

		cursor.moveToFirst();
		MemoInfo memo = new MemoInfo();
		memo.id = cursor.getInt(0);
		memo.writeDate = cursor.getLong(1);
		memo.memo = cursor.getString(2);
		String x = memo.memo;
		sharedPreferenceUtil.setSharedNote(x);
		return memo;
	}

	public long delete( int id ) {
		sharedPreferenceUtil = new SharedPreferenceUtil(context);

		Cursor cursor = db.rawQuery("select * from memo where id='"+id+"'",null);

		cursor.moveToFirst();
		MemoInfo memo = new MemoInfo();
		memo.memo = cursor.getString(2);
		String x = memo.memo;
		sharedPreferenceUtil.removeNote();
		sharedPreferenceUtil.setSharedNote(x);

		return db.delete( "memo", "id = ?", new String[] { String.valueOf(id) } );
	}
	public boolean selectcount(){
		Cursor cursor = db.rawQuery("select count(*) from memo",null);

		if(cursor.getCount()==0)
			return false;
		else
			return true;
	}
}
