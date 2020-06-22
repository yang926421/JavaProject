package com.etc.Ayy_collection.set_demo;

import java.util.Objects;

public class Apple implements Comparable<Apple> {

    // 重写了比较方法。
    // e1.compareTo(o)
    // 比较者：this
    // 被比较者：o
    // 需求：按照jiage比较
    public Apple(){

    }

    private String name;
    private double price;
    private String color;

    public Apple(String name, Double price, String color){
        this.name = name;
        this.color = color;
        this.price = price;
    }
    @Override
    public int compareTo(Apple o) {
        System.out.println(this.color);
        return Double.compare(o.price, this.price);
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Double.compare(apple.price, price) == 0 &&
                Objects.equals(name, apple.name) &&
                Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, color);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
