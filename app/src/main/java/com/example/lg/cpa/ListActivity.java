package com.example.lg.cpa;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class ListActivity extends Activity implements OnItemClickListener, OnClickListener {
	DBHandler handler;
	ArrayList<MemoInfo> memoList;
	ListView view;
	ListAdapter listAdapter;
	private static final int EDIT_ACTIVITY = 1;
	Button newMemoBtn;

	HttpPost httpPost;
	HttpResponse response;
	HttpClient httpClient;
	List<NameValuePair> nameValuePairList;
	SharedPreferenceUtil sharedPreferenceUtil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		newMemoBtn = (Button)findViewById( R.id.newMemoBtn );
		newMemoBtn.setOnClickListener( this );
		handler = new DBHandler( this );
		memoList = new ArrayList<MemoInfo>();
		sharedPreferenceUtil = new SharedPreferenceUtil(this);
		
		listAdapter = new ListAdapter( this, memoList );
		view = (ListView)findViewById( R.id.list);
		view.setAdapter( listAdapter );
		view.setOnItemClickListener( this );
		registerForContextMenu( view );
		
		displayMemoList();
	}

	protected void displayMemoList() {
		Cursor cursor = handler.selectAll();
		if( cursor == null ) return;
		removeAllList();
		do {
			MemoInfo memo = new MemoInfo();
			memo.id = cursor.getInt( 0 );
			memo.writeDate = cursor.getLong( 1 );
			memo.memo = cursor.getString( 2 );
			memoList.add( memo );
		} while( cursor.moveToNext() );
		cursor.close();
		listAdapter.notifyDataSetChanged();
	}
	protected void removeAllList() {
		memoList.removeAll(memoList);
	}
	protected void removeList( int position ) {
		MemoInfo memo = memoList.get( position );
		handler.delete( memo.id );
		memoList.remove(position);

		new Thread(new Runnable() {
			@Override
			public void run() {
				DeleteFromMysql();
			}
		}).start();

		listAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		getMenuInflater().inflate(R.menu.pop, menu);
		menu.setHeaderTitle(R.string.context_menu_title);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
		
		if( info != null ) {
			int position = info.position;
			if( item.getItemId() == R.id.view_content ) {

				Intent intent = new Intent( this, MainNote.class );
				intent.putExtra("id", memoList.get( position ).id );
				intent.putExtra("position",  position );
				intent.putExtra( "isCalled", true );
				startActivityForResult( intent, EDIT_ACTIVITY );
			}
			else if( item.getItemId() == R.id.remove_content ) removeList( position );
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

		Intent intent = new Intent( this, MainNote.class );
		intent.putExtra("id", memoList.get( arg2 ).id );
		intent.putExtra("position",  arg2 );
		intent.putExtra( "isCalled", true );
		startActivityForResult( intent, EDIT_ACTIVITY );		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		handler.close();
		super.onDestroy();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		int edit_id, edit_position;
		boolean added;
		super.onActivityResult(requestCode, resultCode, data);

		if( requestCode == EDIT_ACTIVITY ) {
			edit_id = data.getIntExtra( "edit_id", 0 );
			edit_position = data.getIntExtra( "edit_position", -1 );
			added = data.getBooleanExtra("isadded",  false);
			if( edit_id != 0 && edit_position >= 0 ) {
				MemoInfo edit_memo = handler.select( edit_id );
				memoList.set( edit_position,  edit_memo );
				listAdapter.notifyDataSetChanged();
			}
			else if( added ) {
				displayMemoList();
			}
		}
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent( this, MainNote.class );
		intent.putExtra("id", 0);
		intent.putExtra("position",  -1 );
		intent.putExtra( "isCalled", true );
		startActivityForResult(intent, EDIT_ACTIVITY);
	}
	public void DeleteFromMysql(){
		String note = sharedPreferenceUtil.getSharedNote();

		Log.d("shared note", note);
		try {
			httpClient = new DefaultHttpClient();
			httpPost = new HttpPost("http://172.20.1.211:8080/Android/android/deletenote.jsp");
			nameValuePairList = new ArrayList<NameValuePair>(1);
			nameValuePairList.add(new BasicNameValuePair("denote",note));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
			response = httpClient.execute(httpPost);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			final String response = httpClient.execute(httpPost, responseHandler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
