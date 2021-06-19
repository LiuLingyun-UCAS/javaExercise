package com.lly.chapter08.tankgame;

/**
 * @author 刘凌云
 * @version 1.0
 * 坦克类
 */
public class Tank {
    private int x;
    private int y;
    private int xMax;
    private int yMax;
    private Direction direct;
    private int speed;

    public Tank(int x, int y, Direction direct, int speed, int xMax, int yMax) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public void moveUp() {
        y -= speed;
        y = Math.max(y, 0);
    }


    public void moveDown() {
        y += speed;
        y = Math.min(y, yMax - 60);
    }


    public void moveLeft() {
        x -= speed;
        x = Math.max(x, 0);
    }


    public void moveRight() {
        x += speed;
        x = Math.min(x, xMax - 60);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirect() {
        return direct;
    }

    public void setDirect(Direction direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXMax() {
        return xMax;
    }

    public void setXMax(int xMax) {
        this.xMax = xMax;
    }

    public int getYMax() {
        return yMax;
    }

    public void setYMax(int yMax) {
        this.yMax = yMax;
    }
}
