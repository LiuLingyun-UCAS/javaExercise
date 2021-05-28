package com.lly.chapter08.codeblock;

public class CodeBlock {
    public static void main(String[] args) {
        new B();
    }
}

class A {
    static int n1 = getInt();

    static {
        System.out.println("A类静态代码块调用");
    }

    int n2 = getInt2();

    {
        System.out.println("A类普通代码块调用");
    }

    public A(){
        System.out.println("A类构造器调用");
    }

    private int getInt2() {
        System.out.println("A类getInt2()调用");
        return 200;
    }

    private static int getInt() {
        System.out.println("A类getInt()调用");
        return 100;
    }


}

class B extends A {
    static int n3 = getInt();

    static {
        System.out.println("B类静态代码块调用");
    }

    int n4 = getInt2();

    {
        System.out.println("B类普通代码块调用");
    }

    public B(){
        System.out.println("B类构造器调用");
    }

    private int getInt2() {
        System.out.println("B类getInt2()调用");
        return 200;
    }

    private static int getInt() {
        System.out.println("B类getInt()调用");
        return 100;
    }
}
