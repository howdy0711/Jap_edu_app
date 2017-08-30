package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by gom on 2016-06-05.
 */
public class N4_singleItemView extends AppCompatActivity implements TextToSpeech.OnInitListener {

    String str1;
    String str2;
    String str3;

    TextView text1,text2,text3;
    Button sound;

    TextToSpeech _tts;
    boolean _ttsActive = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n4_singleitemview);

        sound = (Button) findViewById(R.id.balum);


        text1 = (TextView)findViewById(R.id.word);
        text2 = (TextView)findViewById(R.id.grammer_hiragana);
        text3 = (TextView)findViewById(R.id.grammer_mean);

        Intent i = getIntent();
        str1 = i.getStringExtra("Text1");
        str2 = i.getStringExtra("Text2");
        str3 = i.getStringExtra("Text3");

        text1.setText(str1);
        text2.setText(str2);
        text3.setText(str3);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak(str2,TextToSpeech.QUEUE_FLUSH,null);

            }
        });


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