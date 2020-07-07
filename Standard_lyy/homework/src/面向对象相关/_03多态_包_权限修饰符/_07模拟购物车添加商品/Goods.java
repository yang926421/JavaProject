package 面向对象相关._03多态_包_权限修饰符._07模拟购物车添加商品;

public class Goods {
    private String name;
    private String id;
    private double price;

    public Goods(){

    }
    public Goods(String name, String id, double price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
