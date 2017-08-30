package com.example.lg.cpa;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class grammar_level_ch5 extends AppCompatActivity implements View.OnClickListener {


    Button prev;
    Button next;
    ViewFlipper flipper;
    SoundPool pool;
    Button test;
    int aiueo,kakikuke,sasisuseso,tachituteto,naninuneno,hahihuheho,mamimumemo,yayuyo,rarirurero,wawonn;
    Button b1;
    int kya,gya,sya,zya,cha,nya,hya,bya,pya,mya,rya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_level_ch5);


        pool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        kya = pool.load(this, R.raw.kya,1);
        gya = pool.load(this,R.raw.gya,1);
        sya = pool.load(this,R.raw.sya,1);
        zya = pool.load(this,R.raw.zya,1);
        cha = pool.load(this,R.raw.cha,1);
        nya = pool.load(this,R.raw.nya,1);
        hya = pool.load(this,R.raw.hya,1);
        bya = pool.load(this,R.raw.bya,1);
        pya = pool.load(this,R.raw.pya,1);
        mya = pool.load(this,R.raw.mya,1);
        rya = pool.load(this,R.raw.rya,1);


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

        if(v == next && i<11){
            flipper.showNext();
            if(i<11)
                i++;
        }
        else  if(v == prev && i>0) {
            flipper.showPrevious();
            if(i>0)
                i--;
        }
    }

    public void backButton(View v){
        Intent intent = new Intent(getApplicationContext(), grammar_level1.class);
        startActivity(intent);
    }
    public void sdButton(View v){
        switch (i) {
            case 0:
                break;
            case 1:
                pool.play(kya, 1, 1, 0, 0, 1);
                break;
            case 2:
                pool.play(gya, 1, 1, 0, 0, 1);
                break;
            case 3:
                pool.play(sya, 1, 1, 0, 0, 1);
                break;
            case 4:
                pool.play(zya, 1, 1, 0, 0, 1);
                break;
            case 5:
                pool.play(cha, 1, 1, 0, 0, 1);
                break;
            case 6:
                pool.play(nya, 1, 1, 0, 0, 1);
                break;
            case 7:
                pool.play(hya, 1, 1, 0, 0, 1);
                break;
            case 8:
                pool.play(bya, 1, 1, 0, 0, 1);
                break;
            case 9:
                pool.play(pya, 1, 1, 0, 0, 1);
                break;
            case 10:
                pool.play(mya, 1, 1, 0, 0, 1);
                break;
            case 11:
                pool.play(rya, 1, 1, 0, 0, 1);
                break;
        }
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
        }
        return super.onOptionsItemSelected(item);
    }
}