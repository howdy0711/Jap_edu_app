package com.example.lg.cpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Dadami extends AppCompatActivity {

    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dadami);
        textview = (TextView)findViewById(R.id.textID);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_read, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.hangle) {
            textview.setText("다다미는 전통적인 일본식 방에 까는 장판입니다." +
                    " 습기가 많고 여름은 덥고 겨울은 추운 일본의 기후 아래에서는" +
                    " 옛날부터 주택에 없어서는 안 되는 존재였습니다. 그것은 다다미가" +
                    " 갖는 습기조절효과와 단열효과가 우수하기 때문입니다. 이 밖에도 " +
                    "다다미에는 방음효과와, 공기청정효과도 있습니다. 제 2차 세계대전 " +
                    "이후, 전통적인 일본 식 방이 있는 주택은 줄어들었지만, 다다미가 갖는"+
                    " 따뜻함, 일본의 전통적인 인테리어 요소, 자연소재 사용에 의한 안전성에" +
                    " 주목이 모아지고 있습니다. 예컨대, 정사각형의 오키나와 다다미나 선이" +
                    " 없는 무선 다다미를 솜씨 좋게 도입한 주택 등을 들 수 있습니다. 이처럼," +
                    " 다다미는 다시 한번 장판으로써 재인식하는 움직임이 나타나고 있습니다.");
        }

        if(id == R.id.nihon){
            textview.setText("畳は、和室に敷かれる床材です。湿気が多く、夏は暑く" +
                    "、冬は寒い日本の気候の下では、古くから住宅に不可欠な存在でした" +
                    "。それは、畳に調湿、断熱効果が優れているからです。他にも、畳には" +
                    "防音効果や、空気清浄効果もあります。第二次世界大戦以降、和室を持つ住" +
                    "宅が減少しましたが、畳の持つ暖かさ、日本伝統のインテリア要素、" +
                    "自然素材の使用による安全性に注目が集まっています。例えば、" +
                    "正方形の琉球畳や縁のない縁なし畳を上手く取り入れた住宅などがあげられます。" +
                    "このように、畳は再び床材として見直す動きが出てきています。");
        }

        if(id == R.id.word){
            textview.setText("ふち 縁　: 가장자리, 테두리 \n" +
                    "たたみ 畳 : 다다미\n" +
                    "きおん 気温 : 기온");
            textview.setTextSize(20);
        }

        return super.onOptionsItemSelected(item);
    }
}
