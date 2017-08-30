package com.example.lg.cpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class N5_grammer extends AppCompatActivity {

    ListView listView;
    ArrayList<N5> n5_info_list;
    N5_Adapter myadapter;

    N5 item[]= new N5[17];
    Intent intent[] = new Intent[17];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n5_grammer);
        listView = (ListView)findViewById(R.id.listView);
        item[0] = new N5("인칭대명사","私");
        item[1] = new N5("인칭대명사","僕");
        item[2] = new N5("인칭대명사","あなた");
        item[3] = new N5("인칭대명사","君（きみ）");
        item[4] = new N5("인칭대명사","彼（かれ）");
        item[5] = new N5("인칭대명사","彼女（かのじょ）");
        item[6] = new N5("인칭대명사","誰（だれ）");
        item[7] = new N5("인칭대명사","どなた");
        item[8] = new N5("명사(명사의 변환)","だ（である）");
        item[9] = new N5("명사(명사의 변환)","です");
        item[10] = new N5("명사(명사의 변환)","ではありません");
        item[11] = new N5("명사(명사의 변환)","ではない");
        item[12] = new N5("명사(명사의 변환)","ではなかった");
        item[13] = new N5("명사(명사의 변환)","だった");
        item[14] = new N5("명사(명사의 변환)","でした");
        item[15] = new N5("명사(명사의 변환)","ではありませんでした");
        item[16] = new N5("명사(명사의 변환)","で");

        n5_info_list = new ArrayList<N5>();
        for(int i=0; i<17; i++)
        n5_info_list.add(item[i]);

        myadapter = new N5_Adapter(getApplicationContext(),R.layout.n5_grammerviewitem, n5_info_list);
        listView.setAdapter(myadapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent[0] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[0].putExtra("Text1","私（わたし）나,저");
                        intent[0].putExtra("Text2","私は学生です。");
                        intent[0].putExtra("Text3","저는 학생입니다.");
                        startActivity(intent[0]);
                        break;
                    case 1:
                        intent[1] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[1].putExtra("Text1","僕（ぼく）나,저(남성)");
                        intent[1].putExtra("Text2","僕は学生です。");
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
                        intent[3].putExtra("Text1","君（きみ）너");
                        intent[3].putExtra("Text2","君は学生？");
                        intent[3].putExtra("Text3","너는 학생이야?");
                        startActivity(intent[3]);
                        break;
                    case 4:
                        intent[4] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[4].putExtra("Text1","彼（かれ）그");
                        intent[4].putExtra("Text2","彼は学生ですか。");
                        intent[4].putExtra("Text3","그는 학생입니까?");
                        startActivity(intent[4]);
                        break;
                    case 5:
                        intent[5] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[5].putExtra("Text1","彼女 (かのじょ）그녀" );
                        intent[5].putExtra("Text2","彼女は学生ですか。");
                        intent[5].putExtra("Text3","그녀는 학생입니까?");
                        startActivity(intent[5]);
                        break;
                    case 6:
                        intent[6] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[6].putExtra("Text1","誰（だれ）누구");
                        intent[6].putExtra("Text2","誰が学生ですか");
                        intent[6].putExtra("Text3","누가 학생입니까?");
                        startActivity(intent[6]);
                        break;

                    case 7:
                        intent[7] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[7].putExtra("Text1","どなた 어느분");
                        intent[7].putExtra("Text2","どなたが学生ですか");
                        intent[7].putExtra("Text3","어는분이 학생입니까?");
                        startActivity(intent[7]);
                        break;
                    case 8:
                        intent[8] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[8].putExtra("Text1","だ（である）~이다");
                        intent[8].putExtra("Text2","学生だ、学生である");
                        intent[8].putExtra("Text3","학생이다");
                        startActivity(intent[8]);
                        break;
                    case 9:
                        intent[9] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[9].putExtra("Text1","です ~이다");
                        intent[9].putExtra("Text2","学生です。");
                        intent[9].putExtra("Text3","학생입니다.");
                        startActivity(intent[9]);
                        break;
                    case 10:
                        intent[10] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[10].putExtra("Text1","ではありませいん ~이(가)아닙니다.");
                        intent[10].putExtra("Text2","学生ではありません。");
                        intent[10].putExtra("Text3","학생이 아닙니다.");
                        startActivity(intent[10]);
                        break;
                    case 11:
                        intent[11] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[11].putExtra("Text1","ではない ~(이)가아니다");
                        intent[11].putExtra("Text2","学生ではない。");
                        intent[11].putExtra("Text3","학생이 아니다.");
                        startActivity(intent[11]);
                        break;
                    case 12:
                        intent[12] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[12].putExtra("Text1","はなかった ~이(가)아니었다");
                        intent[12].putExtra("Text2","学生ではなかった。");
                        intent[12].putExtra("Text3","학생이 아니었다.");
                        startActivity(intent[12]);
                        break;
                    case 13:
                        intent[13] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[13].putExtra("Text1","だった　~이었다");
                        intent[13].putExtra("Text2","学生だった。");
                        intent[13].putExtra("Text3","학생이었다.");
                        startActivity(intent[13]);
                        break;
                    case 14:
                        intent[14] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[14].putExtra("Text1","でした　~이었습니다.");
                        intent[14].putExtra("Text2","学生でした。");
                        intent[14].putExtra("Text3","학생이었습니다.");
                        startActivity(intent[14]);
                        break;
                    case 15:
                        intent[15] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[15].putExtra("Text1","ではありませんでした 아니었습니다.");
                        intent[15].putExtra("Text2","学生ではありませんでした。");
                        intent[15].putExtra("Text3","학생이 아니었습니다.");
                        startActivity(intent[15]);
                        break;
                    case 16:
                        intent[16] = new Intent(getApplicationContext(),N5_singleItemView.class);
                        intent[16].putExtra("Text1","で　이고");
                        intent[16].putExtra("Text2","学生で");
                        intent[16].putExtra("Text3","학생이고");
                        startActivity(intent[16]);
                        break;
                }
            }
        });
    }
}
