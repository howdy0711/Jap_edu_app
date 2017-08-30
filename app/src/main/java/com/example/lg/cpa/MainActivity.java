package com.example.lg.cpa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public int countryCheck = 0;
    Button login, join,lan;

    HttpPost httpPost;
    HttpResponse response;
    HttpClient httpClient;
    List<NameValuePair> nameValuePairList;
    ProgressDialog dialog = null;
    SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, LoadingActivity.class));
        login = (Button)findViewById(R.id.loginButton);
        join = (Button)findViewById(R.id.joinButton);
        lan = (Button)findViewById(R.id.choice_language);

        Intent intent = new Intent(getApplicationContext(), login.class);
        intent.putExtra("countryCheck","1");

}
    public void onClick1(View v) {
        if(countryCheck == 0) {
            Intent intent = new Intent(getApplicationContext(), Korean_JOIN.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(), Japan_JOIN.class);
            startActivity(intent);
        }
    }
    public void onClick3(View v){
        if(countryCheck==1){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Check_jp();
                }
            }).start();
        }
        else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Check_kr();
                }
            }).start();
        }

    }
    public void choice_lan(View v){
        final Context context = this;
        final CharSequence[] items2 = { "한국어", "日本語"};
        AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(context);
        // 제목셋팅
        alertDialogBuilder2.setTitle("언어선택");
        alertDialogBuilder2.setSingleChoiceItems(items2, -1,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {// 프로그램을 종료한다
                        if(id == 1){
                            countryCheck = 1;
                            login.setText("ログイン");
                            join.setText("加入する");
                            lan.setText("言語選択");

                        }
                        else
                        {
                            login.setText("로그인");
                            join.setText("회원가입");
                            lan.setText("언어선택");
                            countryCheck = 0;

                        }
                        if(id ==0) {
                            Toast.makeText(getApplicationContext(),
                                    items2[id] + " 선택했습니다.",
                                    Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                        if(id ==1) {
                            Toast.makeText(getApplicationContext(),
                                    items2[id] + " 選択しました。",
                                    Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
        // 다이얼로그 생성
        AlertDialog alertDialog2 = alertDialogBuilder2.create();
        // 다이얼로그 보여주기
        alertDialog2.show();
    }
    public void Check_kr(){
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        String id = sharedPreferenceUtil.getSharedId();

        Log.d("shared id ", id + "");

        try{
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://172.20.1.211:8080/Android/android/logincheck.jsp");
            nameValuePairList = new ArrayList<NameValuePair>(1);
            nameValuePairList.add(new BasicNameValuePair("username",id));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
            response = httpClient.execute(httpPost);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpClient.execute(httpPost, responseHandler);

            if(response.contains("Logon")){
                Intent intent = new Intent(getApplicationContext(), jp.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Check_jp(){
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        String id = sharedPreferenceUtil.getSharedId();

        Log.d("shared id ", id + "");

        try{
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://172.20.1.211:8080/Android/android/logincheck.jsp");
            nameValuePairList = new ArrayList<NameValuePair>(1);
            nameValuePairList.add(new BasicNameValuePair("username",id));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
            response = httpClient.execute(httpPost);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpClient.execute(httpPost, responseHandler);

            if(response.contains("Logon")){
                Intent intent = new Intent(getApplicationContext(), Study_hangle.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(getApplicationContext(), japan_login.class);
                startActivity(intent);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

