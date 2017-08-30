package com.example.lg.cpa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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

public class jp extends AppCompatActivity {
    HttpPost httpPost;
    HttpResponse response;
    HttpClient httpClient;
    List<NameValuePair> nameValuePairList;
    SharedPreferenceUtil sharedPreferenceUtil;
    login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jp);
        login = new login();
    }
    public void grammar(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar.class);
        startActivity(intent);
    }
    public void conversation(View v)
    {
        Intent intent = new Intent(getApplicationContext(), conversation.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_note) {
            Intent intent = new Intent(getApplicationContext(),MainNote.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.logout) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Logout();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }).start();

            return true;
        }else if (id == R.id.end){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void Logout() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        String id = sharedPreferenceUtil.getSharedId();
        try {
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://172.20.1.211:8080/Android/android/logoutcheck.jsp");
            nameValuePairList = new ArrayList<NameValuePair>(1);
            nameValuePairList.add(new BasicNameValuePair("logout", id));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
            response = httpClient.execute(httpPost);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpClient.execute(httpPost, responseHandler);

            if (response.contains("Logout")) {
                sharedPreferenceUtil.removeId();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "로그아웃불가", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

