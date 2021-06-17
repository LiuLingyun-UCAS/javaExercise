package com.lly.chapter08.tankgame;

/**
 * @author 刘凌云
 * @version 1.0
 */
public enum Direction {
    UP, RIGHT, DOWN, LEFT;

    public static Direction getDirection(int i) {
        switch (i) {
            case 0:
                return UP;
            case 1:
                return RIGHT;
            case 2:
                return DOWN;
            case 3:
                return LEFT;
        }
        return null;
    }
}
