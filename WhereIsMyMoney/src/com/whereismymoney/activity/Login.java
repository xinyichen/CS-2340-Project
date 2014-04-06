package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.PasswordManager;
import com.whereismymoney.service.IntegrityCheck;

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
	Button login, register, forgot_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		passwordManager = new PasswordManager();
		login = (Button) findViewById(R.id.button_login_login);
		register = (Button) findViewById(R.id.button_login_register);
		forgot_password = (Button) findViewById(R.id.button_forgot_password);
		//back = (Button) findViewById(R.id.button_back_from_login);
		
		//all the stuff associated with clicking the login button
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    EditText username = (EditText) findViewById(R.id.edit_text_login_username);
			    EditText password = (EditText) findViewById(R.id.edit_text_login_password);
			    String failAlert = "Registration Failed";
			    String failReason = null;
			    //checking to see if the password is at least 7 characters and the username is at least one character
			    if(IntegrityCheck.checkPasswordLength(password.getText().toString(), 7) && IntegrityCheck.isInputValid(username.getText().toString())) {
			    	//checks with the server to see if the login info is valid
			    	if (passwordManager.login(username.getText().toString(), password.getText().toString())) {
			    		Intent goToAccountList = new Intent("android.intent.action.ACCOUNTINFO");
			    		startActivity(goToAccountList);
			    	} else {
			    		//the server returned false for the login method with those parameters
			    		failReason = "Incorrect User Name or Password";
			    	}
			    } else {
			    	//alerting the user that the password is <7 characters
			    	if(!IntegrityCheck.checkPasswordLength(password.getText().toString(), 7)) {
			    		failReason = "Your password must be at least 7 characters";
			    	} else {
			    		//alerting the user that they didn't enter a username
			    		failReason = "You need to enter a username!";
			    	}
			    	AlertDialog loginFailAlert = new AlertDialog.Builder(Login.this).create();
			    	loginFailAlert.setTitle(failAlert);
		    		loginFailAlert.setMessage(failReason);
		    		loginFailAlert.show();
			    }
			}
		});
		
	@Override
    public void onClick(View v) {
        Log.i("click", "clicked");
        switch (v.getId()) {
            case R.id. setOnClickListener:
                Intent goToRegister = new Intent(
                        "android.intent.action.REGISTER");
                startActivity(goToRegister);
                break;
            case R.id. OnClickListener:
                Intent goToForgotPassword = new Intent(
                        "android.intent.action.FORGOTPASSWORD");
                startActivity(goToForgotPassword);
                break;
        }
    }

		
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
