package com.lly.chapter08.poly_;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public void feed(Animal animal, Food food) {
        if (animal instanceof Dog) {
            System.out.println("主人" + name + "给狗狗" + animal.getName() + "喂了" + food.getName());
        } else if (animal instanceof Cat) {
            System.out.println("主人" + name + "给猫猫" + animal.getName() + "喂了" + food.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
