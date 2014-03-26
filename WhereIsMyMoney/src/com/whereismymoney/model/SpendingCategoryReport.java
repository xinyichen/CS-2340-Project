package com.whereismymoney.model;

import java.util.ArrayList;
import java.util.List;

import com.whereismymoney.service.Date;
import com.whereismymoney.service.Pair;

/**
 * holds information of one's spending category report over a certain period of time
 * and is able to output a formatted text report.
 * @author cxy
 *
 */
public class SpendingCategoryReport implements Report {
    private List<Pair<String, Double>> mySpendings = new ArrayList<Pair<String, Double>>();
    private Date start, end;
    
    public SpendingCategoryReport(List<Pair<String, Double>> spendings, Date startDate, Date endDate) {
        mySpendings = spendings;
        start = startDate;
        end = endDate;
    }
    
    /**
     * output a formatted spending category report.
     */
    @Override
    public String toString() {
        String report = "Spending Category Report\n"
                        + start.toString() + " - " + end.toString() + "\n";
        
        if (mySpendings != null) {
            for (Pair<String, Double> spending : mySpendings) {
                report += spending.getItem1() + "     " + spending.getItem2() + "\n"; 
            }
        }
        
        return report;
    }
}
