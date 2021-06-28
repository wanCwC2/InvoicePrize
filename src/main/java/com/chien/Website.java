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
        System.out.print("輸入你想發票兌獎號碼的年月份: ");
        Scanner scan = new Scanner(System.in);
        int site = scan.nextInt();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -2);
        cal.add(Calendar.DATE, -25);
        String timeNowYear = new SimpleDateFormat("yyyy").format(cal.getTime());
        String timeNowMonth = new SimpleDateFormat("MM").format(cal.getTime());
        int yearNow = Integer.parseInt(timeNowYear)-1911;
        int monthNow = Integer.parseInt(timeNowMonth);
        if (site/100 > yearNow
                || (site/100 == yearNow && site%100 > monthNow)
                || site%100 > 12
                || site%100 < 0
                || ((site%100)+1)%2 != 0
                || site/100 < 101
                || (site/100 == 101 && site%100 <5)){
            return false;
        } else{
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
