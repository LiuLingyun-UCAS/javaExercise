package com.lly.chapter08.tankgame;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Shot implements Runnable {
    private int x;//子弹x坐标
    private int y;//子弹y坐标
    private Direction direct;
    private int speed = 2;
    private boolean isLive = true;
    private MyPlane container;

    public Shot(int x, int y, Direction direct, int speed, MyPlane container) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(x + " " + y);
            switch (direct) {
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
            }
            if(x < 0 || x > container.getTankAreaWidth() || y < 0 || y > container.getTankAreaHeight() || !isLive){
                isLive = false;
                break;
            }
        }
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

    public Direction getDirect() {
        return direct;
    }

    public void setDirect(Direction direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
