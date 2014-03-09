package com.whereismymoney.activity;

import java.util.List;

import com.whereismymoney.R;
import com.whereismymoney.model.Account;
import com.whereismymoney.model.AccountManager;
import com.whereismymoney.model.CurrentAccount;
import com.whereismymoney.model.CurrentUser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * This class handles the account's information page.
 * It displays information about the account and provides buttons
 * to create new transactions or accounts.
 */

public class AccountInfo extends Activity {
    private AccountManager accountManager;
    private Button createAccount, createNewTransaction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        
        accountManager = new AccountManager();        
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
        
        // create a table that contains all account information of the current user
        TableLayout accountTable = (TableLayout)findViewById(R.id.table_account_info);
        List<Account> accountList = accountManager.getAllAccounts(CurrentUser.getCurrentUser().getUserName());

        // TODO: format, alignment, scrollable
        // for each account, display name, balance and interest rate
        for (Account account : accountList) {
            account.display(accountTable, this);
        }
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