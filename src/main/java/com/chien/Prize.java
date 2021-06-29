package com.chien;

import java.util.ArrayList;
import java.util.List;

public class Prize extends MachineFrame {
    public List<String> data = new ArrayList<String>();
    public String name;
    public int bonus;
    String[] list;
    int total = 0;
    List<String> enter = new ArrayList<>();
    List<String> winName = new ArrayList<>();
    List<Integer> winBonus = new ArrayList<>();

    public Prize(){
        super();
    }

    public void content(String year, String month){
        label.setText("");
        label.setText("<html><body align=\"center\"><h1>民國"+year+"年"
                +Integer.parseInt(month)
                +"月至"+(Integer.parseInt(month)+1)
                +"月的中獎號碼</h1><br></body></html>");
        CatchData cd = new CatchData();
        data = cd.get(year, month);
        String[] nameData = {"特別獎", "特獎", "頭獎A", "頭獎B", "頭獎C", "增開六獎", "增開六獎2"};
        for (int i = 0; i < data.size(); i++) {
            label.setText(label.getText().replaceAll("</body></html>","") +
                    "<p>"+nameData[i]+"-------"+data.get(i)+"</p><br></body></html>");
        }
    }

    public void compare(int index){
        CompareData cpd = new CompareData();
        list = cpd.compare(index, Integer.parseInt(data.get(index)));
        if (Integer.parseInt(list[0]) != 9){
            total += Integer.parseInt(list[3]);
            enter.add(list[1]);
            winName.add(list[2]);
            winBonus.add(Integer.parseInt(list[3]));
        }
    }

    public void print(){
        label.setText("");
        label.setText("<html><body align=\"center\"><h1 align=\"center\">你的中獎發票</h1></body></html>");
        if (enter.size() == 0){
            label.setText(label.getText().replaceAll("</body></html>","") +"<p>完全沒中獎喔！</p></body></html>");
        }else{
            for (int i = 0; i < enter.size(); i++) {
                label.setText(label.getText().replaceAll("</body></html>","") +
                        "<p>你的發票號碼"+enter.get(i) +
                        " 中" + winName.get(i) +
                        " 得到獎金" + winBonus.get(i)+"元</p></body></html>");
            }
        }
        if (total != 0) {
            label.setText(label.getText().replaceAll("</body></html>","") +
                    "<h2>這次兌換發票的中獎總金額為" + total + "元</h2></body></html>");
        }
    }

}