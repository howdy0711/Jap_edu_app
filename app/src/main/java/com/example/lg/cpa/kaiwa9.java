package com.example.lg.cpa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;
import android.widget.MediaController;
import java.io.InputStream;
import java.io.OutputStream;

public class kaiwa9 extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaiwa);
        VideoView videoView = (VideoView)this.findViewById(R.id.videoView);
        videoView.requestFocus();
        videoView.setMediaController(new MediaController(this));
        try{
/*  case1  */
//videoView.setVideoPath("/sdcard/be_my_baby5.mp4");
/*  case2  */
//videoView.setVideoURI(
//      Uri.parse("http://192.168.200.105:8080/web/be_my_baby5.mp4"));
/* case 3 */
//Raw 자원의 파일 저장(2)
            raw2file(this,R.raw.video2,"video2.mp4");
//동영ㅇ상의 재생 (3)
            String path = getFilesDir().getAbsolutePath()+"/video2.mp4";
            videoView.setVideoPath(path);
            videoView.start();
        }catch(Exception e){
            android.util.Log.e("", e.toString());
        }
    }
    // Raw 자원의 파일 보존
    private void raw2file(Context context,
                          int resID,String fileName) throws Exception {
        InputStream in=context.getResources().openRawResource(resID);
        in2file(context,in,fileName);
    }
    // 입력 스트림의 파일 보존
    private void in2file(Context context,
                         InputStream in,String fileName)
            throws Exception {
        int size;
        byte[] w=new byte[1024];
        OutputStream out=null;
        try {
            out=context.openFileOutput(fileName,Context.MODE_WORLD_READABLE);
            while (true) {
                size=in.read(w);
                if (size<=0) break;
                out.write(w,0,size);
            };
            out.close();
            in.close();
        } catch (Exception e) {
            try {
                if (in !=null) in.close();
                if (out!=null) out.close();
            } catch (Exception e2) {
            }
            throw e;
        }
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