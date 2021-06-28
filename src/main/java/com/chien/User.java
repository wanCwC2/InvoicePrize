package com.chien;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        System.out.println("輸入你想兌獎的月份");
        System.out.print("e.g. 如果是想兌獎民國110年3月至4月，則輸入11003即可，無需輸入04： ");
        Scanner scan = new Scanner(System.in);
        Website web = new Website();
        while (!web.verified()){
            System.out.println("輸入格式錯誤");
            System.out.println("輸入你想兌換的月份");
            System.out.print("e.g. 如果是想兌獎民國110年3月至4月，則輸入11003即可，無需輸入04： ");
        }
        System.out.println("以下是民國"+web.year+"年"
                +Integer.parseInt(web.month)
                +"月至"+(Integer.parseInt(web.month)+1)
                +"月的中獎號碼");
        Prize prize = new Prize();
        prize.content(web.year, web.month);
        System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
        String enterS = scan.next();
        int enterI = Integer.parseInt(enterS);
        while (enterI != 0){
            while (enterS.length() != 3){
                System.out.println("輸入格式錯誤");
                System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
                enterS = scan.next();
                enterI = Integer.parseInt(enterS);
                if (enterI == 0){
                    break;
                }
            }
            int index = 0;
            while (index < prize.data.size()){
                if (enterI == Integer.parseInt(prize.data.get(index))%1000){
                    prize.compare(index);
                    break;
                }
                index++;
            }
            if (index == prize.data.size()){
                System.out.println("沒中獎");
            }
            System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
            enterS = scan.next();
            enterI = Integer.parseInt(enterS);
        }
        prize.print();
    }
}
