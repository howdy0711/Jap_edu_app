package com.example.lg.cpa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gom on 2016-06-02.
 */
public class WordDBHelper extends SQLiteOpenHelper {

    public WordDBHelper(Context context, String name,SQLiteDatabase.CursorFactory factory, int version)
    { super(context,name,factory,version); }

@Override
    public void onCreate(SQLiteDatabase db){
    String sql = "create table WORDS_JP("+
                    "word_num integer primary key autoincrement,"+
                    "classes text ,"+
                    "word text ,"+
                    "kanzi text ,"+
                    "times text ,"+
                    "mean text ,"+
                    "level text );";
    Log.i("성공","1123");
    db.execSQL(sql);
}
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    String sql = "drop table if exites WORDS_JP";
    db.execSQL(sql);

    onCreate(db);
}
}
