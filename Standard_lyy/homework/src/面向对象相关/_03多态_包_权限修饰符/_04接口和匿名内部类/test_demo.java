package 面向对象相关._03多态_包_权限修饰符._04接口和匿名内部类;

public class test_demo{
    public static void main(String[] args) {
        player p1 = new player() {
            @Override
            public void playerBasketBall() {
                System.out.println("打篮球呀");
            }

            @Override
            public void playerPingPang() {
                System.out.println("打乒乓球呀");
            }
        };
        p1.playerBasketBall();
        p1.playerPingPang();
    }

}
