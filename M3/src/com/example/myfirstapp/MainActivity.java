package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	Button login;
	Bundle a;
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.onCreate(a);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		a = savedInstanceState;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		login = (Button) findViewById(R.id.bLogin);
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				sendMessage(arg0);
			}
		});
		//viewPager
		//Log.d(TAG,"activity creating");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_userID);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

}
