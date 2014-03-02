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
	Button login, register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		passwordManager = new PasswordManager();
		login = (Button) findViewById(R.id.bLogin);
		register = (Button) findViewById(R.id.button_register);
		//back = (Button) findViewById(R.id.button_back_from_login);
		
		//all the stuff associated with clicking the login button
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			    EditText username = (EditText) findViewById(R.id.edit_userID);
			    EditText password = (EditText) findViewById(R.id.edit_password);
			    //checking to see if the password is at least 7 characters and the username is at least one character
			    if(password.getText().toString().matches(".{7,}") && username.getText().toString().matches(".+")){
			    	//checks with the server to see if the login info is valid
			    	if (passwordManager.login(username.getText().toString(), password.getText().toString())) {
			    		Intent goToAccountList = new Intent("android.intent.action.ACCOUNTINFO");
			    		startActivity(goToAccountList);
			    	} else {
			    		//the server returned false for the login method with those parameters
			    		AlertDialog loginFailAlert = new AlertDialog.Builder(Login.this).create();
			    		loginFailAlert.setTitle("Login Failed");
			    		loginFailAlert.setMessage("Incorrect User Name or Password");
			    		loginFailAlert.show();
			    	}
			    } else {
			    	//alerting the user that the password is <7 characters
			    	if(password.getText().toString().matches(".{0,6}")) {
			    		AlertDialog loginFailAlert = new AlertDialog.Builder(Login.this).create();
			    		loginFailAlert.setTitle("Login Failed");
			    		loginFailAlert.setMessage("Your password must be at least 7 characters.");
			    		loginFailAlert.show();
			    	} else {
			    		//alerting the user that they didn't enter a username
			    		AlertDialog loginFailAlert = new AlertDialog.Builder(Login.this).create();
			    		loginFailAlert.setTitle("Login Failed");
			    		loginFailAlert.setMessage("You need to enter a username!");
			    		loginFailAlert.show();
			    	}
			    }
			}
		});
		
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToRegister = new Intent("android.intent.action.REGISTER");
				startActivity(goToRegister);
				}
		});
		
		//Sends them back to the welcome page
//		back.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent goToWelcome = new Intent("android.intent.action.WELCOME");
//				startActivity(goToWelcome);
//			}
//		});
	}
}