package com.example.lg.cpa;

/**
 * Created by kdh on 2016-06-01.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class SingleItemView extends Activity implements TextToSpeech.OnInitListener {

    TextView txtclasses;
    TextView txtword;
    TextView txtkanzi;
    TextView txtmean;
    TextView txtlevel;

    String classes;
    String word;
    String kanzi;
    String mean;
    String level;

    Button soundBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        // Get the results of rank
        classes = i.getStringExtra("classes");
        soundBtn = (Button)findViewById(R.id.sound);
        // Get the results of country
        word = i.getStringExtra("word");
        // Get the results of population
        kanzi = i.getStringExtra("kanzi");
        mean = i.getStringExtra("mean");
        level = i.getStringExtra("level");
        // Locate the TextViews in singleitemview.xml
        txtclasses = (TextView) findViewById(R.id.classes);
        txtword = (TextView) findViewById(R.id.word);
        txtkanzi = (TextView) findViewById(R.id.kanzi);
        txtmean = (TextView) findViewById(R.id.mean);
        txtlevel = (TextView) findViewById(R.id.level);
        // Load the results into the TextViews
        txtclasses.setText(classes);
        txtword.setText(word);
        txtkanzi.setText(kanzi);
        txtmean.setText(mean);
        txtlevel.setText(level);

        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak(word,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
   }

    TextToSpeech _tts;
    boolean _ttsActive = false;

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
