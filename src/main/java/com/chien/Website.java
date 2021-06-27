package com.chien;

public class Website {
    String year;
    String month;

    public Website(){
        super();
    }

    public boolean verified(int site){
        if (site/100 > 110
                || (site/100 == 110 && site%100 > 3)
                || site%100 > 12
                || site%100 < 0
                || ((site%100)+1)%2 == 5){
            System.out.println("輸入格式錯誤");
            System.out.println("輸入你想兌換的月份");
            System.out.print("e.g. 如果是想兌獎民國110年3月至4月，則輸入11003即可，無需輸入04： ");
            return false;
        }else{
            year = Integer.toString(site/100);
            month = "0"+Integer.toString(site%100);
            return true;
        }

    }
}
