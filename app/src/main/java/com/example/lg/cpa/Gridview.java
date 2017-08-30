package com.example.lg.cpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Gridview extends AppCompatActivity  {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gridview);
        initUi();
        setGridView();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Gridview.this, GridCustomAdapter.imagesnames[position], Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), kaiwa.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(), kaiwa2.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getApplicationContext(), kaiwa3.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(getApplicationContext(), kaiwa4.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(getApplicationContext(), kaiwa5.class);
                        startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6 = new Intent(getApplicationContext(), kaiwa6.class);
                        startActivity(intent6);
                        break;
                    case 6:
                        Intent intent7 = new Intent(getApplicationContext(), kaiwa7.class);
                        startActivity(intent7);
                        break;
                    case 7:
                        Intent intent8 = new Intent(getApplicationContext(), kaiwa8.class);
                        startActivity(intent8);
                        break;
                    case 8:
                        Intent intent9 = new Intent(getApplicationContext(), kaiwa9.class);
                        startActivity(intent9);
                        break;
                }
            }
        });
    }

    private void setGridView() {
        gridView.setAdapter(new GridCustomAdapter(this));
    }
    private void initUi() {
        gridView = (GridView) findViewById(R.id.gridview);
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