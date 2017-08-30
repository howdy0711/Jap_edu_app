package com.example.lg.cpa;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LoadingActivity extends Activity {
    SharedPreferenceUtil sharedPreferenceUtil;

    SQLiteDatabase db;
    WordDBHelper helper;

    private String[] getJsonData = { "", "" ,"","","","",""};
    String version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        helper=  new WordDBHelper(this,"WORDS_JP.db",null,1);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);

        new Thread(new Runnable() {
            @Override
            public void run() {update_check();
            }
        }).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },1500);
    }
    public void update_check() {
        final String URL = "http://172.20.1.211:8080/Android/android/MysqlSqlite_Word_update.jsp";
        version = "20160602";
        String simpleData = "?version=" + version;

        HttpPost post = new HttpPost(URL + simpleData);
        HttpClient client = new DefaultHttpClient();

        try {
            HttpResponse response = client.execute(post); // 보낸 뒤, 리턴 되는 결과값을 받음

				/* 위에 까진 안드로이드에서 보내기, 밑에서 부터는 서버에서 보낸 데이터 받기 */
            BufferedReader bufreader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));

            String line = null;
            String page = "";

            // 버퍼의 웹문서 소스를 줄 단위로 읽어(line), page에 저장함
            while ((line = bufreader.readLine()) != null) {
                page += (String) line;
            }
            Log.d("kk", page);

            // 읽어들인 내용을 json 객체에 담아 그 중 dataSend로 정의 된 내용을
            // 불어온다. 그럼 json 중 원하는 내용을 하나의 json 배열에 담게 된다.
            JSONObject json = new JSONObject(page);
            JSONArray jArr = json.getJSONArray("dataSend");

            // JSON이 가진 크기만큼 데이터를 받아옴
            json = jArr.getJSONObject(0);
            String data = json.getString("Version");
            Log.d("size",jArr.length()+"");

            if (data.compareTo("Coincide") != 0) {
                for (int i = 0; i < jArr.length(); i++) {
                    json = jArr.getJSONObject(i);
                    version = json.getString("times");

                    getJsonData[1] = json.getString("classes");
                    getJsonData[2] = json.getString("word");
                    getJsonData[3] = json.getString("kanzi");
                    getJsonData[4] = json.getString("times");
                    getJsonData[5] = json.getString("mean");
                    getJsonData[6] = json.getString("level");

                    sharedPreferenceUtil.setSharedClasses(getJsonData[1]);
                    sharedPreferenceUtil.setSharedWord(getJsonData[2]);
                    sharedPreferenceUtil.setSharedKanzi(getJsonData[3]);
                    sharedPreferenceUtil.setSharedTime(getJsonData[4]);
                    sharedPreferenceUtil.setSharedMean(getJsonData[5]);
                    sharedPreferenceUtil.setSharedLevel(getJsonData[6]);

                    //Log.d("sharedPreferenceUtil Check", sharedPreferenceUtil.getSharedClasses() + " " + sharedPreferenceUtil.getSharedWord() + " " + sharedPreferenceUtil.getSharedKanzi() + " " + sharedPreferenceUtil.getSharedTime() + " " + sharedPreferenceUtil.getSharedMean() + " " + sharedPreferenceUtil.getSharedLevel());

                    insert(sharedPreferenceUtil.getSharedClasses(), sharedPreferenceUtil.getSharedWord(), sharedPreferenceUtil.getSharedKanzi(), sharedPreferenceUtil.getSharedTime(), sharedPreferenceUtil.getSharedMean(), sharedPreferenceUtil.getSharedLevel());
                    sharedPreferenceUtil.removeClasses();
                    sharedPreferenceUtil.removeKanzi();
                    sharedPreferenceUtil.removeLevel();
                    sharedPreferenceUtil.removeMean();
                    sharedPreferenceUtil.removeTime();
                    sharedPreferenceUtil.removeWord();
                }
            }else{
                Log.d("kjsdzfiojeiofjasdkf","Cant Bring it!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insert(String classes, String word, String kanzi, String times,
                       String mean, String level) {
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from WORDS_JP where word='"+word+"' ",null);

        if(cursor.getCount() == 0) {
            ContentValues values = new ContentValues();
            values.put("classes", classes);
            values.put("word", word);
            values.put("kanzi", kanzi);
            values.put("times", times);
            values.put("mean", mean);
            values.put("level", level);
            db.insert("WORDS_JP", null, values);
        }

        Log.i("db", classes + "\n"
                + word + "\n" + kanzi + "\n" + times + "\n" + mean);
    }
}


