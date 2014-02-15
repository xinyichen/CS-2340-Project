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

public class Register extends Activity {
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
		setContentView(R.layout.activity_register);
		passwordManager = new PasswordManager();
		passwordManager = new PasswordManager();
		Button register = (Button) findViewById(R.id.button_confirm_register);
		Button cancel = (Button) findViewById(R.id.button_reject_registration);
		
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText email = (EditText) findViewById(R.id.edit_registration_email);
			    EditText username = (EditText) findViewById(R.id.edit_registration_username);
			    EditText password = (EditText) findViewById(R.id.edit_registration_password);
			    EditText confirmPassword = (EditText) findViewById(R.id.edit_registration_password_confirm);
			    
			    if(!password.getText().toString().equals(confirmPassword.getText().toString())) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("The password fields don't match");
			        registerFailAlert.show();
			    } else if(!password.getText().toString().matches(".{6,20}")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("Your password needs to be between 6 and 20 characters");
			        registerFailAlert.show();
			    } else if(!email.getText().toString().matches("[a-zA-Z][0-9A-Za-z\\_\\-\\.]*@[a-zA-Z][0-9A-Za-z\\_\\-]*.(com|org|net|edu)")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("Your email is in an incorrect format");
			        registerFailAlert.show();
			    } else if (passwordManager.register(username.getText().toString(), password.getText().toString(),email.getText().toString())) {
			        sendMessage(arg0); // TODO: make proper intent here
			    }
			    else {
			        // ToCheck: I just hacked Login.this as the context, is it appropriate?
			        AlertDialog loginFailAlert = new AlertDialog.Builder(Register.this).create();
			        loginFailAlert.setTitle("Registration Failed");
			        loginFailAlert.setMessage("Username Already Exists");
			        loginFailAlert.show();
			    }
			}
		});
		
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent goToWelcome = new Intent("android.intent.action.WELCOME");
				startActivity(goToWelcome);
			}
		});
		//viewPager
		//Log.d(TAG,"activity creating");
	}

	
	public void sendMessage(View view) {
		Intent intent = new Intent(this, ConfirmRegistration.class);
//		EditText editText = (EditText) findViewById(R.id.edit_userID);
//		String message = editText.getText().toString();
//		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

}



/*package com.whereismymoney.activity;

import com.example.myfirstapp.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * This class handles the registration of a new account.
 * Right now it only handles a username, email and password but
 * there are fields associated with first and last name of the user
 * that it could eventually be hooked up to something and be used.
 * 
 * @author andrewfarrow
 */

/*public class Register extends Activity {

	Button register, cancel;
	Bundle a; 
	private PasswordManager passwordManager;
	
	@Override
	protected void onResume() {
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
		cancel = (Button) findViewById(R.id.button_reject_registration);
		
		//The button listener for the confirm (create account) button, creates a new account and
		//takes them to the new member page (ConfirmRegistration.java)
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText firstName = (EditText) findViewById(R.id.edit_registration_first_name);
			    EditText lastName = (EditText) findViewById(R.id.edit_registration_last_name);
			    EditText email = (EditText) findViewById(R.id.edit_registration_email);
			    EditText username = (EditText) findViewById(R.id.edit_registration_username);
			    EditText password = (EditText) findViewById(R.id.edit_registration_password);
			    EditText confirmPassword = (EditText) findViewById(R.id.edit_registration_password_confirm);
			    
			    //Right now I don't have a way to check to see if just the username is taken
			    //so I'm faking a login to compensate (used in the first else if statement)
			    if(password.getText().toString().equals(confirmPassword.getText().toString()) && password.getText().toString().matches(".{6,20}") && email.getText().toString().matches("[a-zA-Z][0-9A-Za-z\\_\\-\\.]*@[a-zA-Z][0-9A-Za-z\\_\\-]*.(com|org|net|edu)") 
			    		&& passwordManager.register(username.getText().toString(),password.getText().toString(),email.getText().toString())) {
			    	Intent goToConfirmRegister = new Intent("com.example.myfirstapp.STARTING");
			    	startActivity(goToConfirmRegister);
			    } 
			    else {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			    
		        registerFailAlert.setTitle("Registration Failed");
		        registerFailAlert.setMessage("The password fields don't match");
		        registerFailAlert.show();
			    }*/
			    //was using this to check if the username is already taken, isn't exact so I took it out
			    /*else if(!passwordManager.login(username.getText().toString(), password.getText().toString())) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("Username already taken");
			        registerFailAlert.show();
			    }*/
			    /*else if(!password.getText().toString().equals(confirmPassword.getText().toString())) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("The password fields don't match");
			        registerFailAlert.show();
			    } else if(!password.getText().toString().matches(".{6,20}")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("Your password needs to be between 6 and 20 characters");
			        registerFailAlert.show();
			    } else if(!email.getText().toString().matches("[a-zA-Z][0-9A-Za-z\\_\\-\\.]*@[a-zA-Z][0-9A-Za-z\\_\\-]*.(com|org|net|edu)")) {
			    	AlertDialog registerFailAlert = new AlertDialog.Builder(Register.this).create();
			        registerFailAlert.setTitle("Registration Failed");
			        registerFailAlert.setMessage("Your email is in an incorrect format");
			        registerFailAlert.show();
			    }*/
/*			}
		});
		
		//button listener for the go back button, it goes back to the welcome page
		//without creating an account
		 cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToWelcome = new Intent("com.example.myfirstapp.WELCOME");
				startActivity(goToWelcome);
			}
		});
	}
} */