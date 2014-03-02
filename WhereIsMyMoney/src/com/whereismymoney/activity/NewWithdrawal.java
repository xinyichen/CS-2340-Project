package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.TransactionManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the creation of a new withdrawal for a given account
 */

public class NewWithdrawal extends Activity{

	private TransactionManager transactionManager;
	Button confirm, cancel;
	Bundle a;
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.onCreate(a);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		a = savedInstanceState;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_withdrawal);
		transactionManager = new TransactionManager();
		
		confirm = (Button) findViewById(R.id.button_withdrawal_confirm);
		cancel = (Button) findViewById(R.id.button_withdrawal_cancel);
		
		//this method handles the confirm button being clicked
		confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText reason = (EditText) findViewById(R.id.edit_withdrawal_reason);
				EditText expenseCategory = (EditText) findViewById(R.id.edit_withdrawal_expense_category);
			    EditText amount = (EditText) findViewById(R.id.edit_withdrawal_amount);
				EditText effectiveDate = (EditText) findViewById(R.id.edit_withdrawal_effective_date);
				if(reason.getText().toString().matches("\\s*")) {
					AlertDialog newWithdrawalFailAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalFailAlert.setTitle("Withdrawal Failed");
			        newWithdrawalFailAlert.setMessage("You didn't enter a reason");
			        newWithdrawalFailAlert.show();
				} else if(expenseCategory.getText().toString().matches("\\s*")) {
					AlertDialog newWithdrawalFailAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalFailAlert.setTitle("Withdrawal Failed");
			        newWithdrawalFailAlert.setMessage("You didn't enter an expense category");
			        newWithdrawalFailAlert.show();
				} else if(amount.getText().toString().matches("\\s*")) {
					AlertDialog newWithdrawalFailAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalFailAlert.setTitle("Withdrawal Failed");
			        newWithdrawalFailAlert.setMessage("You didn't enter an amount");
			        newWithdrawalFailAlert.show();
				} else if(effectiveDate.getText().toString().matches("\\s*")) {
					AlertDialog newWithdrawalFailAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalFailAlert.setTitle("Withdrawal Failed");
			        newWithdrawalFailAlert.setMessage("You didn't enter an effective date");
			        newWithdrawalFailAlert.show();
				} else if(amount.getText().toString().matches("[0-9]{0,}.[0-9]{2}")) {
					AlertDialog newWithdrawalFailAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalFailAlert.setTitle("Withdrawal Failed");
			        newWithdrawalFailAlert.setMessage("Amount needs to be in the format #...#.##. Ex: 4.25");
			        newWithdrawalFailAlert.show();
			        //this regex only checks for a valid format, doesn't make sure it is actually a valid date
				} else if(effectiveDate.getText().toString().matches("[0-9]{2}\\\\/[0-9]{2}\\\\/[0-9]{4}")) {
					AlertDialog newWithdrawalFailAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalFailAlert.setTitle("Withdrawal Failed");
			        newWithdrawalFailAlert.setMessage("Date is not in the correct format. Correct format is yyyy-mm-dd");
			        newWithdrawalFailAlert.show();
			        //success case.
				} else if(transactionManager.newWithdrawal(reason.getText().toString(), expenseCategory.getText().toString(), Double.parseDouble(amount.getText().toString()), effectiveDate.getText().toString())) {
					AlertDialog newWithdrawalAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalAlert.setTitle("Success");
			        newWithdrawalAlert.setMessage("Withdrawal succeeded");
			        newWithdrawalAlert.show();
			        
				} else {
					//failure. Due to: 1. low balance. 2. network error. (need to separate the two cases in future)
					AlertDialog newWithdrawalFailAlert = new AlertDialog.Builder(NewWithdrawal.this).create();
			        newWithdrawalFailAlert.setTitle("Withdrawal Failed");
			        newWithdrawalFailAlert.setMessage("Not enough balance");
			        newWithdrawalFailAlert.show();
				}
			}
		});
		
		//this method handles the cancel button being clicked
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent goBackToNewTransaction = new Intent("android.intent.action.NEWTRANSACTION");
				startActivity(goBackToNewTransaction);
			}
		});	
	}

}
