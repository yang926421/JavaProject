package 面向对象相关._03多态_包_权限修饰符.测试;

public class test_demo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("lyy",21);
        sportTeacher t2 = new sportTeacher("lyy2", 22);
        Student s1 = new Student("hht", 21);
        sportStudent s2 = new sportStudent("hht2", 20);
        playSport(t2);
        playSport(s2);
//        playSport(s1);  //没有实现sport接口  无法传入



    }
    public static void playSport(sport s){
        s.playBasketBall();
    }

}
