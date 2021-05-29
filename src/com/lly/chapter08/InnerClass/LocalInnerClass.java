package com.lly.chapter08.InnerClass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
    }
}

class Outer{
    private int n1 = 100;

    public void m1(){

        //局部抽象类
        abstract class Inner{
            public static final int NUM = 1000;
            private int n2 = 200;

            public Inner(){
                System.out.println("构造器被调用");
            }

            public abstract void f2();
            public void f1(){
                System.out.println(n1);
            }

            public int getN2() {
                return n2;
            }

            public void setN2(int n2) {
                this.n2 = n2;
            }
        }
        //局部final类
        final class SubInner extends Inner{

            @Override
            public void f2() {
                System.out.println("f2()");
            }
        }

        System.out.println(Inner.NUM);
        Inner inner = new SubInner();
        inner.f1();
        inner.f2();
    }
}
