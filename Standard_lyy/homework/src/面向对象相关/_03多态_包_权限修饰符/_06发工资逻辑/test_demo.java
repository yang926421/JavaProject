package 面向对象相关._03多态_包_权限修饰符._06发工资逻辑;

public class test_demo {
    public static void main(String[] args) {
        Company company = new Company(1000000.0);
        Manager manager = new Manager("经理", 8000);
        Coder coder = new Coder("兔头怪", 10000);
        company.paySalary(manager);
        company.paySalary(coder);
    }
}
