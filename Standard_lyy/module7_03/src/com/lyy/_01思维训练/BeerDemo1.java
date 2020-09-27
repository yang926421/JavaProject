package com.lyy._01思维训练;

/**
 * 题目  给你十块钱 去买啤酒  两块钱一瓶啤酒,四个盖子可以换一瓶啤酒,两个瓶子可以换一瓶啤酒,问到最后一共可以喝多少啤酒,剩下多少瓶子和多少盖子
 */
public class BeerDemo1 {
    public static int total_num;
    private static int PingZi_count;
    private static int GaiZi_count;

    //非规律性递归问题
    public static void main(String[] args) {
//        buy_beer(10);
//        System.out.println("一共买了" + total_num + "瓶啤酒");
//        System.out.println("剩余盖子" + GaiZi_count);
//        System.out.println("剩余瓶子" + PingZi_count);
        int f = f(3);
        System.out.println(f);
    }


    public static int f(int a){
        return a==1?a:a*f(a-1);

    }

    public static void buy_beer(int money) {
        //拿钱买酒
        int number = money / 2;

        total_num += number;

        int total_money = 0;
        //算出当前的瓶子数和盖子数
        int current_ping_count = PingZi_count + number;
        int current_gai_count = GaiZi_count + number;
        //换算成前
        total_money += (current_gai_count / 4) * 2;
        total_money += (current_ping_count / 2) * 2;
        //计算剩余的盖子和瓶子
        PingZi_count = current_ping_count % 2;
        GaiZi_count = current_gai_count % 4;
        // 继续拿钱去买酒
        if (total_money >= 2) {
            buy_beer(total_money);
        }

    }
}
