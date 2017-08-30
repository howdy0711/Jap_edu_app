package com.example.lg.cpa;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class japan_login extends AppCompatActivity {
    private static final String TAG = "OAuthSampleActivity";
    private OAuthLogin mOAuthLoginModule;
    private TextView txt;

    String str;

    private String OAUTH_CLIENT_ID = "BzutzdgU1J2hbDUWjKyo";
    private String OAUTH_CLIENT_SECRET = "Esif77vheM";
    private String OAUTH_CLIENT_NAME = "NY데이터파티";

    private Context context;

    private TextView mApiResultText;
    private static TextView mOauthAT;
    private static TextView mOauthRT;
    private static TextView mOauthExpires;
    private static TextView mOauthTokenType;
    private static TextView mOAuthState;
    int countryCheck = 0;

    EditText e1,e2;
    Button b1;
    String id;
    HttpPost httpPost;
    HttpResponse response;
    HttpClient httpClient;
    List<NameValuePair> nameValuePairList;
    ProgressDialog dialog = null;
    SharedPreferenceUtil sharedPreferenceUtil;

    DBHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_japan_login);

        handler = new DBHandler( this );
        e1 = (EditText)findViewById(R.id.ID_jp);
        e2 = (EditText)findViewById(R.id.password_jp);
        b1= (Button) findViewById(R.id.email_sign_in_button_jp);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = ProgressDialog.show(japan_login.this, "", "ログイン中...", true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        login();
                    }
                }).start();
            }
        });

        context = this;

        initData();
        initView();

        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(
                japan_login.this
                , OAUTH_CLIENT_ID
                , OAUTH_CLIENT_SECRET
                , OAUTH_CLIENT_NAME
        );

        OAuthLoginButton mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg_jp);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

        updateView();

    }

    private void initData() {
        mOAuthLoginModule = OAuthLogin.getInstance();

        mOAuthLoginModule.init(context, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);
         /*
          * 2015년 8월 이전에 등록하고 앱 정보 갱신을 안한 경우 기존에 설정해준 callback intent url 을 넣어줘야 로그인하는데 문제가 안생긴다.
          * 2015년 8월 이후에 등록했거나 그 뒤에 앱 정보 갱신을 하면서 package name 을 넣어준 경우 callback intent url 을 생략해도 된다.
          */
        //mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_callback_intent_url);
    }

    private void initView() {
        mApiResultText = (TextView) findViewById(R.id.api_result_text_jp);
        mOauthAT = (TextView) findViewById(R.id.oauth_access_token_jp);
        mOauthRT = (TextView) findViewById(R.id.oauth_refresh_token_jp);
        mOauthExpires = (TextView) findViewById(R.id.oauth_expires_jp);
        mOauthTokenType = (TextView) findViewById(R.id.oauth_type_jp);
        mOAuthState = (TextView) findViewById(R.id.oauth_state_jp);

        updateView();
    }

    private void updateView() {
        mOauthAT.setText(mOAuthLoginModule.getAccessToken(context));
        mOauthRT.setText(mOAuthLoginModule.getRefreshToken(context));
        mOauthExpires.setText(String.valueOf(mOAuthLoginModule.getExpiresAt(context)));
        mOauthTokenType.setText(mOAuthLoginModule.getTokenType(context));
        mOAuthState.setText(mOAuthLoginModule.getState(context).toString());
    }
    @Override
    protected void onResume() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onResume();
    }
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginModule.getAccessToken(context);
                String refreshToken = mOAuthLoginModule.getRefreshToken(context);
                long expiresAt = mOAuthLoginModule.getExpiresAt(context);
                String tokenType = mOAuthLoginModule.getTokenType(context);
                mOauthAT.setText(accessToken);
                mOauthRT.setText(refreshToken);
                mOauthExpires.setText(String.valueOf(expiresAt));
                mOauthTokenType.setText(tokenType);
                mOAuthState.setText(mOAuthLoginModule.getState(context).toString());
                Intent intent = new Intent(getApplicationContext(), jp.class);
                startActivity(intent);
            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(context).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(context);
                Toast.makeText(context, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }

        ;
    };


    public void onButtonClick(View v) throws Throwable {

        switch (v.getId()) {

            case R.id.buttonVerifier: {
                new RequestApiTask().execute();
                break;
            }
            case R.id.buttonOAuthLogout: {
                mOAuthLoginModule.logout(context);
                updateView();
                break;
            }
            default:
                break;
        }
    }

    private class DeleteTokenTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            boolean isSuccessDeleteToken = mOAuthLoginModule.logoutAndDeleteToken(context);

            if (!isSuccessDeleteToken) {
                // 서버에서 token 삭제에 실패했어도 클라이언트에 있는 token 은 삭제되어 로그아웃된 상태이다
                // 실패했어도 클라이언트 상에 token 정보가 없기 때문에 추가적으로 해줄 수 있는 것은 없음
                Log.d(TAG, "errorCode:" + mOAuthLoginModule.getLastErrorCode(context));
                Log.d(TAG, "errorDesc:" + mOAuthLoginModule.getLastErrorDesc(context));
            }
            return null;
        }

        protected void onPostExecute(Void v) {
            updateView();
        }
    }

    private class RequestApiTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            mApiResultText.setText((String) "");
        }

        @Override
        protected String doInBackground(Void... params) {
            String url = "https://openapi.naver.com/v1/nid/getUserProfile.xml";
            String at = mOAuthLoginModule.getAccessToken(context);
            return mOAuthLoginModule.requestApi(context, at, url);
        }

        protected void onPostExecute(String content) {
            mApiResultText.setText((String) content);
        }
    }

    private class RefreshTokenTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            return mOAuthLoginModule.refreshAccessToken(context);
        }
        protected void onPostExecute(String res) {
            updateView();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            return true;
        }
        if (id == R.id.end){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
    public void login() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        sharedPreferenceUtil.setSharedId(e1.getText().toString());

        try {
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://172.20.1.211:8080/Android/android/logincheck2.jsp");
            nameValuePairList = new ArrayList<NameValuePair>(2);
            nameValuePairList.add(new BasicNameValuePair("username", e1.getText().toString().trim()));
            nameValuePairList.add(new BasicNameValuePair("password", e2.getText().toString().trim()));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
            response = httpClient.execute(httpPost);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpClient.execute(httpPost, responseHandler);

            if(response.contains("User Found")){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        id = e1.getText().toString();
                        Toast.makeText(japan_login.this, "はじめまして " + id + "さん", Toast.LENGTH_SHORT).show();
                        sharedPreferenceUtil.setSharedId(id);
                        Log.d(sharedPreferenceUtil.getSharedId(), sharedPreferenceUtil.getSharedId());
                        Intent intent = new Intent(getApplicationContext(), Study_hangle.class);
                        startActivity(intent);
                    }
                });
            }else{
                showAlert();
            }
        }catch (Exception e){
            dialog.dismiss();
        }
    }
    public void showAlert(){
        japan_login.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.cancel();
                AlertDialog.Builder builder = new AlertDialog.Builder(japan_login.this);
                builder.setTitle("Login Error");
                builder.setMessage("ユーザーが見つかりません。");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}