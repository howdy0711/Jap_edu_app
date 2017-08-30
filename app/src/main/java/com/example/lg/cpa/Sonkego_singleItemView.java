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
public class Sonkego_singleItemView extends AppCompatActivity implements TextToSpeech.OnInitListener {
    String check;

    Button b1,b2,b3,b4,b5,b6,b7;

    TextToSpeech _tts;
    boolean _ttsActive = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();

        check = i.getStringExtra("check");

        if (check.equals("0")) {
            setContentView(R.layout.sonkego_singleitemview);
            b1 = (Button) findViewById(R.id.t2);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak(b1.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b2 = (Button) findViewById(R.id.t3);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak("めしあがる",TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b3 = (Button) findViewById(R.id.t4);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak(b3.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b4 = (Button) findViewById(R.id.t5);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak(b4.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b5 = (Button) findViewById(R.id.t6);
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak(b5.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b6 = (Button) findViewById(R.id.t7);
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak("ごらんになる",TextToSpeech.QUEUE_FLUSH,null);
                }
            });





        }
        if (check.equals("1")) {
            setContentView(R.layout.sonkego_singleitemview2);
            b1 = (Button) findViewById(R.id.t2);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak("まいる、うかがう",TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b2 = (Button) findViewById(R.id.t3);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak("おる",TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b3 = (Button) findViewById(R.id.t4);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak(b3.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b4 = (Button) findViewById(R.id.t5);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak(b4.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b5 = (Button) findViewById(R.id.t6);
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak(b5.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b6 = (Button) findViewById(R.id.t7);
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak("ぞんじている",TextToSpeech.QUEUE_FLUSH,null);
                }
            });

            b7 = (Button) findViewById(R.id.t8);
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _tts.setLanguage(Locale.JAPAN);
                    _ttsActive = true;
                    _tts.speak("おめにかかる",TextToSpeech.QUEUE_FLUSH,null);
                }
            });
        }
        if (check.equals("2"))
            setContentView(R.layout.sonkego_singleitemview3);
        if (check.equals("3"))
            setContentView(R.layout.sonkego_singleitemview4);
        if (check.equals("4"))
            setContentView(R.layout.sonkego_singleitemview5);
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
