package com.lly.chapter08.poly_.polyarr;

public class Teacher extends Person {
    private double salary;

    public Teacher() {
    }

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() + " salary=" + salary;
    }

    public void teach(){
        System.out.println(getName() + " is teaching");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
