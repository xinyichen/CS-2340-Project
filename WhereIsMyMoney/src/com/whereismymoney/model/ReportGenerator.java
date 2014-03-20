package com.whereismymoney.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;

import com.whereismymoney.service.Date;
import com.whereismymoney.service.Pair;

/**
 * fetch various report from database
 * @author cxy
 *
 */
public class ReportGenerator {
    
    public Report generateSpendingCategoryReport(String username, Date start, Date end) {
        try {
            // To Check: does sql get confused about month-date sequence?
            Document doc = Jsoup.connect("http://192.185.4.36/~zli342/get_withdraw_summary.php")
                    .data("username", username)
                    .data("start_date", start.toStringYMD())
                    .data("end_date", end.toStringYMD())
                    .timeout(15*1000).get();
            Log.i("start", start.toString());
            Log.i("end", end.toString());
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
