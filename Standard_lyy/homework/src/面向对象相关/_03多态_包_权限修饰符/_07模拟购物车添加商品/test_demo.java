package 面向对象相关._03多态_包_权限修饰符._07模拟购物车添加商品;

public class test_demo {
    public static void main(String[] args) {
        Goods good = new EGoods("笔记本", "g10000", 10000);
        phone p1 = new phone("手机", "g10001", 5000);
        Fruit f1 = new Fruit("苹果", "g20000", 50);
        GouWuChe gouWuChe = new GouWuChe();
        gouWuChe.addGoods(good);
        gouWuChe.addGoods(p1);
        gouWuChe.addGoods(f1);
        gouWuChe.showGoods();
        gouWuChe.totalMoney();
    }
}
