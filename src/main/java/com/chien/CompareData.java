package com.chien;

import com.chien.prize.*;

import java.util.Scanner;

public class CompareData {
    public static String[] compare(int index, int prize) {
        Prize[] data = {new SpecialPrize(),
                        new GrandPrize(),
                        new FirstPrize(),
                        new TwoPrize(),
                        new ThreePrize(),
                        new FourPrize(),
                        new FivePrize(),
                        new SixPrize(),
                        new AddsixPrize(),
                        new NotPrize()};
        int number = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("輸入你的完整發票號碼：");
        int enter = scan.nextInt();
        while (enter/100000000>0 || enter/10000000==0 ){
            System.out.println("輸入內容並非為發票號碼數");
            System.out.println("發票總號碼數為8碼");
            System.out.print("輸入你的完整發票號碼：");
            enter = scan.nextInt();
        }
        if (index == 0){
            if (enter == prize){
                number = 0;
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                number = 9;
                System.out.println(data[number].name);
            }
        }else if (index == 1){
            if (enter == prize){
                number = 1;
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                number = 9;
                System.out.println(data[number].name);
            }
        }else if (index == 2 || index == 3 || index == 4){
            number = 2;
            int counter = 100000000;
            number = firstPrize(enter, prize, counter, number);
            if (number != 9){
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                System.out.println(data[number].name);
            }
        }else if (index == 5){
            if (enter%1000 == prize) {
                number = 8;
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                number = 9;
                System.out.println(data[number].name);
            }
        }
        String[] list = {Integer.toString(number), Integer.toString(enter),
                    data[number].name, Integer.toString(data[number].bonus)};
//        List list = new ArrayList();
//        list.add(number);
//        list.add(enter);
//        list.add(data[number].name);
//        list.add(data[number].bonus);
        return list;
    }

    public static int firstPrize (int enter, int prize, int counter, int number) {
        if (counter < 1000) {
            return 9;
        } else {
            if ((enter % counter) == (prize % counter)) {
                return number;
            } else {
                return firstPrize(enter, prize, counter / 10, number+1);
            }
        }
    }
}