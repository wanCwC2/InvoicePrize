package com.chien;

import java.util.ArrayList;
import java.util.List;

public class Prize {
    CatchData cd = new CatchData();
    public List<Integer> data = new ArrayList<Integer>(cd.get());
    String[] nameData = {"特別獎", "特獎", "頭獎A", "頭獎B", "頭獎C", "增開六獎"};
    public String name;
    public int bonus;

    public Prize(){
        super();
    }

    public void content(){
        for (int i = 0; i < nameData.length; i++) {
            System.out.printf("%-7s", nameData[i]);
            System.out.println(data.get(i));
        }
    }

}
