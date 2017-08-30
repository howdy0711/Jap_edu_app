package com.example.lg.cpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Sonkego extends AppCompatActivity {


    ListView listView;
    ArrayList<Sonkego_info> sonkego_info_list;
    Sonkego_Adapter myadapter;
    Sonkego_info item[]= new Sonkego_info[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonkego);
        listView = (ListView)findViewById(R.id.listView);

        item[0] = new Sonkego_info("특별 존경어","召し上がる");
        item[1] = new Sonkego_info("특별 겸양어","いただく");
        item[2] = new Sonkego_info("존경어","お（ご）＋ます＋になる");
        item[3] = new Sonkego_info("겸양어","お（ご）＋ます＋する");
        item[4] = new Sonkego_info("정중체","ます、です");

        sonkego_info_list = new ArrayList<Sonkego_info>();

        for(int i=0; i<5;i++)
        sonkego_info_list.add(item[i]);

        myadapter = new Sonkego_Adapter(getApplicationContext(),R.layout.sonkego_itemview, sonkego_info_list);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(getApplicationContext(),Sonkego_singleItemView.class);
                        intent0.putExtra("check","0");
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(),Sonkego_singleItemView.class);
                        intent1.putExtra("check","1");
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(),Sonkego_singleItemView.class);
                        intent2.putExtra("check","2");
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(),Sonkego_singleItemView.class);
                        intent3.putExtra("check","3");
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(),Sonkego_singleItemView.class);
                        intent4.putExtra("check","4");
                        startActivity(intent4);
                        break;
                }
            }
        });

    }
}
