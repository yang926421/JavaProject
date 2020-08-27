package 面向对象相关._02abstruct作业._02test;

public class Manager extends employee {
    public Manager(String gongHao, String name, String money) {
        super(gongHao, name, money);
    }

    @Override
    public String getGongHao() {
        return super.getGongHao();
    }

    @Override
    public void setGongHao(String gongHao) {
        super.setGongHao(gongHao);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getMoney() {
        return super.getMoney();
    }

    @Override
    public void setMoney(String money) {
        super.setMoney(money);
    }

    @Override
    void eat() {
        System.out.println("经理吃好的");
    }

    @Override
    void work() {
        System.out.println("经理工资高 干活轻松");
        super.run();
    }
}
