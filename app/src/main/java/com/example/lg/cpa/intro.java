package com.example.lg.cpa;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class intro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
            ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
            IntroAdapter adapter = new IntroAdapter(this);
            viewPager.setAdapter(adapter);
        }

    public void next(View view){
        Intent intent = new Intent(getApplicationContext(),jp.class);
        startActivity(intent);
    }

}

