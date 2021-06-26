package com.chien;

import org.apache.hc.core5.util.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CatchData {
    static String[] name = {"特別獎", "特獎", "頭獎", "二獎", "三獎", "四獎", "五獎", "六獎", "增開六獎"};
    static List<String> number = new ArrayList<String>();
    static String urlData = null;

    public static void main(String[] args) {
        String site = "https://www.etax.nat.gov.tw/etw-main/web/ETW183W2_11003/";
        try {
            URL url = new URL(site);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayBuffer bab = new ByteArrayBuffer();
            int data = 0;
            while ((data = bis.read()) != -1){
                bab.append((byte) data);
            }
//            urlData = EcondingUtils.getString(data, "UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
