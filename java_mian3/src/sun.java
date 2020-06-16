public class sun extends Hero {
    String name = "hht";
    public sun(){
        super("hht");
        System.out.println("这是子类的构造方法");
    }

    public void chi(){
        //想看到父类中的name
        System.out.println(super.name);
        //看到自己的name
        System.out.println(this.name + "在吃桃子");
    }

    public static void main(String[] args) {
        sun s = new sun();
        s.chi();
    }
}
