package 面向对象相关._02abstruct作业._03test;

public class AdminStaff extends employee {
    public AdminStaff(String name, String bianHao) {
        super(name, bianHao);
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
    public String getBianHao() {
        return super.getBianHao();
    }

    @Override
    public void setBianHao(String bianHao) {
        super.setBianHao(bianHao);
    }

    @Override
    void work() {

    }
}
