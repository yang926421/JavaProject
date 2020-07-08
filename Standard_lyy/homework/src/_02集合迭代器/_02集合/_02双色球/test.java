package _02集合迭代器._02集合._02双色球;

import java.util.HashSet;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        Random ran = new Random();
        HashSet<Integer> hs = new HashSet<>();
        while (hs.size()<6){
            hs.add(ran.nextInt(33)+1);
        }
        // 5.在生成一个红球
        int blueBall = ran.nextInt(16) + 1;

        // 6.打印中奖号码
        System.out.println("双色球中奖号码:");
        System.out.print("红球是: ");

        for (Integer redBall : hs) {
            System.out.print(redBall + " ");
        }

        System.out.println();
        System.out.println("蓝球是: " + blueBall);
    }
}
