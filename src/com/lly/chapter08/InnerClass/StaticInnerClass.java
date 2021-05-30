package com.lly.chapter08.InnerClass;

public class StaticInnerClass {
    public static void main(String[] args) {
        new Outer04.Inner04().say();
        Outer04.InnerInterface anInterface = new Outer04.InnerInterface() {
            @Override
            public void cry() {
                System.out.println("内部接口");
            }
        };
        anInterface.cry();
    }
}

class Outer04{
    private static int n1 = 100;
    public static String name = "张三";

    public static class Inner04{
        private String name = "李四";
        public void say(){
            System.out.println(Outer04.name + " " + n1 + " " + this.name);
        }
    }

    public interface InnerInterface{
        void cry();
    }

}