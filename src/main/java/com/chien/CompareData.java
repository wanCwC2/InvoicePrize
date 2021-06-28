package com.chien;

import com.chien.prize.*;

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
        Enter enter = new Enter();
        System.out.print("輸入你的完整發票號碼，共8碼：");
        while (!enter.vertified(8)){
            System.out.println("輸入格式錯誤");
            System.out.print("輸入你的完整發票號碼，共8碼：：");
        }
        if (index == 0){
            if (enter.integer == prize){
                number = 0;
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                number = 9;
                System.out.println(data[number].name);
            }
        }else if (index == 1){
            if (enter.integer == prize){
                number = 1;
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                number = 9;
                System.out.println(data[number].name);
            }
        }else if (index == 2 || index == 3 || index == 4){
            number = 2;
            int counter = 100000000;
            number = firstPrize(enter.integer, prize, counter, number);
            if (number != 9){
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                System.out.println(data[number].name);
            }
        }else if (index == 5 || index == 6){
            if (enter.integer%1000 == prize) {
                number = 8;
                System.out.println("恭喜中"+data[number].name+" 得到獎金為"+data[number].bonus);
            }else{
                number = 9;
                System.out.println(data[number].name);
            }
        }
        String[] list = {Integer.toString(number), enter.string,
                    data[number].name, Integer.toString(data[number].bonus)};
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