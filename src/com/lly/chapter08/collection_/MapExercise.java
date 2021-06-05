package com.lly.chapter08.collection_;

import java.util.*;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class MapExercise {

    public static void main(String[] args) {
        Map<Integer, Employee> hashMap = new HashMap<>();

        hashMap.put(1, new Employee("张三", 1, 20000));
        hashMap.put(2, new Employee("李四", 2, 17000));
        hashMap.put(3, new Employee("王五", 3, 30000));

        System.out.println("--------第一种遍历---------");
        for (Map.Entry<Integer, Employee> entry : hashMap.entrySet()) {
            Employee e = entry.getValue();
            if(e.getSalary() > 18000){
                System.out.println(e);
            }
        }

        System.out.println("--------第二种遍历---------");
        for (Integer id : hashMap.keySet()) {
            Employee e = hashMap.get(id);
            if(e.getSalary() > 18000){
                System.out.println(e);
            }
        }

    }
}

class Employee{
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
