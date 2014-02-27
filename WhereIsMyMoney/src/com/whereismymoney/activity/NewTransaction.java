package com.whereismymoney.activity;

import com.whereismymoney.R;

import com.whereismymoney.model.AccountManager;
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
 * This class handles the selection of a new transaction type, 
 * deposit or withdrawal. User can also go back to the 
 * account info screen.
 */

public class NewTransaction extends Activity{
	
	Bundle a;
	Button deposit, withdrawal, cancel;
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.onCreate(a);
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);
        
        deposit = (Button) findViewById(R.id.button_new_deposit);
        withdrawal = (Button) findViewById(R.id.button_new_withdrawal);
        cancel = (Button) findViewById(R.id.button_goBackToAccountInfoFromNewTransaction);
        
        //going to the new deposit screen
        deposit.setOnClickListener(new View.OnClickListener() {	
	        @Override
	        public void onClick(View v) {
	            Intent goToNewDeposit = new Intent("android.intent.action.NEWDEPOSIT");
	            startActivity(goToNewDeposit);
	        }
	    });
        
        //going to the new withdrawal screen
        withdrawal.setOnClickListener(new View.OnClickListener() {	
	        @Override
	        public void onClick(View v) {
	            Intent goToNewWithdrawal = new Intent("android.intent.action.NEWWITHDRAWAL");
	            startActivity(goToNewWithdrawal);
	        }
	    });
        
        //going back to the account info screen
        cancel.setOnClickListener(new View.OnClickListener() {	
	        @Override
	        public void onClick(View v) {
	            Intent goBackToAccountInfo = new Intent("android.intent.action.ACCOUNTINFO");
	            startActivity(goBackToAccountInfo);
	        }
	    });
	}	
}