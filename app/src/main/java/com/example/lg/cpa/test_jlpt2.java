package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

public class test_jlpt2 extends AppCompatActivity implements View.OnClickListener {

    Button prev;
    Button next;
    ViewFlipper flipper;
    Button reslult;
    int i =0;
    String score;
    RadioGroup rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10;
    int score_integer;

    String[] str;


    RadioButton radionbutton,radionbutton2,radionbutton3,radionbutton4,radionbutton5,radionbutton6,radionbutton7,radionbutton8,radionbutton9,radionbutton10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        str = new String [10];

        str[0] = "3. たね";
        str[1] = "1. まずしい";
        str[2] = "1. 収集";
        str[3] = "4. 優れて";
        str[4] = "4. まわって";
        str[5] = "1. 名";
        str[6] = "2. 寿命";
        str[7] = "3. ただの";
        str[8] = "4. あかるい";
        str[9] = "4. ところに";

        setContentView(R.layout.test_jlpt2);

        rb1 = (RadioGroup)findViewById(R.id.radioGroup1);
        rb2 = (RadioGroup)findViewById(R.id.radioGroup2);
        rb3 = (RadioGroup)findViewById(R.id.radioGroup3);
        rb4 = (RadioGroup)findViewById(R.id.radioGroup4);
        rb5 = (RadioGroup)findViewById(R.id.radioGroup5);
        rb6 = (RadioGroup)findViewById(R.id.radioGroup6);
        rb7 = (RadioGroup)findViewById(R.id.radioGroup7);
        rb8 = (RadioGroup)findViewById(R.id.radioGroup8);
        rb9 = (RadioGroup)findViewById(R.id.radioGroup9);
        rb10 = (RadioGroup)findViewById(R.id.radioGroup10);

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
                    score_integer +=10;

                radionbutton2 = (RadioButton)findViewById(rb2.getCheckedRadioButtonId());
                if(str[1].equals(radionbutton2.getText()))
                    score_integer +=10;

                radionbutton3 = (RadioButton)findViewById(rb3.getCheckedRadioButtonId());
                if(str[2].equals(radionbutton3.getText()))
                    score_integer +=10;

                radionbutton4 = (RadioButton)findViewById(rb4.getCheckedRadioButtonId());
                if(str[3].equals(radionbutton4.getText()))
                    score_integer +=10;

                radionbutton5 = (RadioButton)findViewById(rb5.getCheckedRadioButtonId());
                if(str[4].equals(radionbutton5.getText()))
                    score_integer +=10;

                radionbutton6 = (RadioButton)findViewById(rb6.getCheckedRadioButtonId());
                if(str[5].equals(radionbutton6.getText()))
                    score_integer +=10;

                radionbutton7 = (RadioButton)findViewById(rb7.getCheckedRadioButtonId());
                if(str[6].equals(radionbutton7.getText()))
                    score_integer +=10;

                radionbutton8 = (RadioButton)findViewById(rb8.getCheckedRadioButtonId());
                if(str[7].equals(radionbutton8.getText()))
                    score_integer +=10;

                radionbutton9 = (RadioButton)findViewById(rb9.getCheckedRadioButtonId());
                if(str[8].equals(radionbutton9.getText()))
                    score_integer +=10;

                radionbutton10 = (RadioButton)findViewById(rb10.getCheckedRadioButtonId());
                if(str[9].equals(radionbutton10.getText()))
                    score_integer +=10;

                score =score_integer+"";
                Intent intent = new Intent(getApplicationContext(),test_jlpt2_result.class);
                intent.putExtra("Score",score);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v == next && i<10){
            flipper.showNext();
            if(i<10)
                i++;
            Log.d("확인", "" + i);
        }
        else  if(v == prev && i>0) {
            flipper.showPrevious();
            if(i>0)
                i--;
        }

    }
}