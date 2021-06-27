package com.chien;

import java.util.ArrayList;
import java.util.List;

public class Prize {
    CatchData cd = new CatchData();
    public List<Integer> data = new ArrayList<Integer>(cd.get());
    String[] nameData = {"特別獎", "特獎", "頭獎A", "頭獎B", "頭獎C", "增開六獎"};
    public String name;
    public int bonus;
    public List list = new ArrayList<>();
    int total = 0;
    List<Integer> enter = new ArrayList<>();
    List<String> winName = new ArrayList<>();
    List<Integer> winBonus = new ArrayList<>();

    public Prize(){
        super();
    }

    public void content(){
        for (int i = 0; i < nameData.length; i++) {
            System.out.printf("%-7s", nameData[i]);
            System.out.println(data.get(i));
        }
    }

    public void compare(int index){
        CompareData cpd = new CompareData();
        list = cpd.compare(index, data.get(index));
        if ((int)list.get(0) != 9){
            total += (int)list.get(3);
            enter.add((int)list.get(1));
            winName.add((String) list.get(2));
            winBonus.add((int)list.get(3));
        }
    }

}
