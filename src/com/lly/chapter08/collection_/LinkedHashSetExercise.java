package com.lly.chapter08.collection_;

import java.util.*;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class LinkedHashSetExercise {

    public static void main(String[] args) {
        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        cars.add(new Car("奥拓", 1000));
        cars.add(new Car("奥迪", 300000));
        cars.add(new Car("法拉利", 10000000));
        cars.add(new Car("奥迪", 300000));
        cars.add(new Car("保时捷", 70000000));
        cars.add(new Car("奥迪", 400000));

        System.out.println(cars);
    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.getPrice(), getPrice()) == 0 && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
