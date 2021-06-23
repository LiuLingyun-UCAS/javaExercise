package com.lly.chapter08.tankgame;

import java.util.Random;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable{
    public static final int TYPE = 0;

    public EnemyTank(int x, int y, Direction direct, int speed, int xMax, int yMax) {
        super(x, y, direct, speed, xMax, yMax);
    }

    @Override
    public void run() {
        Random r = new Random();
        Direction[] directions = Direction.values();
        while(true){
            int steps = r.nextInt(60) + 30;
            for (int i = 0; i < steps; i++) {
                if (!isLive()){
                    break;
                }
                switch (getDirect()){
                    case UP:
                        moveUp();
                        break;
                    case DOWN:
                        moveDown();
                        break;
                    case LEFT:
                        moveLeft();
                        break;
                    case RIGHT:
                        moveRight();
                        break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //是否发射子弹
                double p = r.nextDouble();
                //p>=0.98发射一颗子弹
                if(p >= 0.98) {
                    shotTank();
                }
            }
            setDirect(directions[r.nextInt(4)]);
            if (!isLive()){
                break;
            }
        }
    }
}
