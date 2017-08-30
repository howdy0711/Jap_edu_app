package com.example.lg.cpa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class grammar_level3 extends AppCompatActivity {
    Button diciton,test;
    Button grammer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_level3);

        grammer = (Button)findViewById(R.id.n4_grammer);


        grammer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),N4_grammer.class);
                startActivity(intent);
            }
        });

        diciton = (Button)findViewById(R.id.button18);

        diciton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Dictionary.class);
                startActivity(intent);
            }
        });
        test = (Button)findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),test_jlpt4.class);
                startActivity(intent);
            }
        });

    }

    public void backButton(View view){
        Intent intent = new Intent(getApplicationContext(),grammar.class);
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
