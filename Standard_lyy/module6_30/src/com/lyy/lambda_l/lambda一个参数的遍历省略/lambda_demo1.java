package com.lyy.lambda_l.lambda一个参数的遍历省略;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class lambda_demo1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("lyy");
        names.add("hht");
        names.add("lll1");
    /**
     * foreach的底层写法 接受的是一个Consumer对象
     default void forEach(Consumer<? super T> action) {
     Objects.requireNonNull(action);
     for (T t : this) {
     action.accept(t);
     }
     }
     */
    //调用匿名内部类写法
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //使用lambda表达式省略
        names.forEach((String s1) ->{
            System.out.println(s1);
        });
        //省略参数和大括号
        names.forEach((s) -> System.out.println(s));

        //只有一个参数,()可以省略
        names.forEach(s -> System.out.println(s));
    }
}
