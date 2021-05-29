package com.lly.chapter08.abstract_;

public class Abstract {
    public static void main(String[] args) {
        Cat cat = new Cat("aaa");
        cat.say();
        cat.eat();
    }

}

abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public void say(){
        System.out.println("hello");
    }
    
}

class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
