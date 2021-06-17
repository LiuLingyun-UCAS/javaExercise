package com.lly.chapter08.tankgame;

/**
 * @author 刘凌云
 * @version 1.0
 * 坦克类
 */
public class Tank {
    private int x;
    private int y;
    private Direction direct;
    private int speed;

    public Tank(int x, int y, Direction direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public void moveUp() {
        y -= speed;
        y = Math.max(y, 0);
    }


    public void moveDown(int height) {
        y += speed;
        y = Math.min(y, height - 60);
    }


    public void moveLeft() {
        x -= speed;
        x = Math.max(x, 0);
    }


    public void moveRight(int width) {
        x += speed;
        x = Math.min(x, width - 60);
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
}
