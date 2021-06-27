package com.chien;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        System.out.println("以下是2021年3月至4月的中獎號碼");
        Prize prize = new Prize();
        prize.content();
        System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
        Scanner scan = new Scanner(System.in);
        int enter = scan.nextInt();
        while (enter != 0){
            while (enter/1000 > 0){
                System.out.println("輸入內容超過三位數");
                System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
                enter = scan.nextInt();
            }
            int index = 0;
            while (index < prize.data.size()){
                if (enter == prize.data.get(index)%1000){
                    prize.compare(index);
                    break;
                }
                index++;
            }
            if (index == prize.data.size()){
                System.out.println("沒中獎");
            }
            System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
            enter = scan.nextInt();
            while (enter/1000 > 0){
                System.out.println("輸入內容超過三位數");
                System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
                enter = scan.nextInt();
            }
        }
        prize.print();
    }
}
