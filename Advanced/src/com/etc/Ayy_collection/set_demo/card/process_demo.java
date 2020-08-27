package com.etc.Ayy_collection.set_demo.card;

import java.util.*;

public class process_demo {
    //定义一个hashmap用来存放
    // 定义一个ArrayList用来存放54张牌
    public static final Map<card_demo, Integer> all_card_demo_sizes = new HashMap<>();
    public static final List<card_demo> all_card_demos = new ArrayList<>();

    //静态代码块
    static {
        //定义一个数组存储牌的点数
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //定义一个数组存储牌的花色,类型确定个数确定用数组来存储
        String[] colors = {"♠", "♥", "♣", "♦"};
        //先遍历点数与四种花色组装成牌存到集合中去
        int index = 0;
        for (String number : numbers) {
            for (String color : colors
            ) {
                //创建一张牌封装点数和花色
                card_demo card_demo = new card_demo(number, color);
                all_card_demo_sizes.put(card_demo, index++);
                all_card_demos.add(card_demo);
            }
        }
        card_demo c1 = new card_demo("", "小王");
        card_demo c2 = new card_demo("", "大王");
        all_card_demo_sizes.put(c1, index++);
        all_card_demo_sizes.put(c2, index++);
        System.out.println("新牌" + all_card_demos);


    }

    public static void main(String[] args) {
        /**
         c.洗牌(把新牌的牌顺序打乱)
         */
        Collections.shuffle(all_card_demos);
        System.out.println("洗牌后：" + all_card_demos);

        /**
         d.定义3个玩家。
         */
        List<card_demo> lingHuChong = new ArrayList<>();
        List<card_demo> jiuMoZhi = new ArrayList<>();
        List<card_demo> dongfangbubai = new ArrayList<>();

        /**
         e.发牌 依次发出51张牌出去。
         all_card_demos = [J♠, 5♠, 2♠, 9♣, 5♦, 4♠, Q♣, 6♥, 8♠, ......
         0   1   2   3   4    5   6   7   8   % 3（轮询的长度）
         */
        for (int i = 0; i < all_card_demos.size() - 3; i++) {
            // 得到当前这张牌对象
            card_demo c = all_card_demos.get(i);
            // 判断这个牌发给谁
            if (i % 3 == 0) {
                // 请令狐冲接牌
                lingHuChong.add(c);
            } else if (i % 3 == 1) {
                // 请啊鸠接牌
                jiuMoZhi.add(c);
            } else if (i % 3 == 2) {
                // 请阿东接牌
                dongfangbubai.add(c);
            }
        }

        /**
         * f.对牌进行排序（拓展,了解）
         */
        sortcard_demos(lingHuChong);
        sortcard_demos(jiuMoZhi);
        sortcard_demos(dongfangbubai);

        /**
         g.看牌
         */
        System.out.println("令狐冲：" + lingHuChong);
        System.out.println("鸠摩智：" + jiuMoZhi);
        System.out.println("东方不败：" + dongfangbubai);
        //System.out.println("底牌："+all_card_demos.get(53) +"-"+all_card_demos.get(52) + "-" +all_card_demos.get(51) );
        // 拓展: 截取集合的最后三张牌到一个新的List集合中去。
        List<card_demo> lastThreecard_demos = all_card_demos.subList(all_card_demos.size() - 3, all_card_demos.size());
        System.out.println("底牌：" + lastThreecard_demos);

    }

    /**
     * 对牌的List集合进行排序（降序排序）
     */
    private static void sortcard_demos(List<card_demo> card_demos) {
        // card_demos = [ 3♦ , 👲,  10♣ , 9♦ , 8♦ , J♠ , ...
        Collections.sort(card_demos, new Comparator<card_demo>() {
            @Override
            public int compare(card_demo o1, card_demo o2) {
                return all_card_demo_sizes.get(o2) - all_card_demo_sizes.get(o1);
            }
        });
//        Collections.sort(card_demos, new Comparator<card_demo>() {
//            @Override
//            public int compare(card_demo o1, card_demo o2) {
//                // o1   Q♦
//                // o2   👲
//                // 牌的大小就是当前牌在Map集合中的值存储的大小！
//                return all_card_demo_sizes.get(o2) - all_card_demo_sizes.get(o1);
//            }
//        });
    }
}









