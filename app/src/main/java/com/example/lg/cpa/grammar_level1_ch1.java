package com.example.lg.cpa;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

    public class grammar_level1_ch1 extends AppCompatActivity implements View.OnClickListener{

        Button prev;
        Button next;
        ViewFlipper flipper;
        SoundPool pool;
        int aiueo,kakikuke,sasisuseso,tachituteto,naninuneno,hahihuheho,mamimumemo,yayuyo,rarirurero,wawonn;
        Button b1;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_level1_ch1);

        pool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        aiueo = pool.load(this, R.raw.aiueo,1);
            kakikuke = pool.load(this,R.raw.kakikuke,1);
            sasisuseso = pool.load(this,R.raw.sasisuseso,1);
            tachituteto = pool.load(this,R.raw.tachituteto,1);
            naninuneno = pool.load(this,R.raw.naninuneno,1);
            hahihuheho = pool.load(this,R.raw.hahihuheho,1);
            mamimumemo = pool.load(this,R.raw.mamimumemo,1);
            yayuyo = pool.load(this,R.raw.yayuyo,1);
            rarirurero = pool.load(this,R.raw.rarirurero,1);
            wawonn = pool.load(this,R.raw.wawonn,1);

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

         if(v == next && i<9){
            flipper.showNext();
             if(i<9)
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
           pool.play(aiueo, 1, 1, 0, 0, 1);
           break;
           case 1:
               pool.play(kakikuke, 1, 1, 0, 0, 1);
               break;
           case 2:
               pool.play(sasisuseso, 1, 1, 0, 0, 1);
               break;
           case 3:
               pool.play(tachituteto, 1, 1, 0, 0, 1);
               break;
           case 4:
               pool.play(naninuneno, 1, 1, 0, 0, 1);
               break;
           case 5:
               pool.play(hahihuheho, 1, 1, 0, 0, 1);
               break;
           case 6:
               pool.play(mamimumemo, 1, 1, 0, 0, 1);
               break;
           case 7:
               pool.play(yayuyo, 1, 1, 0, 0, 1);
               break;
           case 8:
               pool.play(rarirurero, 1, 1, 0, 0, 1);
               break;
           case 9:
               pool.play(wawonn, 1, 1, 0, 0, 1);
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






