package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Ko_conversation extends AppCompatActivity {

    ListView listView;
    ArrayList<Ko> n5_info_list;
    Ko_Adapter myadapter;

    Ko item[]= new Ko[11];
    Intent intent[] = new Intent[110];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ko_conversation);
        listView = (ListView)findViewById(R.id.listView);
        item[0] = new Ko("안녕하세요","한국어 회화");
        item[1] = new Ko("처음 뵙겠습니다.","한국어 회화");
        item[2] = new Ko("감사합니다.","한국어 회화");
        item[3] = new Ko("안녕히 가세요.","한국어 회화");
        item[4] = new Ko("안녕히 계세요.","한국어 회화");
        item[5] = new Ko("축하합니다.","한국어 회화");
        item[6] = new Ko("새해 복 많이 받으세요.","한국어 회화");
        item[7] = new Ko("안녕히 주무세요.","한국어 회화");
        item[8] = new Ko("~안녕히 주무셨어요.","한국어 회화");
        item[9] = new Ko("어서 오세요.","한국어 회화");
        item[10] = new Ko("괜찮아요.","한국어 회화");
        n5_info_list = new ArrayList<Ko>();
        for(int i=0; i<10; i++)
            n5_info_list.add(item[i]);

        myadapter = new Ko_Adapter(getApplicationContext(),R.layout.ko_conversationviewitem, n5_info_list);
        listView.setAdapter(myadapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent[0] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[0].putExtra("check","0");
                        startActivity(intent[0]);
                        break;
                    case 1:
                        intent[1] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[1].putExtra("check", "1");
                        startActivity(intent[1]);
                        break;
                    case 2:
                        intent[2] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[2].putExtra("check", "2");
                        startActivity(intent[2]);
                        break;
                    case 3:
                        intent[3] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[3].putExtra("check", "3");
                        startActivity(intent[3]);
                        break;
                    case 4:
                        intent[4] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[4].putExtra("check", "4");
                        startActivity(intent[4]);
                        break;

                    case 5:
                        intent[5] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[5].putExtra("check", "5");
                        startActivity(intent[4]);
                        break;

                    case 6:
                        intent[6] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[6].putExtra("check", "6");
                        startActivity(intent[4]);
                        break;

                    case 7:
                        intent[7] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[7].putExtra("check", "7");
                        startActivity(intent[4]);
                        break;

                    case 8:
                        intent[8] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[8].putExtra("check", "8");
                        startActivity(intent[4]);
                        break;

                    case 9:
                        intent[9] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[9].putExtra("check", "9");
                        startActivity(intent[4]);
                        break;

                    case 10:
                        intent[10] = new Intent(getApplicationContext(),Ko_singleItemView.class);
                        intent[10].putExtra("check", "10");
                        startActivity(intent[4]);
                        break;



                }
                // Intent intent = new Intent(getApplicationContext(), jp.class); // 다음넘어갈 화면
            }
        });
    }
}
