package com.lly.chapter08.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master tom = new Master("汤姆");
        Animal dog = new Dog("小花");
        Food bone = new Bone("骨头");
        Animal cat = new Cat("小红");
        Food fish = new Fish("红烧鱼");

        tom.feed(dog, bone);
        tom.feed(cat, fish);
    }
}
