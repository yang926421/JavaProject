package 面向对象相关._03多态_包_权限修饰符._06发工资逻辑;

/**
 * 员工类
 */
public class Employee {
    private String name;
    private int xinZi;

    public Employee(String name, int xinZi) {
        this.name = name;
        this.xinZi = xinZi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXinZi() {
        return xinZi;
    }

    public void setXinZi(int xinZi) {
        this.xinZi = xinZi;
    }
}
