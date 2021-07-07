package com.lly.chapter08.tankgame;

import java.util.Vector;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class MyTank extends Tank {
    public static final int TYPE = 1;

    public MyTank(int x, int y, Direction direct, int speed, MyPlane container) {
        super(x, y, direct, speed, container);
    }

    public boolean collideWithEnemyTank() {
        Vector<EnemyTank> enemyTanks = container.getEnemyTanks();
        for (EnemyTank enemyTank : enemyTanks) {
            if (collideWith(enemyTank)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void moveUp() {
        for (int i = 0; i < speed; i++) {
            if(collideWithEnemyTank()){
                return;
            }
            y--;
            y = Math.max(y, 0);
        }
    }

    @Override
    public void moveDown() {
        for (int i = 0; i < speed; i++) {
            if(collideWithEnemyTank()){
                return;
            }
            y++;
            y = Math.min(y, container.getTankAreaHeight() - 60);
        }
    }

    @Override
    public void moveLeft() {
        for (int i = 0; i < speed; i++) {
            if(collideWithEnemyTank()){
                return;
            }
            x--;
            x = Math.max(x, 0);
        }
    }

    @Override
    public void moveRight() {
        for (int i = 0; i < speed; i++) {
            if(collideWithEnemyTank()){
                return;
            }
            x++;
            x = Math.min(x, container.getTankAreaWidth() - 60);
        }
    }
}
