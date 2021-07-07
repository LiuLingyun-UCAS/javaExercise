package com.lly.chapter08.tankgame;

import java.util.Vector;

/**
 * @author 刘凌云
 * @version 1.0
 * 坦克类
 */
public class Tank {
    protected int x;
    protected int y;
    protected MyPlane container;
    private Direction direct;
    protected int speed;
    private Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;
    private long lastShotTime;
    //发射子弹间隔时间(ms)
    private int shotInterval = 500;

    public Tank(int x, int y, Direction direct, int speed, MyPlane container) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
        this.container = container;
    }

    public void moveUp() {
        y -= speed;
        y = Math.max(y, 0);
    }


    public void moveDown() {
        y += speed;
        y = Math.min(y, container.getHeight() - 60);
    }


    public void moveLeft() {
        x -= speed;
        x = Math.max(x, 0);
    }


    public void moveRight() {
        x += speed;
        x = Math.min(x, container.getTankAreaWidth() - 60);
    }

    public void shotTank() {
        long curTime = System.currentTimeMillis();
        if (lastShotTime == 0 || curTime - lastShotTime >= shotInterval) {
            lastShotTime = curTime;
            Shot shot = null;
            switch (getDirect()) {
                case UP:
                    shot = new Shot(getX() + 20, getY(), Direction.UP, 10, container);
                    break;
                case DOWN:
                    shot = new Shot(getX() + 20, getY() + 60, Direction.DOWN, 10, container);
                    break;
                case LEFT:
                    shot = new Shot(getX(), getY() + 20, Direction.LEFT, 10, container);
                    break;
                case RIGHT:
                    shot = new Shot(getX() + 60, getY() + 20, Direction.RIGHT, 10, container);
                    break;
            }
            new Thread(shot).start();
            shots.add(shot);
        }
    }

    public boolean collideWith(Tank tank) {
        switch (direct) {
            case UP:
                switch (tank.direct) {
                    case UP:
                    case DOWN:
                        if ((x >= tank.x && x <= tank.x + 40
                                && y >= tank.y && y <= tank.y + 60)
                                || (x + 40 >= tank.x && x + 40 <= tank.x + 40
                                && y >= tank.y && y <= tank.y + 60)) {
                            return true;
                        }
                        break;
                    case LEFT:
                    case RIGHT:
                        if ((x >= tank.x && x <= tank.x + 60
                                && y >= tank.y && y <= tank.y + 40)
                                || (x + 40 >= tank.x && x + 40 <= tank.x + 60
                                && y >= tank.y && y <= tank.y + 40)) {
                            return true;
                        }
                        break;
                }
                break;
            case DOWN:
                switch (tank.direct) {
                    case UP:
                    case DOWN:
                        if ((x >= tank.x && x <= tank.x + 40
                                && y + 60 >= tank.y && y + 60 <= tank.y + 60)
                                || (x + 40 >= tank.x && x + 40 <= tank.x + 40
                                && y + 60 >= tank.y && y + 60 <= tank.y + 60)) {
                            return true;
                        }
                        break;
                    case LEFT:
                    case RIGHT:
                        if ((x >= tank.x && x <= tank.x + 60
                                && y + 60 >= tank.y && y + 60 <= tank.y + 40)
                                || (x + 40 >= tank.x && x + 40 <= tank.x + 60
                                && y + 60 >= tank.y && y + 60 <= tank.y + 40)) {
                            return true;
                        }
                        break;
                }
                break;
            case RIGHT:
                switch (tank.direct) {
                    case UP:
                    case DOWN:
                        if ((x + 60 >= tank.x && x + 60 <= tank.x + 40
                                && y >= tank.y && y <= tank.y + 60)
                                || (x + 60 >= tank.x && x + 60 <= tank.x + 40
                                && y + 40 >= tank.y && y + 40 <= tank.y + 60)) {
                            return true;
                        }
                        break;
                    case LEFT:
                    case RIGHT:
                        if ((x + 60 >= tank.x && x + 60 <= tank.x + 60
                                && y >= tank.y && y <= tank.y + 40)
                                || (x + 60 >= tank.x && x + 60 <= tank.x + 60
                                && y + 40 >= tank.y && y + 40 <= tank.y + 40)) {
                            return true;
                        }
                        break;
                }
                break;
            case LEFT:
                switch (tank.direct) {
                    case UP:
                    case DOWN:
                        if ((x >= tank.x && x <= tank.x + 40
                                && y >= tank.y && y <= tank.y + 60)
                                || (x >= tank.x && x <= tank.x + 40
                                && y + 40 >= tank.y && y + 40 <= tank.y + 60)) {
                            return true;
                        }
                        break;
                    case LEFT:
                    case RIGHT:
                        if ((x >= tank.x && x <= tank.x + 60
                                && y >= tank.y && y <= tank.y + 40)
                                || (x >= tank.x && x <= tank.x + 60
                                && y + 40 >= tank.y && y + 40 <= tank.y + 40)) {
                            return true;
                        }
                        break;
                }
                break;
        }
        return false;
    }

    public void correctPosition(int delta) {
        switch (direct) {
            case UP:
                y += delta + 1;
                break;
            case DOWN:
                y -= delta + 1;
                break;
            case LEFT:
                x += delta + 1;
                break;
            case RIGHT:
                x -= delta + 1;
                break;
        }
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

    public Vector<Shot> getShots() {
        return shots;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
