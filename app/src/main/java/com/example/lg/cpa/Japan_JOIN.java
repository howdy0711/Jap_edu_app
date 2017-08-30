package com.example.lg.cpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Japan_JOIN extends AppCompatActivity {

    EditText idb,pass,passCheck;
    Button join;
    String id,pa,gen="", age,coun="";
    SharedPreferenceUtil sharedPreferenceUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan__join);
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
                    webView.loadUrl("http://172.60.1.131:8080/Android/android/localusers.jsp?id=" + id + "&pass=" + pa + "&gen=" + gen + "&coun=" + coun + "&age=" + age);
                    sharedPreferenceUtil.setSharedPass(pa);
                    NextIntent();
                }else{
                    Toast.makeText(getApplicationContext(),"パスワードをもう一度確認してください。", Toast.LENGTH_SHORT).show();
                    pass.setText("");
                    passCheck.setText("");
                }
            }
        });

        Spinner spinner1 = (Spinner) findViewById(R.id.age);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.나이2, android.R.layout.simple_spinner_dropdown_item);
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
                    gen = "男子";
                break;
            case R.id.girl:
                if(check)
                    gen = "女子";
                break;
        }
    }
    public void RadioCountry(View view) {
        boolean check = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.korea:
                if (check)
                    coun = "韓國";
                break;
            case R.id.japan:
                if (check)
                    coun = "日本";
                break;
        }
    }
    public void NextIntent(){
        Toast.makeText(getApplicationContext(),"会員登録なられました！",Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(getApplicationContext(), login.class);
        startActivity(intent2);
    }
}
