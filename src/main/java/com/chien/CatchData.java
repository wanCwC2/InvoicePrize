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
    static List<Integer> number = new ArrayList<Integer>();
    static String urlData = null;

    public void want() {
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
//            System.out.println(urlData);
            Parser(urlData);
//            System.out.println(number.get(0));
//            System.out.println("統一發票中獎號碼");
            for (int i = 0; i < name.length; i++) {
                System.out.printf("%-12s %d",name[i],number.get(i));
                System.out.println();
            }
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
        int len = name.length;
        do {
//            System.out.println("s="+start+"e="+end);
            if (counter <= len-2 && counter >=len-4){
                start = data.indexOf("<p>",end+1);
                end = data.indexOf("</p>", start+1);
                temp = data.substring(end-8, end);
                number.add(Integer.parseInt(temp));
            }else if(counter == len-1){
                start = data.indexOf("<td headers=\""+name[counter]+"\" class=\"number\">",
                        end+1);
                end = data.indexOf("</td>", start+1);
                temp = data.substring(end-4, end-1);
                number.add(Integer.parseInt(temp));
            }else {
                start = data.indexOf("<td headers=\""+name[counter]+"\" class=\"number\">",
                        end+1);
                end = data.indexOf("</td>", start+1);
                temp = data.substring(end-9, end-1);
                number.add(Integer.parseInt(temp));
            }
            counter++;
        }while (counter < len);
    }

    public static List<Integer> get(){
        return number;
    }
}
