public class changjing {
    public static void main(String[] args) {
        jiangshi js = new jiangshi("豌豆", 1000, 20);
        zhiwu zw = new zhiwu("铁通僵尸", 1000, 30);
        js.zhan(zw);
        zw.zhan(js);

    }
}
