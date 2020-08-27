package com.etc.Ayy_collection.map集合;

import java.util.Objects;

public class orange implements Comparable {
    private int price;
    private String color;
    private double weight;

    public orange() {

    }

    public orange(int price, String color, double weight) {
        this.price = price;
        this.color = color;
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "orange{" +
                "price=" + price +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return ((orange) o).price - this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        orange orange = (orange) o;
        return price == orange.price &&
                Double.compare(orange.weight, weight) == 0 &&
                Objects.equals(color, orange.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, color, weight);
    }
}
