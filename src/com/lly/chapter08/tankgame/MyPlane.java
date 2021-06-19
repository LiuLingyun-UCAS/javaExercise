package com.lly.chapter08.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class MyPlane extends JPanel implements KeyListener, Runnable {
    private MyTank myTank;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private Vector<Shot> myShots = new Vector<>();
    private int enemyTankNum = 3;
    private int width;
    private int height;

    public MyPlane() {
        width = 1000;
        height = 750;
        myTank = new MyTank(200, 200, Direction.UP, 10, width, height);
        for (int i = 0; i < enemyTankNum; i++) {
            enemyTanks.add(new EnemyTank((i + 1) * 100, 0, Direction.DOWN, 2, width, height));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, width, height);
        //画坦克
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), MyTank.TYPE);
        //画子弹
        Iterator<Shot> it = myShots.iterator();
        while (it.hasNext()) {
            Shot next = it.next();
            if (next != null) {
                if(next.isLive()) {
                    drawShot(next.getX(), next.getY(), g, next.getDirect());
                } else {
                    it.remove();
                }
            }
        }
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
        switch (direct) {
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

    public void drawShot(int x, int y, Graphics g, Direction direct){
        g.setColor(Color.YELLOW);
        switch (direct) {
            case UP:
                g.fill3DRect(x, y - 6, 2, 6, false);
                break;
            case RIGHT:
                g.fill3DRect(x, y, 6, 2, false);
                break;
            case LEFT:
                g.fill3DRect(x - 6, y, 6, 2, false);
                break;
            case DOWN:
                g.fill3DRect(x, y, 2, 6, false);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                myTank.setDirect(Direction.UP);
                myTank.moveUp();
                break;
            case KeyEvent.VK_S:
                myTank.setDirect(Direction.DOWN);
                myTank.moveDown();
                break;
            case KeyEvent.VK_A:
                myTank.setDirect(Direction.LEFT);
                myTank.moveLeft();
                break;
            case KeyEvent.VK_D:
                myTank.setDirect(Direction.RIGHT);
                myTank.moveRight();
                break;
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            myTank.shotTank();
            if(myTank.getShot() != null){
                myShots.add(myTank.getShot());
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
