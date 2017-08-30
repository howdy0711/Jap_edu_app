package com.example.lg.cpa;

import android.content.Intent;
import android.media.SoundPool;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Locale;

public class conversation_katakana extends AppCompatActivity implements View.OnClickListener, OnInitListener{
ImageButton imgButton;
    TextView donki,loson,buger,family,macdo,mister,saizeriya,seven_e,uniqlo;

    Button prev;
    Button next;
    ViewFlipper flipper;
    Button b1;
    TextToSpeech _tts;
    boolean _ttsActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_katakana);
        imgButton = (ImageButton) findViewById(R.id.imgButton1);


        buger = (TextView) findViewById(R.id.buger);
        donki = (TextView) findViewById(R.id.donki);
        family = (TextView) findViewById(R.id.family);
        loson = (TextView) findViewById(R.id.loson);
        macdo = (TextView) findViewById(R.id.macdo);
        mister = (TextView) findViewById(R.id.mister);
        saizeriya = (TextView) findViewById(R.id.saizeiya);
        seven_e = (TextView) findViewById(R.id.seven_e);
        uniqlo = (TextView) findViewById(R.id.uniqlo);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        b1 = (Button) findViewById(R.id.sdButton);
    }
    int i = 0;

    @Override
    public void onClick(View v) {

        if(v == next && i<8){
            flipper.showNext();
            if(i<8)
                i++;
        }
        else  if(v == prev && i>0) {
            flipper.showPrevious();
            if(i>0)
                i--;
        }
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

    public void sdButton(View view){
        switch (i){
            case 0:

                donki.setVisibility(View.VISIBLE);
                family.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("ドンキホーテ",TextToSpeech.QUEUE_FLUSH,null);

                break;
            case 1:
                buger.setVisibility(View.VISIBLE);
                donki.setVisibility(View.INVISIBLE);
                family.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("バーガーキング",TextToSpeech.QUEUE_FLUSH,null);

                break;
            case 2:
                family.setVisibility(View.VISIBLE);
                donki.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("ファミリーマート",TextToSpeech.QUEUE_FLUSH,null);


                break;
            case 3:
                loson.setVisibility(View.VISIBLE);
                donki.setVisibility(View.INVISIBLE);
                family.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("ローソン",TextToSpeech.QUEUE_FLUSH,null);

                break;
            case 4:
                macdo.setVisibility(View.VISIBLE);
                donki.setVisibility(View.VISIBLE);
                family.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("マクナルドハンバーガー",TextToSpeech.QUEUE_FLUSH,null);

                break;
            case 5:
                mister.setVisibility(View.VISIBLE);
                donki.setVisibility(View.INVISIBLE);
                family.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("ミスタードーナツ",TextToSpeech.QUEUE_FLUSH,null);

                break;
            case 6:
                saizeriya.setVisibility(View.VISIBLE);
                donki.setVisibility(View.INVISIBLE);
                family.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("サイザリア",TextToSpeech.QUEUE_FLUSH,null);

                break;
            case 7:
                seven_e.setVisibility(View.VISIBLE);
                donki.setVisibility(View.INVISIBLE);
                family.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                uniqlo.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("セブンーイレブン",TextToSpeech.QUEUE_FLUSH,null);

                break;
            case 8:
                uniqlo.setVisibility(View.VISIBLE);
                donki.setVisibility(View.VISIBLE);
                family.setVisibility(View.INVISIBLE);
                loson.setVisibility(View.INVISIBLE);
                macdo.setVisibility(View.INVISIBLE);
                mister.setVisibility(View.INVISIBLE);
                saizeriya.setVisibility(View.INVISIBLE);
                seven_e.setVisibility(View.INVISIBLE);
                buger.setVisibility(View.INVISIBLE);
                _tts.setLanguage(Locale.JAPAN);
                _ttsActive = true;
                _tts.speak("ユニクロ",TextToSpeech.QUEUE_FLUSH,null);

                break;
        }
    }

    public void backButton(View v){
        Intent intent = new Intent(getApplicationContext(),conversation.class);
        startActivity(intent);
    }
}
