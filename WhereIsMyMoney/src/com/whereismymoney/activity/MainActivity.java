package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.PasswordManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the login page.
 */

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	private PasswordManager passwordManager;
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
		passwordManager = new PasswordManager();
		login = (Button) findViewById(R.id.bLogin);
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			    EditText userId = (EditText) findViewById(R.id.edit_userID);
			    EditText password = (EditText) findViewById(R.id.edit_password);
			    if (passwordManager.login(userId.getText().toString(), password.getText().toString())) {
			        sendMessage(arg0); // TODO: make proper intent here
			    }
			    else {
			        // ToCheck: I just hacked MainActivity.this as the context, is it appropriate?
			        AlertDialog loginFailAlert = new AlertDialog.Builder(MainActivity.this).create();
			        loginFailAlert.setTitle("Login Failed");
			        loginFailAlert.setMessage("Incorrect User Name or Password");
			        loginFailAlert.show();
			    }
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
//		EditText editText = (EditText) findViewById(R.id.edit_userID);
//		String message = editText.getText().toString();
//		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

}
