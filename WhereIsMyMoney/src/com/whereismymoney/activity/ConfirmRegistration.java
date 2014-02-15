package com.whereismymoney.activity;

import com.whereismymoney.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmRegistration extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_registration);
//		// Receive the intent info
//		Intent intent = getIntent();
//		String message = intent.getStringExtra(Login.EXTRA_MESSAGE);
//	
//		// Create the text view
//	    TextView textView = new TextView(this);
//	    textView.setTextSize(40);
//	    textView.setText(message);
//
//	    // Set the text view as the activity layout
//	    setContentView(textView);
//
//	// Make sure we're running on Honeycomb or higher to use ActionBar APIs
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//        // Show the Up button in the action bar.
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//    }


	Button login = (Button) findViewById(R.id.button_goToLoginFromConfirmRegistration);
	Button createAnotherNewAccount = (Button) findViewById(R.id.button_goToRegisterFromConfirmRegistration);
	login.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent goToLogin = new Intent("android.intent.action.LOGIN");
			startActivity(goToLogin);
		}
	});
	
	
	createAnotherNewAccount.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent goToRegister = new Intent("android.intent.action.REGISTER");
			startActivity(goToRegister);
		}
	});
		
	}
	
	
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        NavUtils.navigateUpFromSameTask(this);
        return true;
    }
    return super.onOptionsItemSelected(item);
}
}