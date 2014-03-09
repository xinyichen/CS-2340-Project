package com.whereismymoney.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;

import com.whereismymoney.activity.Pair;
import com.whereismymoney.activity.Report;
import com.whereismymoney.activity.SpendingCategoryReport;

public class ReportGenerator {
    
    public Report generateSpendingCategoryReport(String username, Date start, Date end) {
        Document doc = null;
        try {
            // To Check: does sql get confused about month-date sequence?
            doc = Jsoup.connect("http://192.185.4.36/~zli342/get_withdraw_summary.php")
                    .data("username", username)
                    .data("start_date", start.toString())
                    .data("end_date", start.toString())
                    .timeout(15*1000).get();
            Elements categoryList = doc.select("category");
            Elements amountList = doc.select("subtotal");
            List<Pair<String, Double>> spendings = new ArrayList<Pair<String, Double>>();
            
            for (int i = 0; i < categoryList.size(); i++) {
                spendings.add(new Pair(categoryList.get(i).text(), "" + amountList.get(i).text()));
            }
            
            return new SpendingCategoryReport(spendings, start, end);
        } 
        catch(IOException e) {
            Log.i("fail",e.toString());
        }
        return null;
    }
}
