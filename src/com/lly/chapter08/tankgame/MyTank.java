package com.lly.chapter08.tankgame;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class MyTank extends Tank {
    public static final int TYPE = 1;
    public MyTank(int x, int y, Direction direct, int speed) {
        super(x, y, direct, speed);
    }
}
