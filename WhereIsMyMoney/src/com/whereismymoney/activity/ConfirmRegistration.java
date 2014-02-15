package com.whereismymoney.activity;

import com.whereismymoney.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class controls a simple confirm registration page that
 * simply tells the user that they have registered and provides a 
 * button that links them back to the login page.
 * 
 * @author andrewfarrow
 */

public class ConfirmRegistration extends Activity{

	Button clickHere; //the button that links to the login page
	Bundle a;
	
	@Override
	protected void onResume() {
		super.onResume();
		this.onCreate(a);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		a = savedInstanceState;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_registration);
		clickHere = (Button) findViewById(R.id.button_confirm_register);
		
		//The button listener that takes the user back to the main activity (login screen)
		clickHere.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent goToMainActivity = new Intent("com.example.myfirstapp.MAINACTIVITY");
				startActivity(goToMainActivity);
			}
		});
		
	}
}
