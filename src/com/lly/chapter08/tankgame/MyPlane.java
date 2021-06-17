package com.lly.chapter08.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class MyPlane extends JPanel implements KeyListener {
    private MyTank myTank;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private int enemyTankNum = 3;
    private int width;
    private int height;

    public MyPlane() {
        width = 1000;
        height = 750;
        myTank = new MyTank(200, 200, Direction.UP, 10);
        for (int i = 0; i < enemyTankNum; i++){
            enemyTanks.add(new EnemyTank((i + 1) * 100, 0, Direction.DOWN, 2));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, width, height);
        //画坦克
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), MyTank.TYPE);
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g,
                    enemyTank.getDirect(), EnemyTank.TYPE);
        }
    }

    /**
     * 画坦克
     *
     * @param x      横坐标
     * @param y      纵坐标
     * @param g      画笔
     * @param direct 方向
     * @param type   型号
     */
    public void drawTank(int x, int y, Graphics g, Direction direct, int type) {
        switch (type) {
            case 0://敌方坦克
                g.setColor(Color.CYAN);
                break;
            case 1://己方坦克
                g.setColor(Color.YELLOW);
                break;
        }
        switch (direct){
            case UP: //up
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case RIGHT://right
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case DOWN://down
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case LEFT://left
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w':
            case 'W':
                myTank.setDirect(Direction.UP);
                myTank.moveUp();
                break;
            case 's':
            case 'S':
                myTank.setDirect(Direction.DOWN);
                myTank.moveDown(height);
                break;
            case 'a':
            case 'A':
                myTank.setDirect(Direction.LEFT);
                myTank.moveLeft();
                break;
            case 'd':
            case 'D':
                myTank.setDirect(Direction.RIGHT);
                myTank.moveRight(width);
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
