package com.lly.chapter08.singleton;

public class SingleLazy {
    private static SingleLazy instance;

    private SingleLazy(){

    }

    public static SingleLazy getInstance(){
        if (instance == null){
            instance = new SingleLazy();
        }
        return instance;
    }
}
