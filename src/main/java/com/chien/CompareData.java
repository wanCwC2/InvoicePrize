package com.chien;

import java.util.Scanner;

public class CompareData {
    public static void main(String[] args) {
        int index = 2;
        int prize = 22884739;
        Scanner scan = new Scanner(System.in);
        System.out.println("輸入你的完整發票號碼");
        int enter = scan.nextInt();
        if (index == 0){
            if (enter == prize){
                System.out.println("恭喜中特別獎");
            }
        }else if (index == 1){
            if (enter == prize){
                System.out.println("恭喜中特獎");
            }
        }else if (index == 2 || index == 3 || index == 4){
            int counter = 100000000;
            boolean win = firstPrize(enter, prize, counter);
            if (win){
                System.out.println("恭喜中頭獎中的一個");
            }
        }else if (index == 5){
            if (enter == prize) {
                System.out.println("恭喜中增開六獎");
            }
        }
    }
    public static boolean firstPrize (int enter, int prize, int counter) {
        if (counter < 100) {
            return false;
        } else {
            if (enter == prize % counter) {
                return true;
            } else {
                return firstPrize(enter, prize, counter / 10);
            }
        }
    }
}
