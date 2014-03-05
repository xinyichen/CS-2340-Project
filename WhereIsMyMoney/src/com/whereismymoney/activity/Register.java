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
 * This class handles the register page.
 */

public class Register extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	private PasswordManager passwordManager;
	Bundle a;
	Button register, cancel;
	
	
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
		setContentView(R.layout.activity_register);
		passwordManager = new PasswordManager();
		register = (Button) findViewById(R.id.button_confirm_register);
		//cancel = (Button) findViewById(R.id.button_reject_registration);
		
		//this method handles everything associated with the confirm registration button
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText firstName = (EditText) findViewById(R.id.edit_registration_first_name);
			    EditText lastName = (EditText) findViewById(R.id.edit_registration_last_name);
				EditText email = (EditText) findViewById(R.id.edit_registration_email);
			    EditText username = (EditText) findViewById(R.id.edit_registration_username);
			    EditText password = (EditText) findViewById(R.id.edit_registration_password);
			    EditText confirmPassword = (EditText) findViewById(R.id.edit_registration_password_confirm);
			    
			    if(!password.getText().toString().equals(confirmPassword.getText().toString())) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("The password fields don't match");
			        registerFailAlert.show();
			    } else if(!password.getText().toString().matches(".{7,}")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("Your password needs to be at least 7 characters");
			        registerFailAlert.show();
			    } else if(!email.getText().toString().matches("[a-zA-Z][0-9A-Za-z\\_\\-\\.]*@[a-zA-Z][0-9A-Za-z\\_\\-]*.(com|org|net|edu)")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("Your email is in an incorrect format");
			        registerFailAlert.show();
			    } else if(firstName.getText().toString().matches("\\s*")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("You didn't enter in a first name!");
			        registerFailAlert.show();
			    } else if(lastName.getText().toString().matches("\\s*")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("You didn't enter in a last name!");
			        registerFailAlert.show();
			    } else if(username.getText().toString().matches("\\s*")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("You didn't enter in a username!");
			        registerFailAlert.show();
			    }
			    
			    else if (passwordManager.register(username.getText().toString(), firstName.getText().toString(), lastName.getText().toString(), password.getText().toString(), email.getText().toString())) {
			        Intent goToConfirmation = new Intent("android.intent.action.CONFIRMREGISTRATION");
		    		startActivity(goToConfirmation);
			    }
			    else {
			        AlertDialog loginFailAlert = new AlertDialog.Builder(Register.this).create();
			        loginFailAlert.setTitle("Registration Failed");
			        loginFailAlert.setMessage("Username Already Exists");
			        loginFailAlert.show();
			    }
			}
		});
	}
}