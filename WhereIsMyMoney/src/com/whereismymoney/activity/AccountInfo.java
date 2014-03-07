package com.whereismymoney.activity;

import java.util.List;

import com.whereismymoney.R;
import com.whereismymoney.model.Account;
import com.whereismymoney.model.AccountManager;
import com.whereismymoney.model.CurrentAccount;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class handles the account's information page.
 * It displays information about the account and provides buttons
 * to create new transactions or accounts.
 */

public class AccountInfo extends Activity {
    private AccountManager accountManager;
    private Button createAccount, createNewTransaction;
    private TextView accountName, balance, intRate;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        
        accountManager = new AccountManager();
        accountName = (TextView) findViewById(R.id.text_account_full_name_display);
        balance = (TextView) findViewById(R.id.text_account_balance_display);
        intRate = (TextView) findViewById(R.id.text_account_interest_rate_display);
        
        createAccount = (Button) findViewById(R.id.bNewAccount);
        createNewTransaction = (Button) findViewById(R.id.button_create_new_transaction);
        
        //clicking on create a new account
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goCreateAccount = new Intent("android.intent.action.CREATEACCOUNT");
                startActivity(goCreateAccount);
            }
        });
        
        //clicking on new transaction
        createNewTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	//making sure they have an account to do transactions with
            	if(CurrentAccount.getCurrentAccount().getAccountName()==null) {
            		AlertDialog actionFailAlert = new AlertDialog.Builder(AccountInfo.this).create();
			        actionFailAlert.setTitle("Action Failed");
			        actionFailAlert.setMessage("You don't have an account selected for this transaction! Either create a new account or select a preexisting account from the menu.");
			        actionFailAlert.show();
            	} else {
            		Intent goCreateTransaction = new Intent("android.intent.action.NEWTRANSACTION");
            		startActivity(goCreateTransaction);
            	}
            }
        });
        
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);       
        List<String> menuList = accountManager.getAccountList();
        
        //creating the list of accounts they can select from the menu
        if (menuList != null) {
            for (int i = 0; i < menuList.size(); i++) {
                menu.add(0, i, 0, menuList.get(i));
            }
        }
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {    
    	//setting the current account for transaction purposes
    	CurrentAccount.getCurrentAccount().setAccountName(item.getTitle().toString());
    	
        Account currAccount = accountManager.getAccountInfo(item.getTitle().toString());
        accountName.setText("Account Name: " + currAccount.getFullName());
        balance.setText("Current Balance: " + currAccount.getBalance());
        intRate.setText("Interest Rate: " + currAccount.getInterestRate());
        return true;
    }
    
    @Override
    public void onBackPressed() {
    	//creates a dialog asking the user if they want to exit
    	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
    	    @Override
    	    public void onClick(DialogInterface dialog, int which) {
    	        switch (which){
    	        case DialogInterface.BUTTON_POSITIVE:
    	            //application quits
    	        	finish();
    	            break;

    	        case DialogInterface.BUTTON_NEGATIVE:
    	            //no action
    	            break;
    	        }
    	    }
    	};

    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage("Are you sure you want to exit?").setPositiveButton("Yes", dialogClickListener)
    	    .setNegativeButton("No", dialogClickListener).show();
    }
}