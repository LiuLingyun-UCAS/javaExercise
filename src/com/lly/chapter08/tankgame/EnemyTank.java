package com.lly.chapter08.tankgame;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class EnemyTank extends Tank {
    public static final int TYPE = 0;

    public EnemyTank(int x, int y, Direction direct, int speed, int xMax, int yMax) {
        super(x, y, direct, speed, xMax, yMax);
    }
}
