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

public class grammar_level_ch3 extends AppCompatActivity implements View.OnClickListener {

    Button prev;
    Button next;
    ViewFlipper flipper;
    SoundPool pool;
    Button b1;
    int gahang,bahang,jahang,dahang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_level_ch3);

        pool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        gahang = pool.load(this,R.raw.gahang,1);
        jahang = pool.load(this,R.raw.jahang,1);
        dahang = pool.load(this,R.raw.dahang,1);
        bahang = pool.load(this,R.raw.bahang,1);

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

        if(v == next && i<3){
            flipper.showNext();
            if(i<3)
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
                pool.play(gahang, 1, 1, 0, 0, 1);
                break;
            case 1:
                pool.play(jahang, 1, 1, 0, 0, 1);
                break;
            case 2:
                pool.play(dahang, 1, 1, 0, 0, 1);
                break;
            case 3:
                pool.play(bahang, 1, 1, 0, 0, 1);
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
