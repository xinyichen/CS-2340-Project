package com.whereismymoney.service;

import java.util.Calendar;

/**
 * utility class that holds a date and is able to output date in different
 * formats
 * @author cxy
 *
 */
public class Date {
    private int year;
    private int month;
    private int day;
    
    public Date() {
        Calendar today = Calendar.getInstance();
        year = today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH) + 1; // offset the zero-indexed month number
        day = today.get(Calendar.DAY_OF_MONTH);
    }
    
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // TODO: integrity check for setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    // default format MM/DD/YYYY
    @Override
    public String toString() {
        return toStringMDY();
    }
    
    public String toStringMDY() {
        return month + "/" + day + "/" + year;
    }
    
    // for sql query
    public String toStringYMD() {
        return year + "-" + month + "-" + day;
    }
    
    // TODO: define more date format
}
