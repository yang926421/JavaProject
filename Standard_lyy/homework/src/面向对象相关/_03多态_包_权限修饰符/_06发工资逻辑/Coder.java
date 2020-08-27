package 面向对象相关._03多态_包_权限修饰符._06发工资逻辑;

public class Coder extends Employee {
    public Coder(String name, int xinZi) {
        super(name, xinZi);
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
    public int getXinZi() {
        return super.getXinZi();
    }

    @Override
    public void setXinZi(int xinZi) {
        super.setXinZi(xinZi);
    }
}
