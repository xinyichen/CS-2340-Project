package com.whereismymoney.model;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;

import com.whereismymoney.database.DatabaseConnect;
import com.whereismymoney.service.Date;
import com.whereismymoney.service.Pair;

/**
 * fetch various report from database.
 * 
 * @author Xinyi Chen
 * 
 */
public class ReportFactory {
	
	public static final ReportFactory INSTANCE = new ReportFactory();
	
	/**
     * Do not allow anyone to make an instance of this class
     */
	private ReportFactory() {
		
	}

	/**
	 * generate a spending category report.
	 * 
	 * @param username the user name that the report is generated for
	 * @param start stating date of the report
	 * @param end ending date of the report
	 * @return a spending category report
	 */
    public Report generateSpendingCategoryReport(String username, Date start,
            Date end) {
        Document doc = DatabaseConnect.getDatabaseConnect()
                .generateSpendingCategoryReport(username, start, end);
        Elements categoryList = doc.select("category");
        Elements amountList = doc.select("subtotal");
        List<Pair<String, Double>> spendings = new ArrayList<Pair<String, Double>>();

        for (int i = 0; i < categoryList.size(); i++) {
            spendings.add(new Pair(categoryList.get(i).text(), "" + amountList.get(i).text()));
        }

        return new SpendingCategoryReport(spendings, start, end);

    }
    
    /**
     * Create a general method that can create the right class based on a 
     * parameter
     */
    public Report generateReport(String type, String username, Date start, Date end) {
    	switch(type) {
    		case "spending category report":
    			return generateSpendingCategoryReport(username, start, end);
    		default:
    			return null;  		
    	}
    }
}
