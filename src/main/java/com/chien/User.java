package com.chien;

public class User {
    public static void main(String[] args) {
        System.out.println("輸入你想兌獎的月份");
        System.out.println("根據財政部提供的資料，可追溯到101年5月的兌換號碼（110.6.28註）");
        System.out.print("e.g. 如果是想兌獎民國110年3月至4月，則輸入11003即可，無需輸入04： ");
        Website web = new Website();
        while (!web.verified()){
            System.out.println("輸入格式錯誤");
            System.out.println("輸入你想兌換的月份");
            System.out.println("根據財政部提供的資料，可追溯到101年5月的兌換號碼（110.6.28註）");
            System.out.print("e.g. 如果是想兌獎民國110年3月至4月，則輸入11003即可，無需輸入04： ");
        }
        System.out.println("以下是民國"+web.year+"年"
                +Integer.parseInt(web.month)
                +"月至"+(Integer.parseInt(web.month)+1)
                +"月的中獎號碼");
        Prize prize = new Prize();
        prize.content(web.year, web.month);
        Enter enter = new Enter();
        do {
            System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
            while (!enter.vertified(3)){
                System.out.println("輸入格式錯誤");
                System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
            }
            int index = 0;
            while (index < prize.data.size()){
                if (enter.integer == Integer.parseInt(prize.data.get(index))%1000){
                    prize.compare(index);
                    break;
                }
                index++;
            }
            if ((index == prize.data.size()) && (enter.integer != 0)){
                System.out.println("沒中獎");
            }
        }while (enter.integer != 0);
        prize.print();
    }
}
