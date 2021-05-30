package com.lly.chapter08.InnerClass;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        Outer03.Inner03 inner03 = outer03.new Inner03();
        inner03.say();
    }
}

class Outer03{
    private int n1 = 100;
    public String name = "张三";

    public class Inner03{
        private String name = "李四";
        public void say(){
            System.out.println(Outer03.this.name + " " + n1 + " " + this.name);
        }
    }

}
