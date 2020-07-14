package ning.java核心类库._学生信息管理系统;

public class student {
    private String xueHao;
    private String name;
    private String age;

    public student(String xueHao, String name, String age) {
        this.xueHao = xueHao;
        this.name = name;
        this.age = age;
    }

    public String getXueHao() {
        return xueHao;
    }

    public void setXueHao(String xueHao) {
        this.xueHao = xueHao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "xueHao='" + xueHao + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
