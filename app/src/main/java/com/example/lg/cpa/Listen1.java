package com.example.lg.cpa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Listen1 extends AppCompatActivity {


    MediaPlayer mediaPlayer;

    private static final boolean AUTO_HIDE = true;


    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    TextView textView;
    boolean isPlaying = false;
    SeekBar sb;
    Button start_,stop_,pause_;
    int pos = 0;

    class MyThread extends Thread {
        @Override
        public void run() { // 쓰레드가 시작되면 콜백되는 메서드
            // 씨크바 막대기 조금씩 움직이기 (노래 끝날 때까지 반복)
            while(isPlaying) {
                sb.setProgress(mediaPlayer.getCurrentPosition());
            }
        }
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen1);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.listen1);
        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);
        start_ = (Button)findViewById(R.id.start);
        stop_ = (Button)findViewById(R.id.stop);
        pause_ = (Button)findViewById(R.id.pause);

        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
        textView = (TextView) findViewById(R.id.fullscreen_content);
        sb = (SeekBar) findViewById(R.id.seekbar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                isPlaying = true;
                int ttt = seekBar.getProgress(); // 사용자가 움직여놓은 위치
                mediaPlayer.seekTo(ttt);
                mediaPlayer.start();
                new MyThread().start();
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                isPlaying = false;
                mediaPlayer.pause();
            }
            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser) {
                if (seekBar.getMax()==progress) {
                    start_.setVisibility(View.VISIBLE);
                    stop_.setVisibility(View.INVISIBLE);
                    pause_.setVisibility(View.INVISIBLE);
                    isPlaying = false;
                    mediaPlayer.stop();
                }
            }
        });

    }

    public void next(View view){
        Intent intent = new Intent(getApplicationContext(),japan_study.class);
        startActivity(intent);
    }

    public void out(View view){
        Intent intent = new Intent(getApplicationContext(),conversation.class);
        mediaPlayer.stop();
        startActivity(intent);
    }
    public void start(View view){
        mediaPlayer.start();
        int a = mediaPlayer.getDuration();
        sb.setMax(a);
        isPlaying = true;
        new MyThread().start();
    }

    public void pause(View view){
        pos = mediaPlayer.getCurrentPosition();
        mediaPlayer.pause();
        isPlaying = false;
    }

    public void stop(View view){
        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        isPlaying = false;
    }


    private String readTxt() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.listen1_text_japan);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"UTF-8");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String readTxt2() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.listen1_text_korea);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"UTF-8");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


    public void box(View v){
        final Context context = this;
        final CharSequence[] items2 = { "일본어", "한국어"};
        final AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(context);
        // 제목셋팅
        alertDialogBuilder2.setTitle("해석");
        alertDialogBuilder2.setSingleChoiceItems(items2, -1,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {// 프로그램을 종료한다

                        if(id ==0) {
                            Toast.makeText(getApplicationContext(),
                                    items2[id] + " 선택했습니다.",
                                    Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            textView.setText(readTxt());
                            textView.setTextColor(Color.WHITE);
                            textView.setTextSize(16);
                        }
                        if(id ==1) {
                            Toast.makeText(getApplicationContext(),
                                    items2[id] + " 선택했습니다.",
                                    Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            textView.setText(readTxt2());
                            textView.setTextSize(16);
                            textView.setTextColor(Color.WHITE);
                        }
                    }
                });
        // 다이얼로그 생성
        AlertDialog alertDialog2 = alertDialogBuilder2.create();
        // 다이얼로그 보여주기
        alertDialog2.show();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }
    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_note) {
            Intent intent = new Intent(getApplicationContext(),MainNote.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
