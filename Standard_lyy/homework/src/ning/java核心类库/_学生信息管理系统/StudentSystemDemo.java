package ning.java核心类库._学生信息管理系统;


import java.util.*;


public class StudentSystemDemo {
    public static final List<student> list = new ArrayList<>();
    public static final Scanner sc = new Scanner(System.in);

    static {
        //创建几个学生对象
        student stu = new student("001", "lyy", "20");
        student stu1 = new student("002", "lyy2", "21");
        student stu2 = new student("003", "lyy3", "22");
        list.add(stu);
        list.add(stu1);
        list.add(stu2);
    }

    public static void main(String[] args) {
        System.out.println("=====欢迎光临学生管理系统========");
        System.out.println("请进行你想执行的操作");
        System.out.println("1.增加学生信息        2.删除学生信息      " +
                "3.修改学生信息         4.查找学生信息            5.查看所有学生信息");
        String str = sc.nextLine();
        switch (str) {
            case "insert":
                addStudent();
                break;
            case "delete":
                break;
            case "update":
                break;
            case "query":
                break;
            case "iterable":
                interableStudent();
                break;
            default:
                System.err.println("您的命令输入有无，请重新确认！");
                System.err.println("您的命令输入有无，请重新确认！");
        }
    }
// 判断用户的命令是想干啥

    public static void addStudent() {
        System.out.println("请输入你要添加的学生信息 以,分隔开");


    }

    public static void interableStudent() {
        for (student student : list) {
            System.out.println(student);
        }
    }

}
