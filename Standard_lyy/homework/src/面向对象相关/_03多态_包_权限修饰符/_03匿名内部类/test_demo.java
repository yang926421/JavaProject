package 面向对象相关._03多态_包_权限修饰符._03匿名内部类;

public class test_demo {
    public static void main(String[] args) {
        player p1 = new player("lyy", "21") {
            @Override
            public void playBasketBall() {
                System.out.println("这是匿名方法  不用再重写个方法体 ");
            }

            @Override
            public void playPingPang() {
                System.out.println("打乒乓球");
            }
        };
        p1.playBasketBall();
        p1.playPingPang();
    }
}
