package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by gom on 2016-06-05.
 */
public class Ko_singleItemView extends AppCompatActivity implements TextToSpeech.OnInitListener {

    String str0;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    TextToSpeech _tts;
    TextView textView;
    boolean _ttsActive = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        str0 = i.getStringExtra("check");

        if(str0.equals("0")) {
            setContentView(R.layout.ko_conversation1);
            Button b1 = (Button)findViewById(R.id.koreanSound);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView = (TextView)findViewById(R.id.ma1);
                    String str;
                    str = textView.getText().toString();
                    _tts.setLanguage(Locale.KOREA);
                    _ttsActive = true;
                    _tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

                }
            });
        }

        if(str0.equals("1")) {
            setContentView(R.layout.ko_conversation2);
            Button b1 = (Button)findViewById(R.id.koreanSound);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView = (TextView)findViewById(R.id.ma1);
                    String str;
                    str = textView.getText().toString();
                    _tts.setLanguage(Locale.KOREA);
                    _ttsActive = true;
                    _tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

                }
            });
        }

        if(str0.equals("2")) {
            setContentView(R.layout.ko_conversation3);
            Button b1 = (Button)findViewById(R.id.koreanSound);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView = (TextView)findViewById(R.id.ma1);
                    String str;
                    str = textView.getText().toString();
                    _tts.setLanguage(Locale.KOREA);
                    _ttsActive = true;
                    _tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

                }
            });
        }

        if(str0.equals("3")) {
            setContentView(R.layout.ko_conversation4);
            Button b1 = (Button)findViewById(R.id.koreanSound);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView = (TextView)findViewById(R.id.ma1);
                    String str;
                    str = textView.getText().toString();
                    _tts.setLanguage(Locale.KOREA);
                    _ttsActive = true;
                    _tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

                }
            });
        }

        if(str0.equals("4"))
            setContentView(R.layout.ko_conversation5);

        if(str0.equals("5"))
            setContentView(R.layout.ko_conversation5);

        if(str0.equals("6"))
            setContentView(R.layout.ko_conversation6);

        if(str0.equals("7"))
            setContentView(R.layout.ko_conversation7);

        if(str0.equals("8"))
            setContentView(R.layout.ko_conversation8);

        if(str0.equals("9"))
            setContentView(R.layout.ko_conversation9);

        if(str0.equals("10"))
            setContentView(R.layout.ko_conversation10);



    }

    @Override
    public void onPause() {
        super.onPause();

        try {
            if (_tts != null) {
                _tts.stop();
                _ttsActive = false;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        _tts = new TextToSpeech(getApplicationContext(),this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            if (_tts != null) {
                _tts.shutdown();
                _tts = null;
            }
        } catch (Exception e) {
        }
    }

    public void onInit(int status) {
    }

}