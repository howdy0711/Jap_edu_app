package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class N3_grammer extends AppCompatActivity {

    ListView listView;
    ArrayList<N3> n5_info_list;
    N3_Adapter myadapter;

    N3 item[]= new N3[11];
    Intent intent[] = new Intent[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n3_grammer);
        listView = (ListView)findViewById(R.id.listView);
        item[0] = new N3("동사 ます형","그룹별 형태");
        item[1] = new N3("동사 て형","그룹별 형태");
        item[2] = new N3("동사 た형","그룹별 형태");
        item[3] = new N3("동사의 가능형","그룹별 형태");
        item[4] = new N3("동사의 부정형","그룹별 형태");
        item[5] = new N3("동사의 의지형","그룹별 형태");
        item[6] = new N3("동사의 수동형","그룹별 형태");
        item[7] = new N3("동사의 사역형","그룹별 형태");
        item[8] = new N3("동사의 사역수동형","그룹별 형태");
        item[9] = new N3("동사의 명령형","그룹별 형태");
        item[10] = new N3("가정형","그룹별 형태");
        n5_info_list = new ArrayList<N3>();
        for(int i=0; i<11; i++)
            n5_info_list.add(item[i]);

        myadapter = new N3_Adapter(getApplicationContext(),R.layout.n3_grammerviewitem, n5_info_list);
        listView.setAdapter(myadapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent[0] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[0].putExtra("check","0");
                        startActivity(intent[0]);
                        break;
                    case 1:
                        intent[1] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[1].putExtra("check", "1");
                        startActivity(intent[1]);
                        break;
                    case 2:
                        intent[2] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[2].putExtra("check", "2");
                        startActivity(intent[2]);
                        break;
                    case 3:
                        intent[3] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[3].putExtra("check", "3");
                        startActivity(intent[3]);
                        break;
                    case 4:
                        intent[4] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[4].putExtra("check", "4");
                        startActivity(intent[4]);
                        break;
                    case 5:
                        intent[5] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[5].putExtra("check", "5");
                        startActivity(intent[5]);
                        break;
                    case 6:
                        intent[6] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[6].putExtra("check","6");
                        startActivity(intent[6]);
                        break;
                    case 7:
                        intent[7] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[7].putExtra("check", "7");
                        startActivity(intent[7]);
                        break;
                    case 8:
                        intent[8] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[8].putExtra("check", "8");
                        startActivity(intent[8]);
                        break;
                    case 9:
                        intent[9] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[9].putExtra("check", "9");
                        startActivity(intent[9]);
                        break;
                    case 10:
                        intent[10] = new Intent(getApplicationContext(),N3_singleItemView.class);
                        intent[10].putExtra("check", "10");
                        startActivity(intent[10]);
                        break;

                }
                // Intent intent = new Intent(getApplicationContext(), jp.class); // 다음넘어갈 화면
            }
        });
    }
}
