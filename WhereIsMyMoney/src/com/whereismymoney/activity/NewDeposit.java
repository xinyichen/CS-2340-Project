package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.TransactionManager;
import com.whereismymoney.service.IntegrityCheck;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the activity associated with creating a new deposit.
 */

public class NewDeposit extends Activity {
    /**
     * This is a private manager used for transactions.
     */
    private TransactionManager transactionManager;

    /**
     * This is a button used to confirm.
     */
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	getActionBar().setTitle("");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_deposit);
        transactionManager = new TransactionManager();

        confirm = (Button) findViewById(R.id.button_confirm_deposit);

        // this method handles the confirm button being clicked
        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText source = (EditText) findViewById(R.id.edit_deposit_source);
                EditText amount = (EditText) findViewById(R.id.edit_deposit_amount);
                EditText effectiveDate = (EditText) findViewById(R.id.edit_deposit_effective_date);

                String alertMessage = "Deposit Failed";
                String alertReason = null;
                if (!IntegrityCheck.isInputValid(source.getText().toString())) {
                    alertReason = "You didn't enter a source";
                } else if (!IntegrityCheck.isInputValid(amount.getText()
                        .toString())) {
                    alertReason = "You didn't enter an amount";
                } else if (!IntegrityCheck.isInputValid(effectiveDate.getText()
                        .toString())) {
                    alertReason = "You didn't enter an effective date";
                } else if (!IntegrityCheck.amountFormat(amount.getText()
                        .toString())) {
                    alertReason = "Amount needs to be in the format #...#.##. Ex: 4.25";
                } else if (!IntegrityCheck.validDate(effectiveDate.getText()
                        .toString())) {
                    alertReason = "Date is not in the correct format. Correct format is yyyy-mm-dd";
                } else if (transactionManager.newDeposit(source.getText()
                        .toString(), Double.parseDouble(amount.getText()
                        .toString()), effectiveDate.getText().toString())) {
                    alertMessage = "Success";
                    alertReason = "Deposit added";
                } else {
                    // failure. probably due to network error.
                    alertReason = "Something's wrong";
                }
                AlertDialog newDepositAlert = new AlertDialog.Builder(
                        NewDeposit.this).create();
                newDepositAlert.setTitle(alertMessage);
                newDepositAlert.setMessage(alertReason);
                newDepositAlert.show();
            }
        });
    }
    
    //creates the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
