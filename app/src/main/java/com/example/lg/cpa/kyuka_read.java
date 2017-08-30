package com.example.lg.cpa;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class kyuka_read extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyuka_read);
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
            textview.setText("직업을 가지고 있는 사람의 올해 여름휴가 일수는 평균 6.3일," +
                    " 예산은 평균 10만 6천엔으로, 모두 지난 해(6.5일, 11만 5천엔)를 밑돌 " +
                    "것 같다. ABC 리서치가 19일 발표한 설문조사에 따른 것으로, 여름 휴가" +
                    "를 보내는 방법으로 ‘국내여행’(24.7%)이 2년 연속 톱이다. 이 외에 " +
                    "‘귀성’(15.6%), ‘가능한 한 집에 있는다’(9.6%), ‘해외여행’(5.9%)였다" +
                    ". 유원지나 캠프, 스포츠 등, 가까운 시설이나 행락지에 나가는 사람이 늘" +
                    "어나고 있는 것이 올해의 경향으로, ABC 리서치는 ‘시간과 돈의 균형을 " +
                    "잘 맞추고 있다’ 고 분석하고 있다. 조사는 6월 하순, 수도권에 사는 남녀" +
                    " 630명을 대상으로 실시했다.\n");
        }

        if(id == R.id.nihon){
            textview.setText("仕事を持っている人の今年の夏休み日数は平均６・３日、" +
                    "予算は同１０万６０００円で、いずれも前年（６・５日、１１万５０００円）" +
                    "を下回りそうだ。ＡＢＣリサーチが１９日発表したアンケート調査によるもので、" +
                    "夏休みの過ごし方は「国内旅行」（２４・７％）が２年連続トップ。このほか「帰省」" +
                    "（１５・６％）、「なるべく家にいる」（９・６％）「海外旅行」（５・９％）だった" +
                    "。遊園地やキャンプ、スポーツなど、身近な施設や行楽地に出かける人が増え" +
                    "ているのが今年の傾向で、ＡＢＣリサーチは「時間とお金を上手にバランスさ" +
                    "せている」と分析している。調査は６月下旬、首都圏に住む男女６３０人を対象に行った。\n");
        }

        if(id == R.id.word){
            textview.setText("仕事(しごと) 일. 직업\n" +
                    "日数(にっすう) 일수\n" +
                    "平均(へいきん) 평균\n" +
                    "予算(よさん) 예산\n" +
                    "前年(ぜんねん) 전년\n" +
                    "下回(したまわ)る 밑돌다\n" +
                    "リサーチ 리서치\n" +
                    "発表(はっぴょう) 발표\n" +
                    "アンケート調査(ちょうさ) 설문조사\n" +
                    "国内旅行(こくないりょこう) 국내여행\n" +
                    "連続(れんぞく) 연속\n" +
                    "トップ 톱\n" +
                    "帰省(きせい) 귀성\n" +
                    "なるべく 가능한 한\n" +
                    "海外旅行(かいがいりょこう) 해외여행\n" +
                    "遊園地(ゆうえんち) 유원지\n" +
                    "キャンプ 캠프\n" +
                    "スポーツ 스포츠\n" +
                    "身近(みぢか) 자기 주변\n" +
                    "施設(しせつ) 시설\n" +
                    "行楽地(こうらくち) 행락지\n" +
                    "増(ふ)える 늘어나다\n" +
                    "傾向(けいこう) 경향\n" +
                    "バランス 발란스\n" +
                    "分析(ぶんせき) 분석\n" +
                    "下旬(げじゅん) 하순\n" +
                    "首都圏(しゅとけん) 수도권 \n");
            textview.setTextSize(20);
        }
        return super.onOptionsItemSelected(item);
    }
}
