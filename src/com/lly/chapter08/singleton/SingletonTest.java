package com.lly.chapter08.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingleStarving singleStarving1 = SingleStarving.getInstance();
        SingleStarving singleStarving2 = SingleStarving.getInstance();
        System.out.println(singleStarving1 == singleStarving2);
        SingleLazy singleLazy1 = SingleLazy.getInstance();
        SingleLazy singleLazy2 = SingleLazy.getInstance();
        System.out.println(singleLazy1 == singleLazy2);
    }
}
