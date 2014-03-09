package com.whereismymoney.activity;

import java.util.Calendar;

import com.whereismymoney.R;
import com.whereismymoney.model.CurrentUser;
import com.whereismymoney.model.Date;
import com.whereismymoney.model.ReportGenerator;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ViewReport extends Activity {
    Date startDate, endDate;
    TextView startDateTxt, endDateTxt, reportTxt;
    Button generateReport;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        
        reportTxt = (TextView)findViewById(R.id.text_view_report_body);
        startDateTxt = (TextView)findViewById(R.id.text_view_report_start_date);
        endDateTxt = (TextView)findViewById(R.id.text_view_report_end_date);
        startDate = new Date();
        endDate = new Date();
        
        // set up today as the default date
        startDateTxt.setText(startDateTxt.getText() + " " + startDate.toString());
        endDateTxt.setText(endDateTxt.getText() + " " + endDate.toString());
        
        // enable date selection by making text clickable
        startDateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                
            }
        });
        
        generateReport = (Button)findViewById(R.id.button_generate_report);
        generateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ReportGenerator generator = new ReportGenerator();
                Report report = generator.generateSpendingCategoryReport(CurrentUser.getCurrentUser().getUserName(), startDate, endDate);
                reportTxt.setText(report.toString());
            }
        });
    }
  
    // need min api 11 support
//    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            // Use the current date as the default date in the picker
//            final Calendar c = Calendar.getInstance();
//            int year = c.get(Calendar.YEAR);
//            int month = c.get(Calendar.MONTH);
//            int day = c.get(Calendar.DAY_OF_MONTH);
//
//            // Create a new instance of DatePickerDialog and return it
//            return new DatePickerDialog(getActivity(), this, year, month, day);
//        }
//
//        public void onDateSet(DatePicker view, int year, int month, int day) {
//            // Do something with the date chosen by the user
//        }
//    }
//    
//    public void showDatePickerDialog(View v) {
//        DialogFragment newFragment = new DatePickerFragment();
//        newFragment.show(getSupportFragmentManager(), "datePicker");
//    }
}