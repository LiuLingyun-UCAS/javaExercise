package com.lly.chapter08.tankgame;

import javax.swing.*;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class MyFrame extends JFrame {

    MyPlane myPlane;

    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame(){
        myPlane = new MyPlane();
        new Thread(myPlane).start();
        add(myPlane);
        addKeyListener(myPlane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1015, 788);
        setVisible(true);
    }
}
