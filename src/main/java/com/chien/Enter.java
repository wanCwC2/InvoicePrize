package com.chien;

import java.util.Scanner;

public class Enter {
    String string;
    int integer;

    public boolean vertified(int number){
        Scanner scan = new Scanner(System.in);
        String temp = scan.next();
        if ((Integer.parseInt(temp) == 0) && (number == 3)) {
            string = temp;
            integer = Integer.parseInt(temp);
            return true;
        }else if (temp.length() != number){
            return false;
        }else{
            string = temp;
            integer = Integer.parseInt(temp);
            return true;
        }
    }
}
