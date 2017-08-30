package com.example.lg.cpa;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by gom on 2016-06-03.
 */
public class Dictionary extends Activity{
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    SQLiteDatabase db;
    WordDBHelper helper;
    ArrayList<Word> wordlist = new ArrayList<Word>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        helper=  new WordDBHelper(this,"WORDS_JP.db",null,1);

/*
        delete("がくせい");
        delete("せんせい");
        delete("じゅぎょう");
        delete("はやい");
        delete("たべる");

*/

        ///명사//////////////////////////
        insert("명사","せんしばんこう","千思万考","20160602","천사만고","5");
        insert("명사","あげく"," ","20160602","~ 한 끝에","5");
        insert("명사","すったもんだ","擦ったもんだ","20160602","옥신각신","5");
        insert("명사","かんげき","感激","20160602","감격","5");
        insert("명사","あまり" ,"　","20160602","너무 ~한 나머지,별로","5");
        insert("명사","じつりょく","実力","20160602","실력","5");
        insert("명사","いじょう","以上","20160602","이상","5");
        insert("명사","ろくじゅう","六十","20160602","60","5");
        insert("명사","とし","歳","20160602","~세(나이,연령)","5");
        insert("명사","しごと","仕事","20160602","일,직업,업무","5");
        insert("명사","しゃかい","社会","20160602","사회","5");
        insert("명사","はってん","発展","20160602","발전","5");
        insert("명사","せいかつ","生活","20160602","생활","5");
        insert("명사","かんきょうもんだい","環境問題","20160602","환경문제","5");
        insert("명사","ところ","所","20160602","곳, 장소","5");
        insert("명사","とうし","投資","20160602","투자","5");
        insert("명사","もだ","無駄","20160602","낭비","5");
        insert("명사","みんな","　","20160602","모두, 함께","5");

        insert("명사","りょうしん","両親","20160602","부모님","4");
        insert("명사","りょこう","旅行","20160602","여행","4");
        insert("명사","ぼく","僕","20160602","나,저","4");
        insert("명사","まいにち","毎日","20160602","매일","4");
        insert("명사","しょくじ","食事","20160602","식사","4");
        insert("명사","あかちゃん","赤ちゃん","20160602","아기","4");
        insert("명사","かげつ","か月","20160602","~개월","4");
        insert("명사","かれ","彼","20160602","그","4");
        insert("명사","うんてん","運転","20160602","운전","4");
        insert("명사","じかん","時間","20160602","시간","4");
        insert("명사","とおり","通り","20160602","길,거리","4");
        insert("명사","じかんどおり","時間通り","20160602","제 시간","4");
        insert("명사","かのじょ","彼女","20160602","그녀, 여자친구","4");
        insert("명사","もの","物","20160602","것,물건","4");
        insert("명사","ひと","人","20160602","사람","4");
        insert("명사","しんらい","信頼","20160602","신뢰","4");
        insert("명사","うそ","嘘","20160602","거짓말","4");
        insert("명사","ぜったい","接待","20160602","절대","4");
        insert("명사","けっこんしき","結婚式","20160602","결혼식","4");
        insert("명사","まち","町","20160602","마을,거리","4");
        insert("명사","あかり","明り","20160602","불빛,밝은 빛","4");
        insert("명사","がくせい","学生","20160602","학생","4");
        insert("명사","じだい","時代","20160602","시대","4");
        insert("명사","ふたり","二人","20160602","두사람","4");
        insert("명사","おたがい","お互い","20160602","서로","4");
        insert("명사","ずつ","　","20160602","~씩","4");

        insert("명사","あなた","　","20160602","당신","6");
        insert("명사","かんとく","監督","20160602","감독","6");
        insert("명사","こと","事","20160602","일,것","6");
        insert("명사","しあい","話合い","20160602","의논,교섭,상담","6");
        insert("명사","けっか","結果","20160602","결과","6");
        insert("명사","けんさ","検査","20160602","검사","6");
        insert("명사","しゅっせきけっせき","出席欠席","20160602","출결여부","6");
        insert("명사","てんこう","天候","20160602","천후,기후,날씨","6");
        insert("명사","だれ","　","20160602","누구","6");
        insert("명사","なに","何","20160602","무엇","6");
        insert("명사","そこ","　","20160602","거기, 그곳","6");
        insert("명사","しゅうい","周囲","20160602","주의","6");
        insert("명사","はんたい","反対","20160602","반대","6");

