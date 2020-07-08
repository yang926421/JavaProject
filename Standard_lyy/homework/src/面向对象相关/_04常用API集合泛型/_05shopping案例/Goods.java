package 面向对象相关._04常用API集合泛型._05shopping案例;

public class Goods {
    private String id;
    private String name;
    private double price;
    private String simple_price;

    public Goods(String id, String name, double price, String simple_price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.simple_price = simple_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSimple_price() {
        return simple_price;
    }

    public void setSimple_price(String simple_price) {
        this.simple_price = simple_price;
    }
}
