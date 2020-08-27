public class zhiwu {
    String name;
    int xueliang;
    int hit;

    //构造方法
    public zhiwu(String name, int xueliang, int hit) {
        this.name = name;
        this.xueliang = xueliang;
        this.hit = hit;

    }

    //植物打僵尸
    public void zhan(jiangshi js) {
        System.out.println(this.name + "正在打" + js.name + "僵尸");
        js.xueliang -= this.hit;
        System.out.println("僵尸的血量剩余+" + js.xueliang);
    }
}
