package com.lly.chapter08.extend_.exercise;

public class ExtendExercise02 {
    public static void main(String[] args) {
        /*
        * 输出
        * 我是A类
        * hahaha 我是B类的有参构造器
        * Hello 我是C类的有参构造器
        * 我是C类的无参构造器
        * */
        C2 c2 = new C2();
    }
}

class A2 {
    public A2() {
        System.out.println("我是A类");
    }
}

class B2 extends A2 {
    public B2() {
        System.out.println("我是B类的无参构造器");
    }

    public B2(String name) {
        System.out.println(name + " 我是B类的有参构造器");
    }
}

class C2 extends B2 {
    public C2(){
        this("Hello");
        System.out.println("我是C类的无参构造器");
    }

    public C2(String name) {
        super("hahaha");
        System.out.println(name + " 我是C类的有参构造器");
    }
}
