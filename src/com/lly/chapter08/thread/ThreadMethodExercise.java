package com.lly.chapter08.thread;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class ThreadMethodExercise {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + (i + 1));
            Thread.sleep(1000);
            if(i == 4){
                Thread t1 = new Thread(()->{
                    for (int j = 0; j < 10; j++) {
                        System.out.println("hello " + (j + 1));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("子线程结束");
                });
                t1.start();
                t1.join();
            }
        }
        System.out.println("主线程结束");
    }
}
