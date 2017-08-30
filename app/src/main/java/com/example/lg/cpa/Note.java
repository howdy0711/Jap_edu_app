package com.example.lg.cpa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Note extends Activity implements View.OnClickListener {
    DBHandler handler;

    int edit_id = 0, edit_position = 0;
    boolean isCalled = false, isadded = false;
    Button resetBtn, submitBtn, listBtn;
    EditText memo;
    MemoInfo memoinfo;
    Intent result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo);

        handler = new DBHandler( this );

        resetBtn = (Button)findViewById( R.id.resetBtn );
        resetBtn.setOnClickListener( this );
        submitBtn = (Button)findViewById( R.id.submitBtn );
        submitBtn.setOnClickListener( this );
        listBtn = (Button)findViewById( R.id.listBtn );
        listBtn.setOnClickListener( this );
        memo = (EditText)findViewById( R.id.memo );

        Intent intent = getIntent();
        edit_id = intent.getIntExtra( "id", 0 );
        edit_position = intent.getIntExtra("position",  -1 );
        isCalled = intent.getBooleanExtra("isCalled", false );

        if( edit_id > 0 && edit_position >= 0 ) {
            memoinfo = handler.select( edit_id );
            memo.setText( memoinfo.memo );
        }

      //  result = new Intent();
    }
    String string;

    @Override

    public void onClick(View v ) {
        // TODO Auto-generated method stub
        if( v == resetBtn ) {
            resetMemo();
        }
        else if( v == submitBtn ) {

            if( !inputCheck() ) {
                Toast.makeText(this,  "내용을 입력하세요", Toast.LENGTH_SHORT).show();
                return;
            }


            if( edit_id > 0 &&  memo.getText().toString() != memoinfo.memo ) {
                if( handler.update( edit_id,  memo.getText().toString() ) == 0 )
                    Toast.makeText( this, "수정 할 수 없습니다.",  Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText( this, "수정 되었습니다.",  Toast.LENGTH_SHORT).show();
                    result.putExtra( "edit_id", edit_id );
                    result.putExtra( "edit_position", edit_position );
                    result.putExtra( "isadded", isadded );
                    setResult( RESULT_OK, result );
                    finish();
                }
            }
            else {

                if( handler.insert( memo.getText().toString() ) == 0 )
                    Toast.makeText( this, "등록할수 없습니다.",  Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText( this, "등록 되었습니다.",  Toast.LENGTH_SHORT).show();
                    string = memo.getText().toString();
                    resetMemo();
                    isadded = true;
                }
            }
        }
        else if( v == listBtn ) {
            if( !isCalled ) {
                Intent intent = new Intent( this, ListActivity.class );
                startActivity( intent );
                finish();
            }
            else {
                result.putExtra( "edit_id", 0 );
                result.putExtra( "edit_position", -1 );
                result.putExtra( "isadded", isadded );
                setResult( RESULT_OK, result );
                finish();
            }
        }
    }

    protected boolean inputCheck() {
        if( memo.getText().toString().length() == 0 ) return false;
        else return true;
    }

    private void resetMemo() {
        edit_id = 0;
        memo.setText( "" );
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        if( isCalled ) {
            result.putExtra( "edit_id", 0 );
            result.putExtra( "edit_position", -1 );
            result.putExtra( "isadded", isadded );
            setResult( RESULT_OK, result );
        }
        finish();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        handler.close();
    }
}