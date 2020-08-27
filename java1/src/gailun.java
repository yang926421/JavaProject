public class gailun {
    String name;
    String skill_q;
    String skill_w;
    String skill_e;
    String skill_r;

    public gailun(String name) {
        this.name = name;
    }

    public gailun(String name, String skill_q, String skill_w, String skill_e, String skill_r) {
        // 调用当前类中的其他构造方法
        this(name);
        this.skill_r = skill_r;
        this.skill_e = skill_e;
        this.skill_q = skill_q;
        this.skill_w = skill_w;

    }

    public void fight() {
        System.out.println(this.name + "在上阵杀敌," + "用了" + this.skill_r + "技能");
    }

    public static void main(String[] args) {
        gailun hero = new gailun("德玛", "小保健", "护盾", "转圈圈", "大宝剑");
        hero.fight();

    }
}
