package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class N2_grammer extends AppCompatActivity {

    ListView listView;
    ArrayList<N2> n5_info_list;
    N2_Adapter myadapter;

    N2 item[]= new N2[5];
    Intent intent[] = new Intent[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n2_grammer);
        listView = (ListView)findViewById(R.id.listView);
        item[0] = new N2("～あげく, ～あげくに","N2 문법");
        item[1] = new N2("~あまり, ～あまりに","N2 문법");
        item[2] = new N2("~以上（いじょう), ～以上は","N2 문법");
        item[3] = new N2("～一方(いっぽう), ～一方で","N2 문법");
        item[4] = new N2("~(よ）うではないか","N2 문법");
        n5_info_list = new ArrayList<N2>();
        for(int i=0; i<5; i++)
            n5_info_list.add(item[i]);

        myadapter = new N2_Adapter(getApplicationContext(),R.layout.n2_grammerviewitem, n5_info_list);
        listView.setAdapter(myadapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent[0] = new Intent(getApplicationContext(),N2_singleItemView.class);
                        intent[0].putExtra("check","0");
                        startActivity(intent[0]);
                        break;
                    case 1:
                        intent[1] = new Intent(getApplicationContext(),N2_singleItemView.class);
                        intent[1].putExtra("check", "1");
                        startActivity(intent[1]);
                        break;
                    case 2:
                        intent[2] = new Intent(getApplicationContext(),N2_singleItemView.class);
                        intent[2].putExtra("check", "2");
                        startActivity(intent[2]);
                        break;
                    case 3:
                        intent[3] = new Intent(getApplicationContext(),N2_singleItemView.class);
                        intent[3].putExtra("check", "3");
                        startActivity(intent[3]);
                        break;
                    case 4:
                        intent[4] = new Intent(getApplicationContext(),N2_singleItemView.class);
                        intent[4].putExtra("check", "4");
                        startActivity(intent[4]);
                        break;


                }
                // Intent intent = new Intent(getApplicationContext(), jp.class); // 다음넘어갈 화면
            }
        });
    }
}
