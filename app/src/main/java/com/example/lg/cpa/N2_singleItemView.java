package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gom on 2016-06-05.
 */
public class N2_singleItemView extends AppCompatActivity {

    String str0;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        str0 = i.getStringExtra("check");

        if(str0.equals("0"))
            setContentView(R.layout.n2_grammer1);

        if(str0.equals("1"))
            setContentView(R.layout.n2_grammer2);

        if(str0.equals("2"))
            setContentView(R.layout.n2_grammer3);

        if(str0.equals("3"))
            setContentView(R.layout.n2_grammer4);

        if(str0.equals("4"))
            setContentView(R.layout.n2_grammer5);



    }

}