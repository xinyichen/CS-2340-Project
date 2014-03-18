package com.whereismymoney.model;

import java.util.ArrayList;
import java.util.List;

import com.whereismymoney.service.Date;
import com.whereismymoney.service.Pair;

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
        String report = "Spending Category Report\n" + 
                        start.toString() + " - " + end.toString() + "\n";
        
        if (mySpendings != null) {
            for (Pair<String, Double> spending : mySpendings) {
                report += spending.getItem1() + "     " + spending.getItem2() + "\n"; 
            }
        }
        
        return report;
    }
}
