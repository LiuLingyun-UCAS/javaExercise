package com.lly.chapter08.tankgame;

import java.io.Serializable;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Recorder implements Serializable {
    private int hitEnemyCount = 0;
    private int score = 0;

    public void hitEnemy(){
        hitEnemyCount++;
        score += 10;
    }

    public int getHitEnemyCount() {
        return hitEnemyCount;
    }

    public int getScore() {
        return score;
    }
}
