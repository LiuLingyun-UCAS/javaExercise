package com.lly.chapter08.tankgame;

import java.util.Random;
import java.util.Vector;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class EnemyTank extends Tank{
    public static final int TYPE = 0;
    public static int uid = 0;
    private int id;
    private Random r = new Random();
    private int steps = r.nextInt(60) + 30;
    private int curStep;

    public EnemyTank(int x, int y, Direction direct, int speed, MyPlane container) {
        super(x, y, direct, speed, container);
        this.id = uid++;
    }

    public boolean collideWithOtherTank() {
        if(container.getMyTank().isLive() && collideWith(container.getMyTank())){
            return true;
        }
        Vector<EnemyTank> enemyTanks = container.getEnemyTanks();
        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank != this &&  collideWith(enemyTank)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void moveUp() {
        for (int i = 0; i < speed; i++) {
            if(collideWithOtherTank()){
                return;
            }
            y--;
            y = Math.max(y, 0);
        }
    }

    @Override
    public void moveDown() {
        for (int i = 0; i < speed; i++) {
            if(collideWithOtherTank()){
                return;
            }
            y++;
            y = Math.min(y, container.getTankAreaHeight() - 60);
        }
    }

    @Override
    public void moveLeft() {
        for (int i = 0; i < speed; i++) {
            if(collideWithOtherTank()){
                return;
            }
            x--;
            x = Math.max(x, 0);
        }
    }

    @Override
    public void moveRight() {
        for (int i = 0; i < speed; i++) {
            if(collideWithOtherTank()){
                return;
            }
            x++;
            x = Math.min(x, container.getTankAreaWidth() - 60);
        }
    }

    public void moveAndFire(){
        if (!isLive()){
            return;
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
        curStep++;
        if(curStep == steps){
            steps = r.nextInt(60) + 30;
            curStep = 0;
            Direction[] directions = Direction.values();
            setDirect(directions[r.nextInt(4)]);
        }
        double p = r.nextDouble();
        //p>=0.98发射一颗子弹
        if(p >= 0.98) {
            shotTank();
        }
    }

    public int getId() {
        return id;
    }
}
