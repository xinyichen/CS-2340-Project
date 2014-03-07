package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.AccountManager;
import com.whereismymoney.model.CurrentUser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the activity associated with creating a new account
 */

public class CreateAccount extends Activity {
    private Button confirm, cancel;
    private AccountManager accountManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        accountManager = new AccountManager();
        
        confirm = (Button) findViewById(R.id.button_create_account_confirm);
        
        //clicking confirm
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            // todo: check input integrity
            public void onClick(View arg0) {
                EditText fullName = (EditText) findViewById(R.id.edit_text_create_account_full_name);
                EditText displayName = (EditText) findViewById(R.id.edit_text_create_account_display_name);
                EditText balance = (EditText) findViewById(R.id.edit_text_create_account_balance);
                EditText interestRate = (EditText) findViewById(R.id.edit_text_account_interest_rate);

                String fullNameStr = fullName.getText().toString();
                String displayNameStr = displayName.getText().toString();
                Double accBalance = Double.parseDouble(balance.getText().toString());
                Double accIntRate = Double.parseDouble(interestRate.getText().toString());
                
                String failAlert = "Account Creation Failed";
                String failReason = null;
                if(fullNameStr.matches("\\s*")) {
                	failReason = "You didn't enter a full name for the account!";
                } else if(displayNameStr.matches("\\s*")) {
                	failReason = "You didn't enter a display name for the account!";
                } else if(accountManager.createAccount(CurrentUser.getCurrentUser().getUserName(), displayNameStr, fullNameStr, accBalance, accIntRate)) {
                	Intent goToAccountInfo = new Intent("android.intent.action.ACCOUNTINFO");
                	startActivity(goToAccountInfo);
                } else {
                	failReason = "You entered something incorrectly. Please check your entries and try again.";
                }
                AlertDialog accountFailAlert = new AlertDialog.Builder(CreateAccount.this).create();
		        accountFailAlert.setTitle(failAlert);
		        accountFailAlert.setMessage(failReason);
		        accountFailAlert.show();
            }
        });
        
        //clicking cancel
        cancel = (Button) findViewById(R.id.button_create_account_reject);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goToAccountInfo = new Intent("android.intent.action.ACCOUNTINFO");
                startActivity(goToAccountInfo);
            }
        });
    }

}
