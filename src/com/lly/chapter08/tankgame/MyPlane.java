package com.lly.chapter08.tankgame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author 刘凌云
 * @version 1.0
 */
@SuppressWarnings("all")
public class MyPlane extends JPanel implements KeyListener, Runnable {
    private MyTank myTank;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private int enemyTankNum = 3;
    private int width;
    private int height;
    private Vector<Boom> booms = new Vector<>();
    private Vector<Image> boomImages = new Vector<>();

    public MyPlane() throws IOException {
        width = 1000;
        height = 750;
        myTank = new MyTank(200, 200, Direction.UP, 10, width, height);
        for (int i = 0; i < enemyTankNum; i++) {
            EnemyTank enemyTank = new EnemyTank((i + 1) * 200, 300, Direction.DOWN, 2, width, height);
            enemyTanks.add(enemyTank);
            new Thread(enemyTank).start();
        }
        for (int i = 0; i < 11; i++){
            boomImages.add(ImageIO.read(Panel.class.getResource("/image/" + i + ".gif")));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, width, height);
        //画坦克
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), MyTank.TYPE);
        //画子弹
        drawShot(myTank.getShots(), g, Color.YELLOW);
        Iterator<EnemyTank> enemyTankIterator = enemyTanks.iterator();
        while (enemyTankIterator.hasNext()) {
            EnemyTank enemyTank = enemyTankIterator.next();
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g,
                        enemyTank.getDirect(), EnemyTank.TYPE);
            } else {
                enemyTankIterator.remove();
            }
            drawShot(enemyTank.getShots(), g, Color.RED);
        }
        drawBoom(g);

    }

    public void drawBoom(Graphics g){
        Iterator<Boom> boomIterator = booms.iterator();
        while (boomIterator.hasNext()) {
            Boom boom = boomIterator.next();
            if(boom.isLive()) {
                int x = boom.getX();
                int y = boom.getY();
                int index = 10 - boom.getLife();
                g.drawImage(boomImages.get(index), x, y, 60, 60, this);
                boom.lifeDown();
            }
            else{
                boomIterator.remove();
            }
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

    public void drawShot(Vector<Shot> shots, Graphics g, Color color) {
        g.setColor(color);
        Iterator<Shot> it = shots.iterator();
        while (it.hasNext()) {
            Shot next = it.next();
            if (next != null) {
                if (next.isLive()) {
                    int x = next.getX();
                    int y = next.getY();
                    Direction direct = next.getDirect();
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
                } else {
                    it.remove();
                }
            }
        }
    }

    public void hitTank(Shot s, Tank tank) {
        int sx = s.getX();
        int sy = s.getY();
        int tx = tank.getX();
        int ty = tank.getY();
        switch (s.getDirect()) {
            case UP:
            case DOWN:
                switch (tank.getDirect()) {
                    case UP:
                    case DOWN:
                        if (sx + 2 >= tx && sx <= tx + 40 && sy + 6 >= ty && sy <= ty + 60) {
                            s.setLive(false);
                            tank.setLive(false);
                            booms.add(new Boom(tx, ty));
                        }
                        break;
                    case LEFT:
                    case RIGHT:
                        if (sx + 2 >= tx && sx <= tx + 60 && sy + 6 >= ty && sy <= ty + 40) {
                            s.setLive(false);
                            tank.setLive(false);
                            booms.add(new Boom(tx, ty));
                        }
                        break;
                }
                break;
            case RIGHT:
            case LEFT:
                switch (tank.getDirect()) {
                    case UP:
                    case DOWN:
                        if (sx + 6 >= tx && sx <= tx + 40 && sy + 2 >= ty && sy <= ty + 60) {
                            s.setLive(false);
                            tank.setLive(false);
                            booms.add(new Boom(tx, ty));
                        }
                        break;
                    case LEFT:
                    case RIGHT:
                        if (sx + 6 >= tx && sx <= tx + 60 && sy + 2 >= ty && sy <= ty + 40) {
                            s.setLive(false);
                            tank.setLive(false);
                            booms.add(new Boom(tx, ty));
                        }
                        break;
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
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
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator<Shot> myShotsIt = myTank.getShots().iterator();
            while (myShotsIt.hasNext()) {
                Shot shot = myShotsIt.next();
                Iterator<EnemyTank> tanksIt = enemyTanks.iterator();
                while (tanksIt.hasNext()) {
                    EnemyTank tank = tanksIt.next();
                    hitTank(shot, tank);
                }
            }
            repaint();
        }
    }
}
