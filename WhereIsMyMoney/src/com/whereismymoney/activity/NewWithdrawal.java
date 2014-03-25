package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.TransactionManager;
import com.whereismymoney.service.IntegrityCheck;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the creation of a new withdrawal for a given account.
 */

public class NewWithdrawal extends Activity {

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

        // this method handles the confirm button being clicked
        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText reason = (EditText) findViewById(R.id.edit_withdrawal_reason);
                EditText expenseCategory = (EditText) findViewById(R.id.edit_withdrawal_expense_category);
                EditText amount = (EditText) findViewById(R.id.edit_withdrawal_amount);
                EditText effectiveDate = (EditText) findViewById(R.id.edit_withdrawal_effective_date);

                String alertMessage = "Withdrawal Failed";
                String alertReason = null;
                if (!IntegrityCheck.isInputValid(reason.getText().toString())) {
                    alertReason = "You didn't enter a reason";
                } else if (!IntegrityCheck.isInputValid(expenseCategory
                        .getText().toString())) {
                    alertReason = "You didn't enter an expense category";
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
                } else if (transactionManager.newWithdrawal(reason.getText()
                        .toString(), expenseCategory.getText().toString(),
                        Double.parseDouble(amount.getText().toString()),
                        effectiveDate.getText().toString())) {
                    alertMessage = "Success";
                    alertReason = "Withdrawal succeeded";
                } else {
                }
                AlertDialog newWithdrawalAlert = new AlertDialog.Builder(
                        NewWithdrawal.this).create();
                newWithdrawalAlert.setTitle(alertMessage);
                newWithdrawalAlert.setMessage(alertReason);
                newWithdrawalAlert.show();
            }
        });

        // this method handles the cancel button being clicked
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent goBackToNewTransaction = new Intent(
                        "android.intent.action.NEWTRANSACTION");
                startActivity(goBackToNewTransaction);
            }
        });
    }

}
