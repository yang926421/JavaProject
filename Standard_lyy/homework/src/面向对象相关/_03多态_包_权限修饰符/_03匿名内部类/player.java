package 面向对象相关._03多态_包_权限修饰符._03匿名内部类;

public abstract class player  {
    private String name;
    private  String age;

    public player(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public abstract void playBasketBall();
    public  abstract void playPingPang();
}
