package com.whereismymoney.activity;

import com.whereismymoney.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity {
	Button login, register;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_welcome);
	    login = (Button) findViewById(R.id.bLogin);
	    register = (Button) findViewById(R.id.bRegister);

	    login.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent goToLogin = new Intent("android.intent.action.LOGIN");
	            startActivity(goToLogin);
	        }
	    });

	    register.setOnClickListener(new View.OnClickListener() {	
	        @Override
	        public void onClick(View v) {
	            Intent goToRegister = new Intent("android.intent.action.REGISTER");
	            startActivity(goToRegister);
	        }
	    });
	}
}
