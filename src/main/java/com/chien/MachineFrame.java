package com.chien;

import javax.swing.*;
import java.awt.*;

public class MachineFrame extends JFrame {
    public static JLabel label = new JLabel("");
    public void frame(){
        setTitle("統一發票兌獎機");
        setSize(600, 400);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(label, BorderLayout.NORTH);
        setVisible(true);
    }
}
