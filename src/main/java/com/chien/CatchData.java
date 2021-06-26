package com.chien;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class CatchData {
    static String[] name = {"specialPrize", "grandPrize", "firstPrize", "twoPrize",
            "threePrize", "fourPrize", "fivePrize", "sixPrize", "addsixPrize"};
    static List<String> number = new ArrayList<String>();
    static String urlData = null;

    public static void main(String[] args) {
        String site = "https://www.etax.nat.gov.tw/etw-main/web/ETW183W2_11003/";
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
            System.out.println(urlData);
            Parser(urlData);
            System.out.println(number.get(0));
//            System.out.println("統一發票中獎號碼");
//            for (int i = 0; i < name.length; i++) {
//                System.out.println(name[i]+"\t"+number.get(i));
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Parser(String data) {
        String temp = null;
        int start = 0;
        int end = 0;
        int counter = 0;
//        do {
            start = data.indexOf("<td headers=\"specialPrize\" class=\"number\">",end+1);
            end = data.indexOf("</td>", start+1);
            System.out.println("s="+start+"e="+end);
            temp = data.substring(end-9, end-1);
            number.add(temp);
//            counter++;
//        }while (start < name.length);
    }
}
