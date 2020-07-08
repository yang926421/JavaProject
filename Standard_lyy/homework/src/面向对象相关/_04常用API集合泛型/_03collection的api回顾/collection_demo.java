package 面向对象相关._04常用API集合泛型._03collection的api回顾;

import java.util.ArrayList;
import java.util.Collection;

public class collection_demo {
    public static void main(String[] args) {
        //创建collection集合
        Collection<String> col = new ArrayList<>();
        col.add("张无忌");
        col.add("赵敏");
        col.add("周芷若");
        //
        col.remove("周芷若");

    }
}
