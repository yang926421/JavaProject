package 面向对象相关._02abstruct作业._02test;

public abstract class employee {
    private String gongHao;
    private String name;
    private String money;

    public employee(String gongHao,String name,String money ){
        this.gongHao = gongHao;
        this.name = name;
        this.money = money;
    }

    public String getGongHao() {
        return gongHao;
    }

    public void setGongHao(String gongHao) {
        this.gongHao = gongHao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    abstract void eat();
    abstract void work();
}
