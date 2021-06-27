package com.chien;

import java.util.ArrayList;
import java.util.List;

public class Prize {
    CatchData cd = new CatchData();
    public List<Integer> data = new ArrayList<Integer>(cd.get());
    public String name;
    public int bonus;
    String[] list;
    int total = 0;
    List<Integer> enter = new ArrayList<>();
    List<String> winName = new ArrayList<>();
    List<Integer> winBonus = new ArrayList<>();

    public Prize(){
        super();
    }

    public void content(){
        String[] nameData = {"特別獎", "特獎", "頭獎A", "頭獎B", "頭獎C", "增開六獎"};
        for (int i = 0; i < nameData.length; i++) {
            System.out.printf("%-7s", nameData[i]);
            System.out.println(data.get(i));
        }
    }

    public void compare(int index){
        CompareData cpd = new CompareData();
        list = cpd.compare(index, data.get(index));
        if (Integer.parseInt(list[0]) != 9){
            total += Integer.parseInt(list[3]);
            enter.add(Integer.parseInt(list[1]));
            winName.add(list[2]);
            winBonus.add(Integer.parseInt(list[3]));
        }
    }

    public void print(){
        System.out.println("-------以下是你的中獎發票-------");
        if (enter.size() == 0){
            System.out.println("完全沒中獎喔！");
        }else{
            for (int i = 0; i < enter.size(); i++) {
                System.out.println("你的發票號碼"+enter.get(i)+
                        " 中"+winName.get(i)+
                        " 得到獎金"+winBonus.get(i)+"元");
            }
        }
        System.out.println("得到獎金的總金額為"+total+"元");
    }

}