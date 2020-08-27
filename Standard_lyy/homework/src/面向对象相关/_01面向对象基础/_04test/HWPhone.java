package 面向对象相关._01面向对象基础._04test;

public class HWPhone {
    private String type;
    private double price;
    private String color;
    public static String brand;

    public HWPhone(String type, double price, String color) {
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public void call() {
        System.out.println(this.type + "打电话");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
