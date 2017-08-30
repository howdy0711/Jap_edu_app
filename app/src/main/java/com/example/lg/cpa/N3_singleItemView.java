package com.example.lg.cpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gom on 2016-06-05.
 */
public class N3_singleItemView extends AppCompatActivity {

    String str0;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        str0 = i.getStringExtra("check");

        if(str0.equals("0"))
            setContentView(R.layout.n3_change1);

        if(str0.equals("1"))
            setContentView(R.layout.n3_change2);

        if(str0.equals("2"))
            setContentView(R.layout.n3_change3);

        if(str0.equals("3"))
            setContentView(R.layout.n3_change4);

        if(str0.equals("4"))
            setContentView(R.layout.n3_change5);

        if(str0.equals("5"))
            setContentView(R.layout.n3_change6);

        if(str0.equals("6"))
            setContentView(R.layout.n3_change7);

        if(str0.equals("7"))
            setContentView(R.layout.n3_change8);

        if(str0.equals("8"))
            setContentView(R.layout.n3_change9);

        if(str0.equals("9"))
            setContentView(R.layout.n3_change10);

        if(str0.equals("10"))
            setContentView(R.layout.n3_change11);


    }

}