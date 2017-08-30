package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class test_jlpt1_result extends AppCompatActivity {

    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_jlpt1_result);
    String str;
    Intent i = getIntent();
    str = i.getStringExtra("Score");
    textView = (TextView)findViewById(R.id.score);
    textView.setText(str);
}
}

