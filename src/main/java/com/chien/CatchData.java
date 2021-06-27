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
        String site = "https://www.etax.nat.gov.tw/etw-main/web/ETW183W2_"+year+month+"/";
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
                start = data.indexOf("<p>",end+1);
                end = data.indexOf("</p>", start+1);
                temp = data.substring(end-8, end);
            }else if(counter == len-1){
                start = data.indexOf("<td headers=\""+name[counter]+"\" class=\"number\">",
                        end+1);
                end = data.indexOf("</td>", start+1);
                if(end - start - 42 >7){
                    end = data.indexOf("、", start+1);
                    temp = data.substring(end-3, end);
                    prize.add(temp);
                    start = data.indexOf("、", start+1);
                    end = data.indexOf("</td>", start+1);
                }
                temp = data.substring(end-4, end-1);
            }else {
                start = data.indexOf("<td headers=\""+name[counter]+"\" class=\"number\">",
                        end+1);
                end = data.indexOf("</td>", start+1);
                temp = data.substring(end-9, end-1);
            }
            prize.add(temp);
            counter++;
        }while (counter < len);
    }

    public static List<String> get(String year, String month){
        catchdata(year, month);
        return prize;
    }
}
