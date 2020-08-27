package 面向对象相关._03多态_包_权限修饰符._06发工资逻辑;

public class Company implements Money {
    private double totalMoney;

    public Company(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public void paySalary(Employee e) {
        totalMoney -= e.getXinZi();
        System.out.println("给发工资了" + e.getName() + e.getXinZi() + "公司剩余了" + totalMoney);

    }
}
