package com.java.genericity;

public interface Data<E> {
    void add(E stu);
    void delete(E stu);
    void update(E stu);
    void query(E stu);
}
