package com.lyy._02method_quote2.方法引用的四种形式._01静态方法;

public class student {
    private String name;
    private int age ;
    private char sex ;

    public student(){

    }
    public student(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public static int compareByAge(student o1 , student o2){
        return  o1.getAge() - o2.getAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
