package com.example.lg.cpa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class readView extends AppCompatActivity {

    private ListView listView;
    ArrayList<Human> h_info_list;
    HumanAdapter myadapter;
    Human myHuman1,myHuman2,myHuman3,myHuman4,myHuman6,myHuman7,myHuman8,myHuman9,myHuman10,myHuman11,myHuman12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_view);
        listView = (ListView)findViewById(R.id.listView);
        myHuman1 = new Human("NHK뉴스", "세븐일레븐 도시락재활용", "", BitmapFactory.decodeResource(getResources(), R.drawable.nhk));
        myHuman6 = new Human("문화", "스모", "", BitmapFactory.decodeResource(getResources(), R.drawable.sumo_read));
        myHuman7 = new Human("NHK뉴스", "마쯔시다전기", "", BitmapFactory.decodeResource(getResources(), R.drawable.nhk));
        myHuman8 = new Human("NHK뉴스", "미쯔비시 자동차", "", BitmapFactory.decodeResource(getResources(), R.drawable.nhk));
        myHuman9 = new Human("NHK뉴스", "아이 양육비", "", BitmapFactory.decodeResource(getResources(), R.drawable.nhk));
        myHuman10 = new Human("사회", "직장인 여름휴가", "", BitmapFactory.decodeResource(getResources(), R.drawable.summer_read));
        myHuman11 = new Human("문화", "다다미", "", BitmapFactory.decodeResource(getResources(), R.drawable.dadami_read));
        myHuman12 = new Human("앙케이트 조사", "흡연대책", "", BitmapFactory.decodeResource(getResources(), R.drawable.smoking_read));
        myHuman2 = new Human("영화소개", "godfather", "", BitmapFactory.decodeResource(getResources(), R.drawable.godfather));
        myHuman3 = new Human("영화소개", "LoveStory", "", BitmapFactory.decodeResource(getResources(), R.drawable.lovestory));
        myHuman4 = new Human("잡지","아키하바라탐험","",BitmapFactory.decodeResource(getResources(), R.drawable.megazine1));

        h_info_list = new ArrayList<Human>();

        h_info_list.add(myHuman10);
        h_info_list.add(myHuman11);
        h_info_list.add(myHuman12);
        h_info_list.add(myHuman6);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman3);
        h_info_list.add(myHuman4);
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman7);
        h_info_list.add(myHuman8);
        h_info_list.add(myHuman9);

        myadapter = new HumanAdapter(getApplicationContext(),R.layout.read_viewitem, h_info_list);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent0 = new Intent (getApplicationContext(),kyuka_read.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), Dadami.class);
                        startActivity(intent1);
                        break;
                }
                // Intent intent = new Intent(getApplicationContext(), jp.class); // 다음넘어갈 화면
            }
        });
    }
}
