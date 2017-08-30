package com.example.lg.cpa;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;


public class test extends AppCompatActivity implements View.OnClickListener {

    Button prev;
    Button next;
    ViewFlipper flipper;
    Button reslult;
    int i =0;
    String score;
    RadioGroup rb1,rb2,rb3,rb4,rb5;
    int score_integer;

    String[] str;


    RadioButton radionbutton,radionbutton2,radionbutton3,radionbutton4,radionbutton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        str = new String [5];

        str[0] = "1. あたらしい";
        str[1] = "4. さむい";
        str[2] = "3. でんき";
        str[3] = "2. ホテル";
        str[4] = "3. わたしは　デパートで　しごとを　して　います。 ";

        setContentView(R.layout.test);

        rb1 = (RadioGroup)findViewById(R.id.radioGroup1);
        rb2 = (RadioGroup)findViewById(R.id.radioGroup2);
        rb3 = (RadioGroup)findViewById(R.id.radioGroup3);
        rb4 = (RadioGroup)findViewById(R.id.radioGroup4);
        rb5 = (RadioGroup)findViewById(R.id.radioGroup5);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);

        reslult = (Button)findViewById(R.id.result);

        reslult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                radionbutton = (RadioButton)findViewById(rb1.getCheckedRadioButtonId());
                if(str[0].equals(radionbutton.getText()))
                    score_integer +=20;

                radionbutton2 = (RadioButton)findViewById(rb2.getCheckedRadioButtonId());
                if(str[1].equals(radionbutton2.getText()))
                    score_integer +=20;

                radionbutton3 = (RadioButton)findViewById(rb3.getCheckedRadioButtonId());
                if(str[2].equals(radionbutton3.getText()))
                    score_integer +=20;

                radionbutton4 = (RadioButton)findViewById(rb4.getCheckedRadioButtonId());
                if(str[3].equals(radionbutton4.getText()))
                    score_integer +=20;

                radionbutton5 = (RadioButton)findViewById(rb5.getCheckedRadioButtonId());
                if(str[4].equals(radionbutton5.getText()))
                    score_integer +=20;

                score =score_integer+"";
                Intent intent = new Intent(getApplicationContext(),test_result.class);
                intent.putExtra("Score",score);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v == next && i<5){
            flipper.showNext();
            if(i<5)
                i++;
            Log.d("확인",""+i);
        }
        else  if(v == prev && i>0) {
            flipper.showPrevious();
            if(i>0)
                i--;
        }

    }
}

