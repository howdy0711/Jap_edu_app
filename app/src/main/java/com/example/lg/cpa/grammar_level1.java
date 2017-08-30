package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class grammar_level1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_level1);
    }


    public void backButton(View v){
        Intent intent = new Intent(getApplicationContext(), grammar.class);
        startActivity(intent);
    }
    public void hiragana(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar_level1_ch1.class);
        startActivity(intent);
    }
    public void katakana(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar_level_ch2.class);
        startActivity(intent);
    }
    public void tak(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar_level_ch3.class);
        startActivity(intent);
    }
    public void bantak(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar_level_ch4.class);
        startActivity(intent);
    }
    public void yo(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar_level_ch5.class);
        startActivity(intent);
    }
    public void chock(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar_level_ch6.class);
        startActivity(intent);
    }
    public void jang(View v) {
        Intent intent = new Intent(getApplicationContext(), grammar_level_ch7.class);
        startActivity(intent);
    }
    public void nng(View v){
        Intent intent = new Intent(getApplicationContext(), grammar_level_ch8.class);
        startActivity(intent);
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
