package com.lly.chapter08.arrays;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = {new Book("红楼梦", 100), new Book("金瓶梅", 90),
                        new Book("青年文摘", 5), new Book("java从入门到放弃", 300)};
        //使用Comparable接口实现价格从小到大排序
        //Arrays.sort(books);
        //使用Comparator接口实现价格从大到小排序
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book implements Comparable<Book> {

    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Book o) {
        if (price > o.price) {
            return 1;
        } else if (price == o.price) {
            return 0;
        } else {
            return -1;
        }
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
