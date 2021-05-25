package com.lly.chapter08.extend_.exercise;

public class ExtendExercise01 {
    public static void main(String[] args) {
        /*输出
        * a
        * b name
        * b
        */
        B b = new B();
    }
}

class A{
    A(){
        System.out.println("a");
    }

    A(String name){
        System.out.println("a name");
    }
}

class B extends A{
    B(){
        this("abc");
        System.out.println("b");
    }

    B(String name) {
        System.out.println("b name");
    }
}
