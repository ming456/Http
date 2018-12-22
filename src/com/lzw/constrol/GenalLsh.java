package com.lzw.constrol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GenalLsh {
    public GenalLsh() {
    }
    
    private Calendar calendar = null;
    private long nCurrentTime = System.currentTimeMillis();
    
    public String getLsh() {
        String lsh = null;
        Locale loc = new Locale("CN");
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(nCurrentTime);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int seconde = calendar.get(Calendar.SECOND);
        int millseconde = calendar.get(Calendar.MILLISECOND);
        String yy, mm, dd, millsec;
        yy = String.valueOf(year);
        if (month < 10) {
            mm = "0" + String.valueOf(month);
        } else {
            mm = String.valueOf(month);
        }
        if (day < 10) {
            dd = "0" + String.valueOf(day);
        } else {
            dd = String.valueOf(day);
        }
        if (millseconde < 99) {
            millsec = String.valueOf(millseconde) + "0";
        } else {
            millsec = String.valueOf(millseconde);
        }
        lsh = yy + mm + dd + String.valueOf(hour) + String.valueOf(minute) + String.valueOf(seconde) + millsec;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date utilDate = new Date(nCurrentTime);
        String sz = df.format(utilDate);
        DateFormat fmt = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        return lsh;
    }
    
    public String getPh() {
        String lsh = null;
        Locale loc = new Locale("CN");
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(nCurrentTime);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int seconde = calendar.get(Calendar.SECOND);
        int millseconde = calendar.get(Calendar.MILLISECOND);
        String yy, mm, dd, millsec;
        yy = String.valueOf(year);
        if (month < 10) {
            mm = "0" + String.valueOf(month);
        } else {
            mm = String.valueOf(month);
        }
        if (day < 10) {
            dd = "0" + String.valueOf(day);
        } else {
            dd = String.valueOf(day);
        }
        if (millseconde < 99) {
            millsec = String.valueOf(millseconde) + "0";
        } else {
            millsec = String.valueOf(millseconde);
        }
        lsh = yy + mm + dd + String.valueOf(hour) + String.valueOf(minute) + String.valueOf(seconde);
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date utilDate = new Date(nCurrentTime);
        String sz = df.format(utilDate);
        DateFormat fmt = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        
        return lsh;
        
    }
}
