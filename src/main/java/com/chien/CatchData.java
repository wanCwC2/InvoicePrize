package com.chien;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class CatchData {
    static String[] name = {"specialPrize", "grandPrize", "firstPrizeA",
            "firstPrizeB", "firstPrizeC", "addSixPrize"};
    static List<String> prize = new ArrayList<>();
    static String urlData = null;

    public static void catchdata(String year, String month) {
        String site = "https://www.etax.nat.gov.tw/etw-main/ETW183W2_"+year+month+"/";
        try {
            URL url = new URL(site);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            String line = bis.readLine();
            StringBuffer data = new StringBuffer();
            while(line != null) {
                data.append(line);
                line = bis.readLine();
            }
            urlData = data.toString();
            parser(urlData);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parser(String data) {
        String temp = null;
        int start = 0;
        int end = 0;
        int counter = 0;
        int len = name.length;
        do {
            if (counter <= len-2 && counter >=len-4){
                start = data.indexOf("<div class=\"col-12 mb-3\">",end+1);
                end = data.indexOf("</div>", start+1);
                temp = data.substring(end-23, end-15);
                prize.add(temp);
            }else if(counter == len-1){
                start = data.indexOf("<div class=\"col-12 mb-3\">", end+1);
                end = data.indexOf("</div>", start+1);
                temp = data.substring(end-18, end-15);
                prize.add(temp);
                counter++;
                start = data.indexOf("<div class=\"col-12 mb-3\">", end+1);
                if(start != -1){
                    end = data.indexOf("</div>", start+1);
                    temp = data.substring(end-23, end-15);
                    prize.add(temp);
                }
            }else {
                start = data.indexOf("<div class=\"col-12 mb-3\">",
                        end+1);
                end = data.indexOf("</div>", start+1);
                temp = data.substring(end-23, end-15);
                prize.add(temp);
            }
//            prize.add(temp);
            counter++;
        }while (counter < len);
    }

    public static List<String> get(String year, String month){
        catchdata(year, month);
        return prize;
    }
}
