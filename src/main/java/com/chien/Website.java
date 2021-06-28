package com.chien;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Website {
    String year;
    String month;

    public Website(){
        super();
    }

    public boolean verified(){
        Scanner scan = new Scanner(System.in);
        int site = scan.nextInt();
        String timeNowYear = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        String timeNowMonth = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        int yearNow = Integer.parseInt(timeNowYear)-1911;
        int monthNow = Integer.parseInt(timeNowMonth);
        if (site/100 > yearNow
                || (site/100 == yearNow && site%100 > monthNow)
                || site%100 > 12
                || site%100 < 0
                || ((site%100)+1)%2 == 5){
            return false;
        }else{
            year = Integer.toString(site/100);
            if (site%100 < 10) {
                month = "0" + Integer.toString(site % 100);
            }else {
                month = Integer.toString(site % 100);
            }
            return true;
        }

    }
}
