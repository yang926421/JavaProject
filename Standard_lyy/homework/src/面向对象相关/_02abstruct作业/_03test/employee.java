package 面向对象相关._02abstruct作业._03test;

public abstract class employee {
private String name;
private String bianHao;

    public employee(String name, String bianHao) {
        this.name = name;
        this.bianHao = bianHao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBianHao() {
        return bianHao;
    }

    public void setBianHao(String bianHao) {
        this.bianHao = bianHao;
    }

    abstract void work();
}
