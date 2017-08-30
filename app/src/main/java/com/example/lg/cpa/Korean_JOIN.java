package com.example.lg.cpa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.Calendar;

public class Korean_JOIN extends AppCompatActivity {

    EditText idb,pass,passCheck;
    Button join;
    String id,pa,gen="", age,coun="";
    SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean__join);

        idb = (EditText)findViewById(R.id.ID);
        pass =(EditText)findViewById(R.id.password);
        passCheck =(EditText)findViewById(R.id.passCheck);
        join = (Button)findViewById(R.id.Join);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = idb.getText().toString();
                if((pass.getText().toString()).compareTo(passCheck.getText().toString())==0) {
                    pa = pass.getText().toString();
                    WebView webView = (WebView) findViewById(R.id.web);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl("http://172.20.1.211:8080/Android/android/localusers.jsp?id=" + id + "&pass=" + pa + "&gen=" + gen + "&coun=" + coun + "&age=" + age);
                    sharedPreferenceUtil.setSharedPass(pa);
                    NextIntent();
                }else{
                    Toast.makeText(getApplicationContext(),"비밀번호를 다시 확인해 주세요.", Toast.LENGTH_SHORT).show();
                    pass.setText("");
                    passCheck.setText("");
                }
            }
        });

        Spinner spinner1 = (Spinner) findViewById(R.id.age);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.나이, android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                age = parent.getItemAtPosition(position).toString();
            }



        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            age = "";
        }
    });
    }
    public void RadioSex(View view){
        boolean check = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.man:
                if(check)
                    gen = "남자";
                break;
            case R.id.girl:
                if(check)
                    gen = "여자";
                break;
        }
    }
    public void RadioCountry(View view) {
        boolean check = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.korea:
                if (check)
                    coun = "한국";
                break;
            case R.id.japan:
                if (check)
                    coun = "일본";
                break;
        }
    }
    public void NextIntent(){
        Toast.makeText(getApplicationContext(),"회원가입 되셨습니다!",Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(getApplicationContext(), login.class);
        startActivity(intent2);
    }
 }
