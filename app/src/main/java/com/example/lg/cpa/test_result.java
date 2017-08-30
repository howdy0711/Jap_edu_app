package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gom on 2016-06-06.
 */
public class test_result extends AppCompatActivity {

    TextView textView;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_result);
        btn = (Button)findViewById(R.id.NextLevel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),grammar_level3.class);
                startActivity(intent);
                finish();
            }
        });
        String str;
        Intent i = getIntent();
        str = i.getStringExtra("Score");
        textView = (TextView)findViewById(R.id.score);
        textView.setText(str);

    }
}
