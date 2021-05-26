package com.lly.chapter08.poly_.polyarr;

public class PolyArray {
    public static void main(String[] args) {
        Person[] people = new Person[5];

        people[0] = new Person("LuRenJia", 23);
        people[1] = new Student("XueShengJia", 15, 98);
        people[2] = new Student("XueShengYi", 17, 59.9);
        people[3] = new Teacher("LaoShiJia", 22, 2000);
        people[4] = new Teacher("LaoShiYi", 25, 5000);

        for (Person p : people) {
            System.out.println(p.say());
            if (p instanceof Student) {
                ((Student)p).study();
            } else if(p instanceof Teacher) {
                ((Teacher)p).teach();
            }
        }
    }
}
