package com.lly.chapter08.InnerClass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Outer02().method();
    }
}

class Outer02 {

    public void method() {
        ((IA) () -> {
            System.out.println("接口匿名类1");
            System.out.println(Outer02.this.hashCode());
            System.out.println(hashCode());
            System.out.println(getClass());
            return 1000;
        }).cry();

        new IA(){

            @Override
            public int cry() {
                System.out.println("接口匿名类2");
                System.out.println(Outer02.this.hashCode());
                System.out.println(hashCode());
                System.out.println(getClass());
                return 1000;
            }
            public void cry02(){
                System.out.println("cry02");
            }
        }.cry();

        new Father("Tom") {
            @Override
            public double m1() {
                System.out.println("抽象类匿名类");
                System.out.println(Outer02.this.hashCode());
                System.out.println(hashCode());
                System.out.println(getClass());
                return 0.1;
            }
        }.m1();

        new CC("Mike"){
            public void say(){
                System.out.println("基于类的匿名类");
                System.out.println(Outer02.this.hashCode());
                System.out.println(hashCode());
                System.out.println(getClass());
                System.out.println(getName());
            }
        }.say();
    }
}

interface IA {
    int cry();
}

abstract class Father {

    public Father(String name) {
    }

    public abstract double m1();
}

class CC{
    private String name;
    public CC(String name){this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
