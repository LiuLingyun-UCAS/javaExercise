package com.lly.chapter08.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class DrawCircle extends JFrame{

    MyPanel myPanel;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        myPanel = new MyPanel();
        add(myPanel);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class MyPanel extends JPanel{
    int count;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println(count++);
        System.out.println(Panel.class);
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.jpeg"));
//        g.drawImage(image, 10, 10, 240, 170, this);
        g.drawString("abc", 0, 100);
//        g.drawOval(10, 10, 100, 100);
    }
}
