package com.lly.chapter08.interface_;

public class Interface01 {

    public static void main(String[] args) {
        AInterface a = new A();
        AInterface b = () -> 'a';
        System.out.println(a instanceof AInterface);//true
    }
}

interface AInterface {
    //所有属性都为public static final
    int n1 = 10;

    //抽象方法为public abstract
    char getChar();

    //jdk8.0以后的默认方法
    default void ok() {
        System.out.println("ok");
    }

    //jdk8.0后的静态方法
    static void cry() {
        System.out.println("cry");
    }

}

class A implements AInterface {
    @Override
    public char getChar() {
        return 0;
    }
}
