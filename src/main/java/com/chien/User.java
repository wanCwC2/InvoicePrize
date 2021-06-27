package com.chien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        System.out.println("以下是2021年3月至4月的中獎號碼");
        CatchData cd = new CatchData();
        cd.want();
        List<Integer> prize = new ArrayList<Integer>();
        prize = cd.get();
        int enter = 1;
        while (enter != 0){
            int index = 0;
            System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
            Scanner scan = new Scanner(System.in);
            enter = scan.nextInt();
            while (index < prize.size()){
                if (enter == prize.get(index)%1000){
                    System.out.println("Fine");
                }
                index++;
            }
        }
    }
}
