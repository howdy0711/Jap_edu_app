package com.example.lg.cpa;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class conversation extends AppCompatActivity {

    Button bt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        bt3 = (Button)findViewById(R.id.button3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sonkego.class);
                startActivity(intent);
            }
        });
    }
    public void Listen(View view){
        Intent intent = new Intent(getApplicationContext(),Listen1.class);
        startActivity(intent);
    }
    public void backButton(View view){
        Intent intent = new Intent(getApplicationContext(), jp.class);
        startActivity(intent);
    }
    public void kaiwa(View view){
        Intent intent = new Intent(getApplicationContext(), Gridview.class);
        startActivity(intent);
    }
    public void Chat(View view){
        Intent intent = new Intent(getApplicationContext(), PlayRTCActivity.class);
        startActivity(intent);
        finish();
    }
    public void conversation_katakana(View view){
        Intent intent = new Intent(getApplicationContext(),conversation_katakana.class);
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
