package com.java.meiju;

/**
 * 枚举来做信息标志和信息分类可以约定后续人员开发,如果用变量来做分类和开发
 * 会导致move参数随机填写,随意改动
 */
enum Oritation {
    UP, DOWN, LEFT, RIGHT;
}

public class second_enum {
    //    public static final int UP = 0; // 定义常量
//    public static final int DOWN = 1;
//    public static final int LEFT = 2;
//    public static final int RIGHT = 3;
    public static void main(String[] args) {
        move(Oritation.LEFT);
    }

    //控制玛丽的移动
    public static void move(Oritation oritation) {
        switch (oritation) {
            case UP:
                System.out.println("控制玛丽向上移动");
                break;
            case DOWN:
                System.out.println("控制玛丽向下移动");
                break;
            case LEFT:
                System.out.println("控制玛丽向左移动");
                break;
            case RIGHT:
                System.out.println("控制玛丽向右移动");
                break;
        }
    }

}

