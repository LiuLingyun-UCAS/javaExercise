package com.lly.chapter08.tankgame;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class MyTank extends Tank {
    public static final int TYPE = 1;
    private Shot shot;

    public MyTank(int x, int y, Direction direct, int speed, int xMax, int yMax)
    {
        super(x, y, direct, speed, xMax, yMax);
    }
    public void shotTank(){
        switch (getDirect()){
            case UP:
                shot = new Shot(getX() + 20, getY(), Direction.UP, 10, getXMax(), getYMax());
                break;
            case DOWN:
                shot = new Shot(getX() + 20, getY() + 60, Direction.DOWN, 10, getXMax(), getYMax());
                break;
            case LEFT:
                shot = new Shot(getX() , getY() + 20, Direction.LEFT, 10, getXMax(), getYMax());
                break;
            case RIGHT:
                shot = new Shot(getX() + 60, getY() + 20, Direction.RIGHT, 10, getXMax(), getYMax());
                break;
        }
        new Thread(shot).start();
    }

    public Shot getShot() {
        return shot;
    }
}
