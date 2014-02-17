package com.whereismymoney.activity;

import java.util.List;

import com.whereismymoney.R;
import com.whereismymoney.model.AccountManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountRoot extends Activity {
    private AccountManager accountManager;
    private Button createAccount;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_root);
        
        accountManager = new AccountManager();
        createAccount = (Button) findViewById(R.id.bNewAccount);
        
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goCreateAccount = new Intent("android.intent.action.CREATEACCOUNT");
                startActivity(goCreateAccount);
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);       
        List<String> menuList = accountManager.getAccountList();
        
        if (menuList != null) {
            for (int i = 0; i < menuList.size(); i++) {
                menu.add(0, i, 0, menuList.get(i));
            }
        }
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}