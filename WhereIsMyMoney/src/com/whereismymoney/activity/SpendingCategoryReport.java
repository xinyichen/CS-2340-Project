package com.whereismymoney.activity;

import java.util.ArrayList;
import java.util.List;

import com.whereismymoney.model.Date;

public class SpendingCategoryReport implements Report {
    List<Pair<String, Double>> mySpendings = new ArrayList<Pair<String, Double>>();
    Date start;
    Date end;
    
    public SpendingCategoryReport(List<Pair<String, Double>> spendings, Date startDate, Date endDate) {
        mySpendings = spendings;
        start = startDate;
        end = endDate;
    }
    
    @Override
    public String toString() {
        String report = start.toString() + " - " + end.toString() + "\n";
        
        if (mySpendings != null) {
            for (Pair<String, Double> spending : mySpendings) {
                report += spending.getItem1() + "     " + spending.getItem2() + "\n"; 
            }
        }
        
        return report;
    }
}
