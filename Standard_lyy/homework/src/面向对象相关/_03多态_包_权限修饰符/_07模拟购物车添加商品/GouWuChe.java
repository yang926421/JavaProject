package 面向对象相关._03多态_包_权限修饰符._07模拟购物车添加商品;

import java.util.ArrayList;
import java.util.List;

public class GouWuChe {
    List<Goods> list1 = new ArrayList<>();

    public GouWuChe() {

    }

    //在购物车类中定义addGoods方法
    public void addGoods(Goods goods) {
        System.out.println("加入" + goods.getName() + "成功");
        list1.add(goods);
    }

    public void showGoods() {
        System.out.println("您选购的商品为=======");
        for (int i = 0; i < list1.size(); i++) {
            Goods goods = list1.get(i);
            System.out.println("\t" + goods.getId() + goods.getName() + goods.getPrice());
        }
    }

    public void totalMoney() {
        double off = 0;
        double on = 0;

        for (int i = 0; i < list1.size(); i++) {
            Goods goods = list1.get(i);
            on += goods.getPrice();
            if (goods instanceof EGoods) {
                off += goods.getPrice() * 0.88;
            } else {
                off += goods.getPrice();
            }
        }
        System.out.println("原价为" + on);
        System.out.println("折扣价为" + off);

    }
}