        insert("명사","ぶったい","物体","20160602","물체","6");
        insert("명사","りったい","立体","20160602","입체","6");
        insert("명사","しょうたい","招待","20160602","초대","6");
        insert("명사","いと","意図","20160602","의도","6");
        insert("명사","かいけん","会見","20160602","회견","6");
        insert("명사","ちゃくしゅ","着手","20160602","착수","6");
        insert("명사","くうかん","空間","20160602","공간","6");
        insert("명사","せいさん","生産","20160602","생산","6");
        insert("명사","とくしょく","特色","20160602","특색","6");
        insert("명사","ふりょう","不良","20160602","불량","6");
        insert("명사","たちば","立場","20160602","입장","6");
        insert("명사","しょうだく","承諾","20160602","승낙","6");
        insert("명사","にんしょう","認証","20160602","인증","6");
        insert("명사","ぶんせき","分析","20160602","분석","6");
        insert("명사","かんらん","観覧","20160602","관람","6");
        insert("명사","えつらん","閲覧","20160602","관람","6");
        insert("명사","こうしょう","交渉","20160602","교섭","6");
        insert("명사","かんしょう","干渉","20160602","간섭","6");
        insert("명사","しきゅう","至急","20160602","시급","6");
        insert("명사","おうきゅう","応急","20160602","응급","6");
        insert("명사","してん","視点","20160602","시점","6");
        insert("명사","てんらく","転落","20160602","잔략","6");
        insert("명사","こうりゅう","交流","20160602","교류","6");
        insert("명사","あく","悪","20160602","악","6");
        insert("명사","あつりょく","圧力","20160602","압력","6");
        insert("명사","あっぱく","　","20160602","압박","6");
        insert("명사","あこがれ","憧れ","20160602","동경","6");
        insert("명사","あんせい","安静","20160602","안정","6");
        insert("명사","あんさん","暗算","20160602","암산","6");
        insert("명사","あんじ","暗示","20160602","암시","6");
        insert("명사","おおはば","大水","20160602","홍수","6");
        insert("명사","おばえ","覚え","20160602","기억","6");




        ///동사 ///////////////////////////////////////
        insert("동사","なく","泣く","20160602","울다","5");
        insert("동사","する","　","20160602","하다","5");
        insert("동사","きまる","決まる","20160602","정해지다,결정되다","5");
        insert("동사","かいかぶる","買い被る","20160602","높이 평가하다","5");
        insert("동사","のぞく","除く","20160602","제외하다","5");
        insert("동사","はげむ","励む","20160602","힘쓰다,열중하다","5");
        insert("동사","あそぶ","遊ぶ","20160602","놀다","5");
        insert("동사","せいをだす","精を出す","20160602","열심히 일하다","5");
        insert("동사","できる","","20160602","할 수 있다","5");
        insert("동사","しょうずる","生ずる","20160602","발생하다","5");
        insert("동사","なくす","無くす","20160602","없애다,잃다","5");
        insert("동사","いる","居る","20160602","있다","5");
        insert("동사","とる","取る","20160602","잡다","5");
        insert("동사","あう","合う","20160602","만나다","5");
        insert("동사","がんばる","頑張る","20160602","버티다,힘내다,참고 계속 노력하다","5");
        insert("동사","つくる","作る","20160602","만들다","4");
        insert("동사","みる","見る","20160602","보다","5");
        insert("동사","なる","為る","20160602","~(이)가 되다","5");
        insert("동사","いう","言う","20160602","말하다","5");
        insert("동사","きく","聞く","20160602","듣다","5");
        insert("동사","いそぐ","急ぐ","20160602","서두르다","5");
        insert("동사","つく","着く","20160602","도착하다","5");
        insert("동사","わかる","分かる","20160602","알다","5");
        insert("동사","える","得る","20160602","얻다,획득하다","5");
        insert("동사","いく","行く","20160602","가다","5");
        insert("동사","きえる","消える","20160602","꺼지다,사라지다","5");
        insert("동사","あう","会う","20160602","합쳐지다,만나다","5");

        insert("동사","あおぐ","仰ぐ","20160602","치켜들다","6");
        insert("동사","あゆむ","歩む","20160602","전진하다","6");
        insert("동사","いきごむ","意気込む","20160602","분발하다","6");
        insert("동사","うずめる","","20160602","매장하다","6");
        insert("동사","うながす","促す","20160602","재촉하다","6");
        insert("동사","おしむ","惜しむ","20160602","아끼다","6");
        insert("동사","きずく","築く","20160602","쌇다","6");
        insert("동사","きたえる","鍛える","20160602","불리다","6");


