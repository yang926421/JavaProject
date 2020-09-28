//package cn.gsxt.reflect;
//
//public class Demo02 {
//    public static void main(String[] args) throws Exception{
//        Person person = new Student();
//        System.out.println("这个人的名字"+person.name);
//
//        Class<? extends Person> aClass = person.getClass();
//
//        Class<?> aClass1 = Class.forName("cn.gsxt.reflect.Student");
//
//        System.out.println(aClass.hashCode());
//        System.out.println(aClass1.hashCode());
//
//        System.out.println(aClass.getSuperclass());
//
//
//
//
//
//
////        Student student = new Student();
////        System.out.println("这个人是"+student.name);
//    }
//
//}
//
//class Person{
//    String name;
//
//    public Person(){
//
//    }
//    public Person(String name){
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
//
////class Student extends Person{
////    public Student(){
////        this.name = "学生";
////    }
////}
//
//class Teacher extends Person{
//    public Teacher(){
//        this.name = "老师";
//    }
//}
