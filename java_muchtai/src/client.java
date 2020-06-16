public class client {
    public static void main(String[] args) {
//        cat c = new cat();
//        dog d = new dog();
//        person p1 = new person();
//        p1.feed_cat(c);
//        p1.feed_dog(d);
        //可以把猫当成动物来看 把子类的对象赋值给父类的引用(变量),向上转型
        animal c = new cat();
        person p1 = new person();
        p1.feed(c);

    }

}