        ///이형용사 //////////////////////////////
        insert("이형용사","うれしい","嬉しい","20160602","기쁘다","5");
        insert("이형용사","おおきい","大きい","20160602","크다","4");
        insert("이형용사","ない","無い","20160602","없다","4");
        insert("이형용사","いい","良い","20160602","좋다","4");
        insert("이형용사","したしい","親しい","20160602","친하다","4");

        insert("이형용사","こころよい","快い","20160602","상쾌하다","6");
        insert("이형용사","でかい","　","20160602","크다","6");
        insert("이형용사","なやましい","悩ましい","20160602","괴롭다","6");
        insert("이형용사","ふさわしい","相応しい","20160602","어울리다","6");
        insert("이형용사","ひらたい","ひらたい","20160602","평평하다","6");
        insert("이형용사","むなしい","　","20160602","허무하다","6");



        ///나형용사 /////////////////////////////
        insert("나형용사","ゆうめいだ","有名だ","20160602","유명하다","5");
        insert("나형용사","ゆたかだ","豊かだ","20160602","풍족하다","5");
        insert("나형용사","べんりだ","便利だ","20160602","편리하다","5");
        insert("나형용사","ひつようだ","必要だ","20160602","필요하다","5");
        insert("나형용사","じゅうぶんだ","十分だ","20160602","충분하다","5");
        insert("나형용사","てっていてきだ","徹底的だ","20160602","철저하다","5");
        insert("나형용사","きれいだ","綺麗だ","20160602","예쁘다,깨끗하다","4");



        ///부사///////////////////////////
        insert("부사","あえて","敢えて","20160602","감히,굳이","4");
        insert("부사","すこし","少し","20160602","조금,약간,좀","4");

        insert("부사","あらかじめ","予め","20160602","미리","6");
        insert("부사","いたって","至って","20160602","극히,매우","6");
        insert("부사","いかにも","　","20160602","어떻게든","6");
        insert("부사","がんらい","元来","20160602","원래","6");
        insert("부사","たいそう","体操","20160602","매우,몹시","6");
        insert("부사","ときおり","時折","20160602","떄때로","6");
        insert("부사","なるたけ","　","20160602","되도록","6");

/*
        insert("명사","せんせい","先生","20160602","선생님","1");
        insert("명사","じゅぎょう","授業","20160602","수업","1");
        insert("이형용사","はやい","早い","20160602","이르다","1");
        insert("동사","たべる","食べる","20160602","먹다","1");
*/
        select();

        // Generate sample data
        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);
        adapter = new ListViewAdapter(this, wordlist);
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }
    public void insert(String classes, String word, String kanzi, String times,
                       String mean, String level) {
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from WORDS_JP where word='"+word+"' ",null);

        if(cursor.getCount() == 0) {
            ContentValues values = new ContentValues();
            values.put("classes", classes);
            values.put("word", word);
            values.put("kanzi", kanzi);
            values.put("times", times);
            values.put("mean", mean);
            values.put("level", level);
            db.insert("WORDS_JP", null, values);
        }
    }


    public void select(){
        db = helper.getWritableDatabase();
        Cursor c = db.query("WORDS_JP",null,null,null,null,null,null,null);

        while(c.moveToNext()){
            int word_num = c.getInt(c.getColumnIndex("word_num"));
            String classes = c.getString(c.getColumnIndex("classes"));
            String word = c.getString(c.getColumnIndex("word"));
            String kanzi = c.getString(c.getColumnIndex("kanzi"));
            String times = c.getString(c.getColumnIndex("times"));
            String mean = c.getString(c.getColumnIndex("mean"));
            String level = c.getString(c.getColumnIndex("level"));
            Word wd = new Word(word_num,classes,word,kanzi,times,mean,level);
            wordlist.add(wd);
            Log.i("db",classes+"\n"
                    +word+ "\n" +kanzi+"\n"+times+"\n"+mean);
        }
    }
    public void delete (String word){
        db  = helper.getWritableDatabase();
        db.delete("WORDS_JP","word=?",new String[]{word});
        Log.i("db",word+ "정상적으로 삭제 되었습니다.");
    }
}
