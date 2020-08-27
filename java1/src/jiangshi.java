public class jiangshi {
    String name;
    int xueliang;
    int hit;

    //构造方法
    public jiangshi(String name, int xueliang, int hit) {
        this.name = name;
        this.xueliang = xueliang;
        this.hit = hit;

    }

    public void zhan(zhiwu zw) {
        System.out.println(this.name + "正在打" + zw.name + "植物");
        //减少植物的血量
    }
}
