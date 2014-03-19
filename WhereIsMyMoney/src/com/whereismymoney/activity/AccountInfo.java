package com.whereismymoney.activity;

import java.util.ArrayList;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
/**
 * This class handles the account's information page.
 * It displays information about the account and provides buttons
 * to create new transactions or accounts.
 */

public class AccountInfo extends Activity {
    private AccountManager accountManager;
    private Button createAccount, viewReport;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        
        accountManager = new AccountManager();        
        createAccount = (Button) findViewById(R.id.bNewAccount);
        viewReport = (Button) findViewById(R.id.button_view_report);
        
        //clicking on create a new account
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goCreateAccount = new Intent("android.intent.action.CREATEACCOUNT");
                startActivity(goCreateAccount);
            }
        });
        
        //clicking to view report
        viewReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goViewReport = new Intent("android.intent.action.VIEWREPORT");
                startActivity(goViewReport);
            }
        });
        
        displayAccountInfo();
 
    }
    
    /**
     * display all account information under the current user in the form of a list
     * each list item is clickable and on click will lead to the account details page
     */
    private void displayAccountInfo() {
        ListView accInfoList = (ListView) findViewById(R.id.listView_account_info_table);
        final List<Account> accountList = accountManager.getAllAccounts(CurrentUser.getCurrentUser().getUserName());
        List<String> list = new ArrayList<String>();

        // for each account, display name, balance and interest rate
        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            list.add(account.toString(10,10,10));
        }
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_simple_list_item, list);
        accInfoList.setAdapter(adapter);
        accInfoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                CurrentAccount.getCurrentAccount().setAccountName(accountList.get(position).getFullName());
                Intent goViewAccountDetail = new Intent("android.intent.action.VIEWACCOUNTDETAIL");
                startActivity(goViewAccountDetail);
            }
        });
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