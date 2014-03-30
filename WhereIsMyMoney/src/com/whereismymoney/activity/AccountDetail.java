package com.whereismymoney.activity;

import com.whereismymoney.R;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * UI class to display transaction details associated with the current account.
 * @author cxy
 *
 */
public class AccountDetail extends FragmentActivity implements DatePickerDialog.OnDateSetListener {
    private Button createNewTransaction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
		// Turn off the window's title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transaction_history);
        
        createNewTransaction = (Button) findViewById(R.id.button_create_new_transaction);
        
        //clicking on new transaction
        createNewTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goCreateTransaction = new Intent("android.intent.action.NEWTRANSACTION");
                startActivity(goCreateTransaction);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
        
    }

}
