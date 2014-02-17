package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.PasswordManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the login page.
 */

public class Login extends Activity {	
	private PasswordManager passwordManager;
	Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
			        Intent goToAccountList = new Intent("android.intent.action.ACCOUNTROOT");
	                startActivity(goToAccountList);
			    }
			    else {
			        AlertDialog loginFailAlert = new AlertDialog.Builder(Login.this).create();
			        loginFailAlert.setTitle("Login Failed");
			        loginFailAlert.setMessage("Incorrect User Name or Password");
			        loginFailAlert.show();
			    }
			}
		});
	}
}
