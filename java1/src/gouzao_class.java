public class gouzao_class {
    String name;
    int speed;

    public gouzao_class(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void run() {
        System.out.println(this.name + "帅");
    }

    public static void main(String[] args) {
        gouzao_class g1 = new gouzao_class("lyy", 18);
        g1.run();
    }
}
