package com.lly.chapter08.singleton;

public class SingleStarving {

    private static SingleStarving instance = new SingleStarving();

    private SingleStarving(){

    }

    public static SingleStarving getInstance(){
        return instance;
    }

}
