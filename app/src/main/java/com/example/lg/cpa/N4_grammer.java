package com.example.lg.cpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class N4_grammer extends AppCompatActivity {

    ListView listView;
    ArrayList<N4> n4_info_list;
    N4_Adapter myadapter;

    N4 item[]= new N4[11];
    Intent intent[] = new Intent[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n5_grammer);
        listView = (ListView)findViewById(R.id.listView);
        item[0] = new N4("조사","が");
        item[1] = new N4("조사","は");
        item[2] = new N4("조사","を");
        item[3] = new N4("조사","の");
        item[4] = new N4("조사","と");
        item[5] = new N4("조사","や");
        item[6] = new N4("조사","に");
        item[7] = new N4("조사","へ");
        item[8] = new N4("조사","で");
        item[9] = new N4("조사","から");
        item[10] = new N4("조사","まで");


        n4_info_list = new ArrayList<N4>();
        for(int i=0; i<11; i++)
            n4_info_list.add(item[i]);

        myadapter = new N4_Adapter(getApplicationContext(),R.layout.n4_grammerviewitem, n4_info_list);
        listView.setAdapter(myadapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent[0] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[0].putExtra("Text1","が　~(이)가");
                        intent[0].putExtra("Text2","花は美しいです");
                        intent[0].putExtra("Text3","꽃은 아름답습니다.");
                        startActivity(intent[0]);
                        break;
                    case 1:
                        intent[1] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[1].putExtra("Text1","は ~(은)는");
                        intent[1].putExtra("Text2","私は学生です。");
                        intent[1].putExtra("Text3","저는 학생입니다.");
                        startActivity(intent[1]);
                        break;
                    case 2:
                        intent[2] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[2].putExtra("Text1","あなた 당신 ");
                        intent[2].putExtra("Text2","あなたは学生ですか。");
                        intent[2].putExtra("Text3","당신은 학생입니까?");
                        startActivity(intent[2]);
                        break;
                    case 3:
                        intent[3] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[3].putExtra("Text1","を ~(을)를");
                        intent[3].putExtra("Text2","ごはんを食べます。");
                        intent[3].putExtra("Text3","밥을 먹습니다.");
                        startActivity(intent[3]);
                        break;
                    case 4:
                        intent[4] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[4].putExtra("Text1","の　~의,~의것");
                        intent[4].putExtra("Text2","これは私の本です。");
                        intent[4].putExtra("Text3","이것은 저의 책입니다.");
                        startActivity(intent[4]);
                        break;
                    case 5:
                        intent[5] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[5].putExtra("Text1","と ~와,과" );
                        intent[5].putExtra("Text2","本とえんぴつ");
                        intent[5].putExtra("Text3","책과 연필");
                        startActivity(intent[5]);
                        break;
                    case 6:
                        intent[6] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[6].putExtra("Text1","や　~이나");
                        intent[6].putExtra("Text2","りんごやいちごがあります");
                        intent[6].putExtra("Text3","사과와 딸기가 있습니다");
                        startActivity(intent[6]);
                        break;

                    case 7:
                        intent[7] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[7].putExtra("Text1","に ~에(시간,장소)");
                        intent[7].putExtra("Text2","私は家にいます");
                        intent[7].putExtra("Text3","저는 집에 있습니다.");
                        startActivity(intent[7]);
                        break;
                    case 8:
                        intent[8] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[8].putExtra("Text1","へ ~로(방향)");
                        intent[8].putExtra("Text2","日本へ行きます");
                        intent[8].putExtra("Text3","일본에 갑니다.");
                        startActivity(intent[8]);
                        break;
                    case 9:
                        intent[9] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[9].putExtra("Text1","で ~에서(장소,수단)");
                        intent[9].putExtra("Text2","車で行いきます。");
                        intent[9].putExtra("Text3","차로 갑니다.");
                        startActivity(intent[9]);
                        break;
                    case 10:
                        intent[10] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[10].putExtra("Text1","から ~에서,부터");
                        intent[10].putExtra("Text2","９時からです。");
                        intent[10].putExtra("Text3","9시부터 입니다");
                        startActivity(intent[10]);
                        break;
                    case 11:
                        intent[11] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[11].putExtra("Text1","まで ~까지");
                        intent[11].putExtra("Text2","５時までです。");
                        intent[11].putExtra("Text3","9시까지 입니다.");
                        startActivity(intent[11]);
                        break;
                }
            }
        });
    }
}
